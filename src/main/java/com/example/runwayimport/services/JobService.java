package com.example.runwayimport.services;

import java.util.List;
import java.util.Map;

import com.example.runwayimport.constants.EndpointConstants;
import com.example.runwayimport.constants.FieldNameConstants;
import com.example.runwayimport.models.JobCreateDTO;
import com.example.runwayimport.models.JobDTO;
import com.example.runwayimport.models.JobUpdateDTO;
import com.example.runwayimport.models.SearchParamsDTO;
import com.example.runwayimport.utils.JobUtils;
import com.example.runwayimport.utils.RestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class JobService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public JobService(final RestTemplateBuilder restTemplateBuilder, final ObjectMapper objectMapper) {

        this.restTemplate = restTemplateBuilder.basicAuthentication("filip.djordjevic", "EsteeLauder1")
                .build();
        this.objectMapper = objectMapper;
    }

    /**
     * Find all jobs by provided search criteria
     * 
     * @param searchParams Search params
     * @return found list of {@link JobDTO}
     */
    public List<JobDTO> findAllJobs(final SearchParamsDTO searchParams) {
        
        final Map<Object, Object> response = RestUtils.sendPostRequest(
                restTemplate,
                EndpointConstants.ELC_BRANDMAKER_JOBS_SEARCH,
                new HttpEntity<>(searchParams)
        );

        final Object jobs;

        if (response != null) {
            jobs = response.get(FieldNameConstants.VALUES_KEY);
        } else {
            jobs = null;
        }

        return this.objectMapper.convertValue(
                jobs,
                TypeFactory.defaultInstance().constructCollectionType(List.class, JobDTO.class)
        );
    }

    /**
     * Get the job by provided ID
     * 
     * @param id ID of the job
     * @return found {@link JobDTO}
     */
    public JobDTO getJobById(final Integer id) {

        final Map<Object, Object> responseBody = RestUtils.sendGetRequest(
                restTemplate,
                String.format(EndpointConstants.ELC_BRANDMAKER_DSE_OBJECT_WITH_ID, id)
        );
        
        return this.objectMapper.convertValue(responseBody, JobDTO.class);
    }

    /**
     * Create new job 
     * 
     * @param jobCreateDTO Job create parameters
     * @return created {@link JobDTO}
     */
    public JobDTO createJob(final JobCreateDTO jobCreateDTO) {

        final MultiValueMap<Object, Object> params = JobUtils.mapJobCreateRequest(jobCreateDTO);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        final Map<Object, Object> responseBody = RestUtils.sendPostRequest(
                restTemplate,
                EndpointConstants.INTERNAL_ELC_BRANDMAKER_DSE_OBJECT_CREATE,
                new HttpEntity<>(params, httpHeaders)
        );

        return this.objectMapper.convertValue(responseBody, JobDTO.class);
    }

    /**
     * Update job by provided parameters
     * 
     * @param jobUpdateDTO Job update parameters
     * @return updated {@link JobDTO}
     */
    public JobDTO updateJob(final JobUpdateDTO jobUpdateDTO) {

        final Map<Object, Object> responseBody = RestUtils.sendPostRequest(
                restTemplate,
                EndpointConstants.INTERNAL_ELC_BRANDMAKER_DSE_OBJECT_UPDATE,
                new HttpEntity<>(jobUpdateDTO)
        );

        return this.objectMapper.convertValue(responseBody, JobDTO.class);
    }

}
