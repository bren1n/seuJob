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
			User user = new User("Daniel", "dan@luan", "(63) 97112-2773", "1234");
			User user2 = new User("Brenin", "bre@nin", "(92) 99738-4476", "124412");
			Resume resume = new Resume("Java Developer", "IMD", "Java, Spring, Hibernate");
//			Resume resume2 = new Resume("Java Developer", "IMD", "Java, Spring, Hibernate");
			user.setResume(resume);
//			user2.setResume(resume2);

			userRepository.save(user);
			userRepository.save(user2);

			Company company = new Company("Microsoft", "microsoft@microsoft.com", "1234", "(11) 1111-1111");
			Company company2 = new Company("Samsung", "samsung@samsung.com", "1234", "(11) 1111-1111");
			companyRepository.save(company);
			companyRepository.save(company2);

			Job job = new Job("Java Developer Estágio", "Java, Spring, Hibernate", "Presencial", "CLT", 1000.0F);
			job.setCompany(company);
			Job job2 = new Job("Java Developer Junior", "Java, Spring, Hibernate", "Presencial", "CLT", 2000.0F);
			job2.setCompany(company2);
			Job job3 = new Job("Java Developer Pleno", "Java, Spring, Hibernate", "Presencial", "CLT", 3000.0F);
			job3.setCompany(company);
			Job job4 = new Job("Java Developer Sênior", "Java, Spring, Hibernate", "Presencial", "CLT", 4000.0F);
			job4.setCompany(company);
			Job job5 = new Job("QA", "Python, JavaScript", "Remoto", "PJ", 3400.0F);
			job5.setCompany(company2);
			jobRepository.save(job);
			jobRepository.save(job2);
			jobRepository.save(job3);
			jobRepository.save(job4);
			jobRepository.save(job5);

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
