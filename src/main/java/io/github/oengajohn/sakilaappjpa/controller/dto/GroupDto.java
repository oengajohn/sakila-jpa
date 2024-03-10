package io.github.oengajohn.sakilaappjpa.controller.dto;

import io.github.oengajohn.sakilaappjpa.entity.Group;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link Group}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class GroupDto implements Serializable {
    private Integer id;
    private String name;
}