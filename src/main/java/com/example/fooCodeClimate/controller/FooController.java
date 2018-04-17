package com.example.fooCodeClimate.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FooController {

    @GetMapping("/")
    public ResponseEntity<String> get(){
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }

}
