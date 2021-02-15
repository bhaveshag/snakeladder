package com.postman.dao;

import lombok.Data;

@Data
public class GameResponse {

    String status;

    public GameResponse(String status){
        this.status = status;
    }
}
