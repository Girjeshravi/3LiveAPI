package com.example.practice.controller;
import com.example.practice.model.User;
import com.example.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserConteroller {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody User user){
            User saveduser=userService.addUser(user);
            return new ResponseEntity(saveduser, HttpStatus.CREATED);

    }

    @GetMapping("/successt")
    public ResponseEntity findSuccessfullTransactionAmount(@RequestBody User user){
        int stamount=userService.findSuccessfullTransactionAmount(user);
        return new ResponseEntity(stamount,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/dfailedtransactions")
    public ResponseEntity deletFailedTransactions(@RequestBody User user){
        String updateusers=userService.deletFailedTransactions(user);
        return new ResponseEntity(updateusers,HttpStatus.CREATED);
    }
}
