package com.example.practice.service;


import com.example.practice.Enums.TransactionCategory;
import com.example.practice.model.Refund;
import com.example.practice.model.Transaction;
import com.example.practice.repository.RefundRepository;
import com.example.practice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    RefundRepository refundRepository;
    public String addTransaction(int anamount) {
        Transaction transaction =new Transaction();
        Refund refund =new Refund();
        if(transaction.getTransactionCategory()== TransactionCategory.FAILURE){
            refund.setAmount(anamount);
            transaction.setAmount(transaction.getAmount()-anamount);

        }
        else{
            transaction.setAmount(transaction.getAmount()-anamount);
        }
        transactionRepository.save(transaction);
        refundRepository.save(refund);
        return "amount added successfully";
    }
}
