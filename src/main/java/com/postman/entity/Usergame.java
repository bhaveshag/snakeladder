package com.postman.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usergame")
@Data
public class Usergame {
    @Id
    @Column(name = "id")
    private String id; // gameId#UserId

    @Column(name = "pos")
    private int pos;
}
