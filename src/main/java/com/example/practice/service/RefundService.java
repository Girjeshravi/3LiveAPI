package com.example.practice.service;

import com.example.practice.model.Transaction;
import com.example.practice.model.User;
import com.example.practice.repository.RefundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class RefundService {
    @Autowired
    RefundRepository refundRepository;

    public User findmaxRefundAmountUsers(){
        int maxRefundAmount=refundRepository.findByMaximumRefundAmounts();
        User ans=refundRepository.findBymaxRefundAmount(maxRefundAmount);
        return ans;
    }
}
