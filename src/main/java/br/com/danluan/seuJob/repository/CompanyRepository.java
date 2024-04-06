package br.com.danluan.seuJob.repository;

import br.com.danluan.seuJob.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
