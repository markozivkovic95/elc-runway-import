package com.example.runwayimport.controllers;

import com.example.runwayimport.businessservices.JobBusinessService;
import com.example.runwayimport.models.JobDTO;
import com.example.runwayimport.models.RunwayRequestDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/runway")
public class RunwayController {

    private final JobBusinessService jobBusinessService;

    public RunwayController(final JobBusinessService jobBusinessService) {
        this.jobBusinessService = jobBusinessService;
    }
    
    @PostMapping
    public ResponseEntity<JobDTO> runwayPost(@RequestBody final RunwayRequestDTO requestModel) {

        return new ResponseEntity<>(
            this.jobBusinessService.importRunwayJob(requestModel),
            HttpStatus.CREATED
        );
    }

}
