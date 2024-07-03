package com.rohit.JobApp.service;

import com.rohit.JobApp.model.JobPost;
import com.rohit.JobApp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    public JobRepo repo;

    public List<JobPost> returnAllJobPosts(){
        return repo.getJobs();
    }

    public void addJobPost(JobPost job){
        repo.addJobPost(job);
    }
}
