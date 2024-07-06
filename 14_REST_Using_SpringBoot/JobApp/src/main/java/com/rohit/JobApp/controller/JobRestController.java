package com.rohit.JobApp;

import com.rohit.JobApp.model.JobPost;
import com.rohit.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class JobRestController {
    @Autowired
    private JobService service;
    @GetMapping("/jobPosts")
    public List<JobPost> getAllJobs(){
        return service.returnAllJobPosts();
    }
}
