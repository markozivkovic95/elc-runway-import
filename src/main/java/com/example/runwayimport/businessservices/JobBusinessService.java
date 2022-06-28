package com.example.runwayimport.businessservices;

import java.util.List;
import java.util.Map;

import com.example.runwayimport.constants.TechnicalNameConstants;
import com.example.runwayimport.enums.GeographicLevelEnum;
import com.example.runwayimport.enums.InheritFromParentEnum;
import com.example.runwayimport.enums.JobStatusEnum;
import com.example.runwayimport.enums.SubscribedEnum;
import com.example.runwayimport.enums.VisibilityEnum;
import com.example.runwayimport.models.CustomStructureDTO;
import com.example.runwayimport.models.CustomValueDTO;
import com.example.runwayimport.models.JobCreateDTO;
import com.example.runwayimport.models.JobDTO;
import com.example.runwayimport.models.JobUpdateDTO;
import com.example.runwayimport.models.RunwayRequestDTO;
import com.example.runwayimport.models.SearchParamsDTO;
import com.example.runwayimport.services.JobService;
import com.example.runwayimport.services.ObjectsService;
import com.example.runwayimport.utils.JobUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class JobBusinessService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(JobBusinessService.class);
    private static final String NO_PARENT_JOB = "-1";
    private static final String JSON_FIELD_FORMAT = "\"%s\"";

    private final JobService jobService;
    private final ObjectsService objectsService;

    public JobBusinessService(final JobService jobService, final ObjectsService objectsService) {
        this.jobService = jobService;
        this.objectsService = objectsService;
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

        final Map<String, List<CustomStructureDTO>> customStructures = this.objectsService.getCustomStructures(jobDTO.getInstanceId());

        LOGGER.info("Updating job with ID {}.", jobDTO.getInstanceId());
        
        final JobUpdateDTO jobUpdateDTO = JobUtils.mapJobUpdateRequest(jobDTO, request, customStructures);
        updateRunwayJobParameters(jobUpdateDTO);

        return this.jobService.updateJob(jobUpdateDTO);
    }

    private void updateRunwayJobParameters(final JobUpdateDTO jobUpdateDTO) {
    
        jobUpdateDTO.getValues().add(
            new CustomValueDTO(
                TechnicalNameConstants.PROCESSING_STATUS,
                InheritFromParentEnum.NOT_SUPPORTED.getKey(),
                String.format(JSON_FIELD_FORMAT, JobStatusEnum.READY_FOR_PROCESSING.getKey())
            )
        );
        
        jobUpdateDTO.getValues().add(
            new CustomValueDTO(
                TechnicalNameConstants.GEOGRAPHIC_LEVEL,
                InheritFromParentEnum.NOT_SUPPORTED.getKey(),
                String.format(JSON_FIELD_FORMAT, GeographicLevelEnum.GLOBAL.getKey()))
        );

        jobUpdateDTO.getValues().add(
            new CustomValueDTO(
                TechnicalNameConstants.SUBSCRIBED,
                InheritFromParentEnum.NOT_SUPPORTED.getKey(),
                String.format(JSON_FIELD_FORMAT, SubscribedEnum.N.getKey())
            )
        );

        jobUpdateDTO.getValues().add(
            new CustomValueDTO(
                TechnicalNameConstants.VISIBLE,
                InheritFromParentEnum.NOT_SUPPORTED.getKey(),
                String.format(JSON_FIELD_FORMAT, VisibilityEnum.SHOW.getKey())
            )
        );
    }

}
