package br.com.danluan.seuJob.controller;

import br.com.danluan.seuJob.model.Job;
import br.com.danluan.seuJob.model.User;
import br.com.danluan.seuJob.service.CompanyService;
import br.com.danluan.seuJob.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;


import java.util.List;

@Controller
@RequestMapping("job")
public class JobController {
    @Autowired
    private JobService jobService;

    @Autowired
    private CompanyService companyService;

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

    @RequestMapping("/details/{id}")
    public String detailsJob(@PathVariable int id, Model model) {
        model.addAttribute("job", jobService.getJob(id));
        return "job/detailsJob";
    }

    @RequestMapping(value = {"/form", "/form/{id}"})
    public String showFormJob(@PathVariable(required = false) Integer id, Model model) {

        model.addAttribute("companies", companyService.getCompanies());
        if (id != null) {
            model.addAttribute("job", jobService.getJob(id));
            model.addAttribute("action", "edit");
        } else {
            model.addAttribute("job", new Job());
            model.addAttribute("action", "create");
        }

        return "job/formJob";
    }

    @RequestMapping("/create")
    public String createJob(@ModelAttribute("job") Job job) {
        jobService.createJob(job);
        return "redirect:/job/list";
    }

    @RequestMapping("/edit/{id}")
    public String editJob(@ModelAttribute("job") Job job, @PathVariable Integer id) {
        jobService.updateJob(
            id,
            job.getTitle(),
            job.getLocation(),
            job.getSalary(),
            job.getContractType()
        );

        return "redirect:/job/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteJob(@PathVariable Integer id) {
        jobService.deleteJob(id);
        return "redirect:/job/list";
    }
}
