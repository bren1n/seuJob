package br.com.danluan.seuJob.repository;

import br.com.danluan.seuJob.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>{

    @Query(value =
            "SELECT * " +
            "FROM TB_USER AS A " +
            "WHERE A.RESUME_ID IS NULL",
            nativeQuery = true)
   List<User> findAllByResumeIsNull();

    @Query(value = "SELECT A.* FROM TB_USER AS A WHERE ID NOT IN ( SELECT B.USER_ID FROM TB_APPLICATION AS B WHERE B.JOB_ID = :id ); ", nativeQuery = true)
    List<User> findAllBAppliedByJobId(Integer id);
}
