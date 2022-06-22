package com.example.runwayimport.businessservices;

import java.util.List;

import com.example.runwayimport.constants.TechnicalNameConstants;
import com.example.runwayimport.enums.GeographicLevelEnum;
import com.example.runwayimport.enums.InheritFromParentEnum;
import com.example.runwayimport.enums.JobStatusEnum;
import com.example.runwayimport.models.CustomValueDTO;
import com.example.runwayimport.models.JobCreateDTO;
import com.example.runwayimport.models.JobDTO;
import com.example.runwayimport.models.JobUpdateDTO;
import com.example.runwayimport.models.RunwayRequestDTO;
import com.example.runwayimport.models.SearchParamsDTO;
import com.example.runwayimport.services.JobService;
import com.example.runwayimport.utils.JobUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class JobBusinessService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(JobBusinessService.class);
    private static final String NO_PARENT_JOB = "-1";

    private final JobService jobService;

    public JobBusinessService(final JobService jobService) {
        this.jobService = jobService;
    }

    public JobDTO importRunwayJob(final RunwayRequestDTO request) {

        final SearchParamsDTO searchParams = JobUtils.searchRunwayJobsByNameRequest(request.getProgramName());

        final List<JobDTO> jobDTOs = this.jobService.findAllJobs(searchParams);
        final JobDTO jobDTO;

        if (CollectionUtils.isEmpty(jobDTOs)) {
            LOGGER.info("Creating new job: {}.", request.getProgramName());

            jobDTO = this.jobService.createJob(new JobCreateDTO(
                    JobUtils.RUNWAY_JOB_ID,
                    JobUtils.RUNWAY_WORKFLOW_ID,
                    request.getProgramName(),
                    NO_PARENT_JOB
            ));
        } else {
            jobDTO = jobDTOs.get(0);
        }

        LOGGER.info("Updating job with ID {}.", jobDTO.getInstanceId());
        
        final JobUpdateDTO jobUpdateDTO = JobUtils.createJobUpdateRequest(jobDTO, request);
        updateRunwayJobParameters(jobUpdateDTO);

        return this.jobService.updateJob(jobUpdateDTO);
    }

    private void updateRunwayJobParameters(final JobUpdateDTO jobUpdateDTO) {
    
        jobUpdateDTO.getValues().add(
            new CustomValueDTO(
                TechnicalNameConstants.PROCESSING_STATUS,
                InheritFromParentEnum.NOT_SUPPORTED.getKey(),
                String.format("\"%s\"", JobStatusEnum.READY_FOR_PROCESSING.getKey())
            )
        );
        jobUpdateDTO.getValues().add(
            new CustomValueDTO(
                TechnicalNameConstants.GEOGRAPHIC_LEVEL,
                InheritFromParentEnum.NOT_SUPPORTED.getKey(),
                String.format("\"%s\"", GeographicLevelEnum.GLOBAL.getKey()))
        );
        // TODO: Find enum
        jobUpdateDTO.getValues().add(
            new CustomValueDTO(
                TechnicalNameConstants.SUBSCRIBED,
                InheritFromParentEnum.NOT_SUPPORTED.getKey(),
                "\"2\""
            )
        );
        
        // TODO: Add Visible: Show
    }

}
