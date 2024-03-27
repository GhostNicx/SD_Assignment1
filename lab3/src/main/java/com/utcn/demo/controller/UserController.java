package com.utcn.demo.controller;

import com.utcn.demo.model.User;
import com.utcn.demo.repository.UserDTO;
import com.utcn.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public void createUser(@RequestBody UserDTO userDTO){
        userService.createUser(userDTO);
    }

    @DeleteMapping("/delete/{cnp}")
    public void deleteUser(@PathVariable long cnp){
        userService.deleteUser(cnp);
    }
    //update user
    @PutMapping("/update")
    public void updateUser(@RequestBody UserDTO userDTO){
        userService.updateUser(userDTO);
    }
    //read users
    @GetMapping("/getAll")
    public List<User> retrieveUsers(){
        return userService.retrieveUsers();
    }
    //retrieve user
    @GetMapping("/get/{cnp}")
    public User retrieveUser(@PathVariable long cnp){
        return userService.retrieveUser(cnp);
    }

}
