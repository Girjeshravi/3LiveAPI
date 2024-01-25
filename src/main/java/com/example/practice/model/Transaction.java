package com.example.practice.model;


import com.example.practice.Enums.TransactionCategory;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int transactionId;

    int amount;

    TransactionCategory transactionCategory;

    @ManyToOne
    @JoinColumn
    User user;

}
