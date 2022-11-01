package com.ecommerce.ecommerceapi.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping(path = "/v1/user")
public class User {
    @Autowired
    UserRepository userRepository;

    @GetMapping(path = "/get")
    public List<UserEntity> index() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/get/{id}")
    public List<UserEntity> getCertainId(@PathVariable String id) {
        return userRepository.findById(parseInt(id));
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public UserEntity createUser(@RequestBody UserEntity newUser) {
//        UserEntity user = new UserEntity();
//        String name = body.get("name");
//        String lastName = body.get("lastName");
//        String email = body.get("email");
//        String password = body.get("password");
//
//        System.out.println(name + " " + lastName + " " + email + " " + password);
//
//        user.setName(name);
//        user.setLastName(lastName);
//        user.setEmail(email);
//        user.setPassword(password);

        return userRepository.save(newUser);
    }
}
