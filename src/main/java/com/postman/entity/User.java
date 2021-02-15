package com.postman.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    Long id;

    @Column(name = "username")
    private String username;
}
