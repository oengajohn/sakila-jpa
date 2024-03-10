package io.github.oengajohn.sakilaappjpa.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MenuDTO {
    private Integer id;
    private String text;
    private String iconCls;
    private String xType;
    private Integer menuId;

    @JsonInclude(NON_NULL)
    private List<MenuDTO> items;
    public MenuDTO(Integer id, String text, String iconCls, String xType, Integer menuId) {
        this.id = id;
        this.text = text;
        this.iconCls = iconCls;
        this.xType = xType;
        this.menuId = menuId;
    }
}