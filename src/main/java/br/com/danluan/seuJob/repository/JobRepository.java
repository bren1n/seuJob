package br.com.danluan.seuJob.repository;

import br.com.danluan.seuJob.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Integer> {
    @Query(value="SELECT * FROM TB_JOB AS A ORDER BY A.PUBLISH_DATE", nativeQuery = true)
    List<Job> findAll();
}
