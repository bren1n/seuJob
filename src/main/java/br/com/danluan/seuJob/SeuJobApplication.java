package br.com.danluan.seuJob;

import br.com.danluan.seuJob.model.*;
import br.com.danluan.seuJob.repository.ApplicationRepository;
import br.com.danluan.seuJob.repository.CompanyRepository;
import br.com.danluan.seuJob.repository.JobRepository;
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

	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	ApplicationRepository applicationRepository;

	@Autowired
	JobRepository jobRepository;

	@Bean
	public CommandLineRunner init() {
		return args -> {
			User user = new User("Daniel", "dan@luan", "1234");
			User user2 = new User("Brenin", "dan@luan", "124412");
			Resume resume = new Resume("Java Developer", "IMD", "Java, Spring, Hibernate");
			Resume resume2 = new Resume("Java Developer", "IMD", "Java, Spring, Hibernate");
			user.setResume(resume);
			user2.setResume(resume2);

			userRepository.save(user);
			userRepository.save(user2);

			Company company = new Company("Empresa teste", "teste@teste.com", "1234", "(63) 3243-7746");
			companyRepository.save(company);

			//new job
			Job job = new Job("Java Developer", "Java, Spring, Hibernate", "Empresa teste", "CLT", 1000.20F);
			job.setCompany(company);
			jobRepository.save(job);
			System.out.println(job.getCompany().getName());

			//new application

			Application application = new Application(job, user);
			Application application2 = new Application(job, user2);

			applicationRepository.save(application);
			applicationRepository.save(application2);
		};

	}

	public static void main(String[] args) {
		SpringApplication.run(SeuJobApplication.class, args);
	}

}
