package br.com.danluan.seuJob.repository;

import br.com.danluan.seuJob.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Integer> {
}
