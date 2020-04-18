package com.example.demo.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ApiOperation(value = "", authorizations = { @Authorization(value="apiKey") })
public class HomeController {

    @GetMapping({"/home"})
    public String firstPage() {
        return "Home";
    }
}
