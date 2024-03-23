package com.utcn.demo.service;

import com.utcn.demo.model.Role;
import com.utcn.demo.model.User;
import com.utcn.demo.repository.UserDTO;
import com.utcn.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser (UserDTO userDTO) {
        User user = new User();
        user.setCnp(userDTO.getCnp());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());
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

    public void updateUser(UserDTO userDTO) {
        User user = userRepository.findById(userDTO.getCnp()).orElse(null);
        if (user != null) {
            user.setUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
            user.setEmail(userDTO.getEmail());
            user.setRole(userDTO.getRole());
            userRepository.save(user);
        }
    }

}
