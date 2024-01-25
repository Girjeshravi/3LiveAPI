package com.example.practice.repository;

import com.example.practice.model.Refund;
import com.example.practice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface RefundRepository extends JpaRepository<Refund,Integer> {

    String findTransactionId="select p from Refund p order by Max(amount) LIMIT 1";
//    SELECT MAX(salary) AS "Highest salary" FROM employees
    @Query(value=findTransactionId)
    int findByMaximumRefundAmounts();

    User findBymaxRefundAmount(int maxRefundAmount);
}
