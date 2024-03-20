package com.utcn.demo.controller;

import com.utcn.demo.repository.UserDTO;
import com.utcn.demo.service.UserService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public void createUser(@RequestBody UserDTO userDTO){
        userService.createUser(userDTO.getCnp(), userDTO.getUsername(),
                userDTO.getPassword(), userDTO.getEmail(), userDTO.getRole());
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody long cnp){
        userService.deleteUser(cnp);
    }

}
