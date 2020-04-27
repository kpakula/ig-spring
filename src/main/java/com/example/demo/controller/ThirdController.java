package com.example.demo.controller;

import com.example.demo.model.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ThirdController {

    @RequestMapping(value = "/something", method = RequestMethod.POST)
    public ResponseEntity<?> showSomething() {
        return ResponseEntity.ok("Something");
    }

}
