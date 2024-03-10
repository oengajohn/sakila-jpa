package io.github.oengajohn.sakilaappjpa.repository;


import io.github.oengajohn.sakilaappjpa.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    @Query(value = "SELECT p.menu.id as menuId FROM User u INNER JOIN Permission p ON u.group.id =p.group.id INNER JOIN Menu m ON p.menu.id = m.id WHERE u.username =:username ")
    List<Integer> retrievePermissions(@Param("username") String username);

    @Query(value = "select m from Menu  m where m.menu is  null and m.id in :permissions")
    List<Menu> findByMenuIsNullAndIdIn(@Param("permissions") List<Integer> permissions);


    @Query(value = "select m from Menu m where m.menu.id =:menuId")
    List<Menu> retrieveChildMenus(@Param("menuId") Integer menuId);
}
