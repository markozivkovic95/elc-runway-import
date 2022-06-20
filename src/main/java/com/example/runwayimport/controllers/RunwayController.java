package com.example.runwayimport.controllers;

import java.util.List;

import com.example.runwayimport.models.JobDTO;
import com.example.runwayimport.models.RunwayRequestDTO;
import com.example.runwayimport.services.JobsService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/runway")
public class RunwayController {

    private final JobsService jobsService;

    public RunwayController(final JobsService jobsService) {
        this.jobsService = jobsService;
    }
    
    @PostMapping
    public ResponseEntity<List<JobDTO>> runwayPost(@RequestBody final RunwayRequestDTO requestModel) {
        
        return new ResponseEntity<>(this.jobsService.findAllJobs(), HttpStatus.CREATED);
    }

}
