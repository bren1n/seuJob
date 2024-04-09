package br.com.danluan.seuJob.repository;

import br.com.danluan.seuJob.model.Application;
import br.com.danluan.seuJob.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    @Query(value = "SELECT * FROM TB_APPLICATION WHERE JOB_ID = :id", nativeQuery = true)
    List<Application> findAllByJobId(Integer id);
}
