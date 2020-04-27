package com.example.demo.controller;

import com.example.demo.config.JwtTokenUtil;
import com.example.demo.model.UserDao;
import com.example.demo.repository.UserRepository;
import com.example.demo.utils.Splitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserRepository repository;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ResponseEntity<?> profile(@RequestHeader("Authorization") String token) {
        String cleanToken = Splitter.getToken(token);
        String username = jwtTokenUtil.getUsernameFromToken(cleanToken);
        System.out.println(username);

        UserDao userDao = repository.findByUsername(username);


        return ResponseEntity.ok(userDao);
    }




}
