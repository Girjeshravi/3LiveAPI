package com.example.practice.model;

import com.example.practice.Enums.TransactionCategory;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;

    String name;

    @Column(unique = true)
    String email;

    @Column(unique = true,nullable = false)
    String AccountNumber;

    TransactionCategory transactionCategory;

    @OneToMany(mappedBy="user",cascade= CascadeType.ALL)
    List<Transaction> transaction=new ArrayList<>();
}
