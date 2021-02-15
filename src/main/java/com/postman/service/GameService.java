package com.postman.service;

import com.postman.dao.GameRequesst;
import com.postman.dao.GameResponse;
import com.postman.dao.UserGameRequest;
import com.postman.dao.UserGameResponse;
import com.postman.entity.Game;
import com.postman.entity.Usergame;
import com.postman.repository.GameRepository;
import com.postman.repository.UserRepository;
import com.postman.repository.UsergameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    UsergameRepository usergameRepository;

    @Autowired
    UserRepository userRepository;


    private static final HashMap<Integer, Integer> snake;

    static {
        snake = new HashMap<>();
        snake.put(20, 7);
        snake.put(35, 17);
        snake.put(48, 5);
        snake.put(56, 47);
        snake.put(88, 65);
        snake.put(98, 2);


    }
    private static final Map<Integer, Integer> ladders;
    static {
        ladders = new HashMap<>();
        ladders.put(6, 21);
        ladders.put(14, 27);
        ladders.put(26, 90);
        ladders.put(30, 50);
        ladders.put(49, 68);
        ladders.put(78, 89);
    }


    public GameResponse createGame(GameRequesst gameRequesst){
        gameRepository.save(new Game(gameRequesst.getGameName(), gameRequesst.getPlayers()));
        GameResponse gameResponse = new GameResponse("Created");
        return gameResponse;
    }

    public UserGameResponse roll(UserGameRequest request){
        String id = request.getGameid() + "#" + request.getUserid();
        Usergame usergame = usergameRepository.findById(id).get();
        int curr_pos = usergame.getPos();
        int next_pos = calculateNextPos(curr_pos, request.getDice());
        usergame.setPos(next_pos);
        usergameRepository.save(usergame);
        UserGameResponse response = new UserGameResponse();
        response.setGameid(request.getGameid());
        response.setUserid(request.getGameid());
        response.setNextPos(next_pos);
        return response;
    }

    private int calculateNextPos(int currPos, int dice){
        int next_pos = currPos + dice;
        if (ladders.containsKey(next_pos)){
            next_pos = ladders.get(next_pos);
        }else if(snake.containsKey(next_pos)){
            next_pos = snake.get(next_pos);
        }
        return next_pos;
    }
}
