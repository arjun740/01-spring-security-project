package com.arjun.springSecurity.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@NoArgsConstructor
@Data
@Entity
@Table(name ="customer")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "email")
    private String email;
    @Column(name = "pwd")
    private String pwd;
    @Column(name = "role")
    private String role;

    public Customer(String email, String pwd, String role) {
        this.email = email;
        this.pwd = pwd;
        this.role = role;
    }

}