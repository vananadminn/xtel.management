package com.xmedia.springstart.repository;

import com.xmedia.springstart.model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u.username FROM User u WHERE u.username= ?1")
    String findUserName(String user);

    @Query("SELECT u.id FROM User u WHERE u.id =?1")
    String findId(int id);
}
