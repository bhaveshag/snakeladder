package com.postman.dao;

import lombok.Data;

@Data
public class UserGameResponse {
   Long userid;
   Long gameid;
   int nextPos;
}
