package com.utcn.demo.service;

import com.utcn.demo.model.Role;
import com.utcn.demo.model.User;
import com.utcn.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser (long cnp, String username, String password, String email, String role) {
        User user = new User();
        user.setCnp(cnp);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setRole(role);
        userRepository.save(user);
    }

    public List <User> retrieveUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User retrieveUser(long cnp) {
        return userRepository.findById(cnp).orElse(null);
    }

    public void deleteUser(Long cnp) {
        userRepository.deleteById(cnp);
    }

}
