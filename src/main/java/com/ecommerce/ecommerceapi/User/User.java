package com.ecommerce.ecommerceapi.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static java.lang.Long.parseLong;

@RestController
@RequestMapping(path = "/v1/user")
public class User {
    @Autowired
    UserRepository userRepository;

    @GetMapping(path = "/get")
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/get/byId/{id}")
    public Object getById(@PathVariable String id) {
        try {
            List<UserEntity> result = userRepository.findById(parseLong(id));

            return result.get(0);
        } catch (Exception error) {
            HashMap<String, String> errorMessage = new HashMap<>();
            errorMessage.put("error", "Mysql result: " + error.getMessage());
            errorMessage.put("errorMessage", "Maybe user with this id already exists");

            return errorMessage;
        }
    }

    @GetMapping(path = "/get/byName/{name}")
    public List<UserEntity> getByName(@PathVariable String name) {
        return userRepository.findByName(name);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public UserEntity createUser(@RequestBody UserEntity newUser) {
        return userRepository.save(newUser);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public UserEntity updateUser(@RequestBody UserEntity updatedUser) {
        return userRepository.save(updatedUser);
    }

}
