package io.github.oengajohn.sakilaappjpa.service;

import io.github.oengajohn.sakilaappjpa.controller.dto.MenuDTO;

import java.util.List;



public interface MenuService {
    List<MenuDTO>  getMenuItemsForUser(String username);
}
