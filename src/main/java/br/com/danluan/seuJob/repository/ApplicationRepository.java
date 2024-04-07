package br.com.danluan.seuJob.repository;

import br.com.danluan.seuJob.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
}
