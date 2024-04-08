package br.com.danluan.seuJob.service;

import br.com.danluan.seuJob.model.Job;
import br.com.danluan.seuJob.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public List<Job> getJobsFiltered(String title, String location, Float salary, String contractType) {
        List<Job> jobs = jobRepository.findAll();
        return jobs.stream().filter(job -> {
            return job.getTitle().contains(title) && job.getLocation().contains(location) && job.getSalary() >= (salary) && job.getContractType().contains(contractType);
        }).toList();
    }

    public List<Job> findAllJobs() {
        return jobRepository.findAll();
    }

    public Job getJob(Integer id) {
        return jobRepository.findById(id).map(job
                -> {
            return job;
        }).orElseThrow(() -> null);
    }

    public void createJob(Job job) {
        jobRepository.save(job);
    }

    public void updateJob(Integer id, String title, String location, Float salary, String contractType) {
        Job job = this.getJob(id);
        job.setTitle(title);
        job.setLocation(location);
        job.setSalary(salary);
        job.setContractType(contractType);
        jobRepository.save(job);
    }

    public void deleteJob(Integer id) {
        jobRepository.deleteById(id);
    }
}
