package com.example.practice.service;

import com.example.practice.Enums.TransactionCategory;
import com.example.practice.model.Transaction;
import com.example.practice.model.User;
import com.example.practice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public User addUser(User user) {
        User savedUser=userRepository.save(user);
        return savedUser;

    }

    public int findSuccessfullTransactionAmount(User user) {
        int ans=0;
        for(Transaction transaction:user.getTransaction()){
            if(transaction.getTransactionCategory()== TransactionCategory.SUCCESS){
                ans=transaction.getAmount()+ans;
            }
        }
        return ans;
    }

    public String deletFailedTransactions(User user) {
        for(Transaction transaction:user.getTransaction()){
            if(transaction.getTransactionCategory()== TransactionCategory.FAILURE){
                userRepository.delete(user);
            }
        }
        return "users updated successfully";
    }
}
