package io.github.oengajohn.sakilaappjpa.service.impl;

import io.github.oengajohn.sakilaappjpa.controller.dto.MenuDTO;
import io.github.oengajohn.sakilaappjpa.entity.Menu;
import io.github.oengajohn.sakilaappjpa.repository.MenuRepository;
import io.github.oengajohn.sakilaappjpa.repository.UserRepository;
import io.github.oengajohn.sakilaappjpa.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    private final UserRepository userRepository;

    public MenuServiceImpl(MenuRepository menuRepository,UserRepository userRepository) {
        this.menuRepository = menuRepository;
        this.userRepository = userRepository;
    }
    @Override
    public List<MenuDTO>  getMenuItemsForUser(String username) {
        return userRepository.findByUsername(username)
                .map(user -> {
                    List<Integer> permissions = menuRepository.retrievePermissions(username);

                    List<Menu> topLevelMenus = menuRepository.findByMenuIsNullAndIdIn(permissions);

                    return topLevelMenus.stream()
                            .map(menu -> {
                                log.info("parent: {}",menu);
                                List<Menu> childMenus = menuRepository.retrieveChildMenus(menu.getId());
                                log.info("childMenus: {}", childMenus);
                                List<MenuDTO> childMenuDTOs = childMenus.stream()
                                        .map(childMenu -> {
                                            log.info("parent: {}", menu);
                                            return new MenuDTO(
                                                    childMenu.getId(),
                                                    childMenu.getText(),
                                                    childMenu.getIconCls(),
                                                    childMenu.getClassName(),
                                                    childMenu.getMenu().getId()
                                            );


                                        })
                                        .collect(Collectors.toList());
                                return new MenuDTO(
                                        menu.getId(),
                                        menu.getText(),
                                        menu.getIconCls(),
                                        null,
                                        null,
                                        childMenuDTOs
                                );
                            })
                            .collect(Collectors.toList());
                })
                .orElse(Collections.emptyList());
    }
}
