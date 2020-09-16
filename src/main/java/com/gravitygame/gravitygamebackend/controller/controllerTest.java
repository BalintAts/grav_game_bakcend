package com.gravitygame.gravitygamebackend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class controllerTest {

    @GetMapping("/test")
    public String doesItWork(){
        return "it works";
    }
}
