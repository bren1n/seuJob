package br.com.danluan.seuJob.repository;

import br.com.danluan.seuJob.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
}
