package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileController {


    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public ResponseEntity<?> profile() {
        return ResponseEntity.ok("Profile");
    }


}
