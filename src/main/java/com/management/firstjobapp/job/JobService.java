package com.management.firstjobapp.job;

import java.util.List;

public interface JobService {
    // we create this interface for Loose Coupling to separate the interface with the implementation

   List<Job> findAll();
   void createJob(Job job);

    Job getJobById(Long id);
    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updateJob);
}
