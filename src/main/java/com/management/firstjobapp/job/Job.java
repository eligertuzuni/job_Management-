package com.management.firstjobapp.job;

import com.management.firstjobapp.company.Company;
import jakarta.persistence.*;


// telling spring bot that this class will be used for the relational database
@Entity
/* @Table(name = "job_table")  if we don't want a table called job but job_table instead */
public class Job {

    @Id  /*Primary key */
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* ID managed by Entities */
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

    // for all this field we generate a constructor and all getter and setter methods
    // we create only one constructor with all fields which means every company when post a job is mandatory for all fields

    @ManyToOne
    private Company company;

    public Job() {
        /*Default constructor is a mast for entities */
    }

    public Job(Long id, String title, String description, String minSalary, String maxSalary, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    // all getter  and setter methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
