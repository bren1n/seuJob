package br.com.danluan.seuJob.service;

import br.com.danluan.seuJob.model.Resume;
import br.com.danluan.seuJob.repository.ResumeRepository;
import br.com.danluan.seuJob.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResumeService {
    @Autowired
    private ResumeRepository resumeRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Resume> getResumes() {
        return resumeRepository.findAll();
    }

    public Resume getResume(Integer id) {
        return resumeRepository.findById(id).map(resume -> {
            return resume;
        }).orElseThrow(() -> null);
    }

    public void createResume(Resume resume) {
        resumeRepository.save(resume);
    }

    public void updateResume(Integer id, String experiences, String education, String skills) {
        Resume resume = this.getResume(id);
        resume.setExperiences(experiences);
        resume.setEducation(education);
        resume.setSkills(skills);
        resumeRepository.save(resume);
    }

    public void deleteResume(Integer id) {
        userRepository.deleteById(id);
    }
}
