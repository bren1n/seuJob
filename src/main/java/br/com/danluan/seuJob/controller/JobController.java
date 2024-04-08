package br.com.danluan.seuJob.controller;

import br.com.danluan.seuJob.model.Job;
import br.com.danluan.seuJob.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("job")
public class JobController {
    @Autowired
    private JobService jobService;

    @RequestMapping("/list")
    public String listJob(Model model,
                          @RequestParam(required = false, defaultValue = "") String title ,
                          @RequestParam(required = false, defaultValue = "") String location ,
                          @RequestParam(required = false, defaultValue = "0") Float salary  ,
                          @RequestParam(required = false, defaultValue = "") String contractType ) {
        List<Job> jobs;
        if (title != null || location != null || (salary != null && salary > 0) || contractType != null) {
            jobs = jobService.getJobsFiltered(title, location, salary, contractType);
        } else {
            jobs = jobService.findAllJobs();
        }
        model.addAttribute("jobs", jobs);
        return "job/listJob";
    }
}
