package br.com.danluan.seuJob.controller;

import br.com.danluan.seuJob.model.Resume;
import br.com.danluan.seuJob.service.ResumeService;
import br.com.danluan.seuJob.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("resume")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public String listResume(Model model) {
        List<Resume> resumes = resumeService.getResumes();
        model.addAttribute("resumes", resumes);
        return "resume/listResume";
    }

    @RequestMapping(value = {"/form", "/form/{id}"})
    public String showFormResume(Model model, @PathVariable(required = false) Integer id) {
        if (id != null) {
            model.addAttribute("resume", resumeService.getResume(id));
            model.addAttribute("action", "edit");
        } else {
            model.addAttribute("resume", new Resume());
            model.addAttribute("users", userService.getUsersResumeNull());
            model.addAttribute("action", "create");
        }

        return "resume/formResume";
    }

    @RequestMapping("/create")
    public String createResume(@ModelAttribute("resume") Resume resume) {
        resumeService.createResume(resume);
        return "redirect:/resume/list";
    }

    @RequestMapping("/edit/{id}")
    public String editResume(@PathVariable Integer id, @ModelAttribute("resume") Resume resume) {
        resumeService.updateResume(
            resume.getId(),
            resume.getExperiences(),
            resume.getEducation(),
            resume.getSkills()
        );

        return "redirect:/resume/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteResume(@PathVariable Integer id) {
        resumeService.deleteResume(id);
        return "redirect:/resume/list";
    }
}
