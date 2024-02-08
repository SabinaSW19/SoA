package com.ubbcluj.user.controller;

import com.ubbcluj.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(value="/login",method= RequestMethod.GET)
    public ResponseEntity<?> getUsers(){
        System.out.println("Calling login");
        return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK);
    }

}
