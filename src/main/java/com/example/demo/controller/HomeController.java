package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ResponseEntity<?> test() {
        return ResponseEntity.ok("Test");
    }

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public ResponseEntity<?> firstPage() {
        return ResponseEntity.ok("Home");
    }
}
