package br.com.danluan.seuJob;

import br.com.danluan.seuJob.model.Resume;
import br.com.danluan.seuJob.model.User;
import br.com.danluan.seuJob.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SeuJobApplication {

	@Autowired
	UserRepository userRepository;

	@Bean
	public CommandLineRunner init() {
		return args -> {
			User user = new User();
			user.setName("Dan Luan");
			user.setEmail("dan@");
			user.setPassword("123");
			user.setPhoneNumber("123456789");
			Resume resume = new Resume("Java Developer", "IMD", "Java, Spring, Hibernate");
			user.setResume(resume);
			userRepository.save(user);
		};

	}

	public static void main(String[] args) {
		SpringApplication.run(SeuJobApplication.class, args);
	}

}
