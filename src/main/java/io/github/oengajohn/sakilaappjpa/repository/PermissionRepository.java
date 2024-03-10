package io.github.oengajohn.sakilaappjpa.repository;


import io.github.oengajohn.sakilaappjpa.entity.Permission;
import io.github.oengajohn.sakilaappjpa.entity.PermissionKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, PermissionKey> {



}
