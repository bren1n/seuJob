package br.com.danluan.seuJob.service;

import br.com.danluan.seuJob.enumerations.ApplicationStatus;
import br.com.danluan.seuJob.model.Application;
import br.com.danluan.seuJob.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private JobService jobService;

    public void createApplication(Application application, Integer id) {
        application.setStatus(ApplicationStatus.P);
        application.setJob(jobService.getJob(id));
        applicationRepository.save(application);
    }

    public Integer lengthApplicationsByJobId(Integer id) {
        return applicationRepository.findAllByJobId(id).size();
    }
}
