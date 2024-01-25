package com.example.practice.controller;

import com.example.practice.model.User;
import com.example.practice.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/refund")
public class RefundController {

    @Autowired
    RefundService refundService;

    @GetMapping("/findmaxrefundamountuser")
    public ResponseEntity findmaxRefundAmountUser(){
        User ans=refundService.findmaxRefundAmountUsers();
        return new ResponseEntity(ans, HttpStatus.CREATED);
    }

}
