package com.example.fodd_app.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import  java.util.Optional;
import com.example.fodd_app.entities.user;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<user, Integer>{

    Optional<user> findOneByMailAndPassword(String mail, String password);
    user findByMail(String mail);
}
