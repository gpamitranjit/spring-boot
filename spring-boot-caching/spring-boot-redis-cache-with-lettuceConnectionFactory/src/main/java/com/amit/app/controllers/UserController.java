package com.amit.app.controllers;

import com.amit.app.cache.redis.repository.UserRepository;
import com.amit.app.models.User;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rest/user")
public class UserController {

    private UserRepository _userRepository;

    public UserController(UserRepository userRepository){
        _userRepository = userRepository;
    }

    @GetMapping("/all")
    public Map<String, User> GetAll(){
       return _userRepository.findAll();
    }

    @GetMapping("/all/{id}")
    public User GetAll(@PathVariable("id") final String id){
        return _userRepository.findById(id);
    }

    @PostMapping("/add")
    public User add(@RequestBody User user){
        _userRepository.save(new User(user.getId(),user.getName(),user.getSalary()));
        return _userRepository.findById(user.getId());

    }


    @PutMapping("/update")
    public User update(@RequestBody User user){
        _userRepository.update(new User(user.getId(),user.getName(),user.getSalary()));
        return _userRepository.findById(user.getId());

    }


}