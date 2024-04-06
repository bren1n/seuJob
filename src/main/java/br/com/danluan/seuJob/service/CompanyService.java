package br.com.danluan.seuJob.service;

import br.com.danluan.seuJob.model.Company;
import br.com.danluan.seuJob.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompany(Integer id) {
        return companyRepository.findById(id).map(company -> {
            return company;
        }).orElseThrow(() -> null);
    }

    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    public void updateCompany(Integer id, String name, String email, String password, String phoneNumber) {
        Company company = this.getCompany(id);
        company.setName(name);
        company.setEmail(email);
        company.setPassword(password);
        company.setPhoneNumber(phoneNumber);
        companyRepository.save(company);
    }

    public void deleteCompany(Integer id) {
        companyRepository.deleteById(id);
    }
}
