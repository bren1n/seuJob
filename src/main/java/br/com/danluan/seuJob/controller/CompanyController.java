package br.com.danluan.seuJob.controller;

import br.com.danluan.seuJob.model.Company;
import br.com.danluan.seuJob.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping("/list")
    public String listCompanies(Model model) {
        List<Company> companies = companyService.getCompanies();
        model.addAttribute("companies", companies);
        return "company/listCompany";
    }

    @RequestMapping(value = {"/form", "/form/{id}"})
    public String showFormCompany(@PathVariable(required = false) Integer id, Model model) {
        if (id != null) {
            model.addAttribute("company", companyService.getCompany(id));
            model.addAttribute("action", "edit");
        } else {
            model.addAttribute("company", new Company());
            model.addAttribute("action", "create");
        }

        return "company/formCompany";
    }

    @RequestMapping("/create")
    public String createCompany(@ModelAttribute("company") Company company) {
        companyService.createCompany(company);
        return "redirect:/company/list";
    }

    @RequestMapping("/edit/{id}")
    public String editCompany(@ModelAttribute("company") Company company, @PathVariable int id) {
        companyService.updateCompany(
            company.getId(),
            company.getName(),
            company.getEmail(),
            company.getPassword(),
            company.getPhoneNumber()
        );

        return "redirect:/company/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCompany(@PathVariable int id) {
        companyService.deleteCompany(id);
        return "redirect:/company/list";
    }
}
