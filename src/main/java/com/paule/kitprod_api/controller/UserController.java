package com.paule.kitprod_api.controller;

import com.paule.kitprod_api.model.User;
import com.paule.kitprod_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {
    @Autowired
    public UserRepository userRepository;

    @GetMapping(value = "/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping(value = "/users/:uid")
    public User getUser(@RequestParam String uid){
        Optional<User> user = userRepository.findById(uid);

        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @PostMapping(value = "/users")
    public User createUser(@RequestBody User user){

        return userRepository.insert(user);
    }
}
