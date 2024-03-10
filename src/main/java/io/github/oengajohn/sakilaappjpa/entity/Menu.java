package io.github.oengajohn.sakilaappjpa.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "menus")
public class Menu {

    @Id
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "text")
    private String text;

    @Column(name = "icon_cls")
    private String iconCls;

    @Column(name = "class_name")
    private String className;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    @JsonProperty("menuId")
    private Menu menu;


}
