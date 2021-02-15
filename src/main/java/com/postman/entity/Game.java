package com.postman.entity;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table(name = "game")
@Data
public class Game {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    Long id;

    @Column(name = "GAMENAME")
    private String gamename;

    @Column(name = "players")
    private int players;

    public Game(String gameName, int players) {
        this.gamename = gameName;
        this.players = players;
    }
}
