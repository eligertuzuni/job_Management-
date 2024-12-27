package com.management.firstjobapp.job;

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
    public List<Job> findAll() {
        return jobService.findAll();
    }

    // on the same end-point we will post jobs using PostMapping
    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return "Job added sucessully";
    }

    // implementing getting the job by ID and adding to the url
    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable Long id) {
        Job job = jobService.getJobById(id);
        if(job != null) {
            return job;
        }
        return new Job(1L, "Test Jobs", "Just for test", "300", "400", "Albania");

    }

}
