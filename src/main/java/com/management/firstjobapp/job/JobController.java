package com.management.firstjobapp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
// here we create an end-point to find all the posted jobs using an arrayList
@RestController
public class JobController {

    // since we do not have a database we create an array list and moving to JobServiceImpl

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job> > findAll() {
        return ResponseEntity.ok(jobService.findAll());
    }

    // on the same end-point we will post jobs using PostMapping
    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>( "Job added sucessully",HttpStatus.OK);

    }

    // implementing getting the job by ID and adding to the url
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job = jobService.getJobById(id);
        if(job != null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
