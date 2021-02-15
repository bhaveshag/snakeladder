package com.postman.dao;

import lombok.Data;

@Data
public class UserGameRequest {
   Long userid;
   Long gameid;
   int dice;
}
