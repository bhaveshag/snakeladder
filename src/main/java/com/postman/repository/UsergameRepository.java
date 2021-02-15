package com.postman.repository;

import com.postman.entity.User;
import com.postman.entity.Usergame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsergameRepository extends JpaRepository<Usergame, String> {
}
