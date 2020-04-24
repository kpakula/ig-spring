package com.example.demo.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
//@ApiOperation(value = "", authorizations = { @Authorization(value="apiKey") })
public class HomeController {


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<?> test() {
        return ResponseEntity.ok("Test");
    }

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public ResponseEntity<?> firstPage() {
        return ResponseEntity.ok("Home");
    }
}
