package com.example.demo1337.repo;


import com.example.demo1337.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

    @Query(value="select * from users where user_username=?",nativeQuery = true)
    Optional<Users> findByUsername(String user_username);


}
