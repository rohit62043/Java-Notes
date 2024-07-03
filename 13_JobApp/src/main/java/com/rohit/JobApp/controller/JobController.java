package com.rohit.JobApp.controller;

import org.springframework.ui.Model;
import com.rohit.JobApp.model.JobPost;
import com.rohit.JobApp.repo.JobRepo;
import com.rohit.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class JobController {
    @Autowired
    public JobService service;
    @GetMapping({"/","home"})
    public String home(){
        return "home";
    }

    @GetMapping("/addjob")
    public String addJob(){
        return "addjob";
    }

    @PostMapping("/handleForm")
    public String handleForm(JobPost jobPost){
        service.addJobPost(jobPost);
        return "success";
    }

    @GetMapping("/viewalljobs")
    public String viewJobs(Model m){
        List<JobPost> jobs=service.returnAllJobPosts();
        m.addAttribute("jobPosts", jobs);
        return "viewalljobs";
    }
}
