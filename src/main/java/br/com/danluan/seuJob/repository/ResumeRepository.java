package br.com.danluan.seuJob.repository;

import br.com.danluan.seuJob.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Integer> {
}
