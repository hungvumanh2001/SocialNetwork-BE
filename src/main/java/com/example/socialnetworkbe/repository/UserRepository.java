package com.example.socialnetworkbe.repository;


import com.example.socialnetworkbe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Query("select u from User u where UPPER(u.fullname) like ?1 and u.id <> ?2")
    List<User> findByKeyword(String key, Long id);
}