package com.postman.controller;


import com.postman.dao.GameRequesst;
import com.postman.dao.GameResponse;
import com.postman.dao.UserGameRequest;
import com.postman.dao.UserGameResponse;
import com.postman.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @Autowired
    GameService gameService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "Hello spring world";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public GameResponse createGame(GameRequesst gameRequesst){
        return gameService.createGame(gameRequesst);
    }

    @RequestMapping(value = "/roll", method = RequestMethod.POST)
    public UserGameResponse roll(UserGameRequest request){
        return gameService.roll(request);
    }
}
