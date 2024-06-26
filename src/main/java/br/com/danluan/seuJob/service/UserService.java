package br.com.danluan.seuJob.service;

import br.com.danluan.seuJob.model.Resume;
import br.com.danluan.seuJob.model.User;
import br.com.danluan.seuJob.repository.UserRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public List<User> getUsersAppliedJobById(Integer id) {
        return userRepository.findAllBAppliedByJobId(id);
    }
    public List<User> getUsersResumeNull() {
        return userRepository.findAllByResumeIsNull();
    }

    public User getUser(Integer id) {
        return userRepository.findById(id).map(user -> {
            return user;
        }).orElseThrow(() -> null);
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Integer id, String name, String email, String phoneNumber, String password) {
        User user = this.getUser(id);
        user.setName(name);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(password);
        userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public void updateUserResume(Integer id, Resume resume) {
        User user = this.getUser(id);
        user.setResume(resume);
        userRepository.save(user);
    }
}
