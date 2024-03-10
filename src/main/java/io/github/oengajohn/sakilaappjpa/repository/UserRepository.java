package io.github.oengajohn.sakilaappjpa.repository;

import io.github.oengajohn.sakilaappjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {


    Optional<User> findByUsername(String username);

    List<User> findAllByGroupId(Integer groupId);
}
