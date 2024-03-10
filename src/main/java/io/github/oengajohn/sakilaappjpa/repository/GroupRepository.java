package io.github.oengajohn.sakilaappjpa.repository;

import io.github.oengajohn.sakilaappjpa.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {
}