package br.com.danluan.seuJob.controller;

import br.com.danluan.seuJob.model.Application;
import br.com.danluan.seuJob.service.ApplicationService;
import br.com.danluan.seuJob.service.JobService;
import br.com.danluan.seuJob.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("application")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private UserService userService;

    @Autowired
    private JobService jobService;

    @RequestMapping("/form/{id}")
    public String showFormApplication(Model model, @PathVariable Integer id) {
        model.addAttribute("application", new Application());
        model.addAttribute("job", jobService.getJob(id));
        model.addAttribute("users", userService.getUsersAppliedJobById(id));
        return "application/formApplication";
    }

    @RequestMapping("/create/{id}")
    public String createApplication(@ModelAttribute("application") Application application, @PathVariable Integer id) {
        applicationService.createApplication(application, id);
        return "redirect:/job/details/" + id;
    }
}
