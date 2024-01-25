package com.example.practice.controller;

import com.example.practice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/add/amount")
    public ResponseEntity addTransaction(@RequestParam int amount){
        String message=transactionService.addTransaction(amount);
        return new ResponseEntity(message, HttpStatus.ACCEPTED );
    }
}
