package io.github.oengajohn.sakilaappjpa.controller.dto;

import io.github.oengajohn.sakilaappjpa.entity.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDto implements Serializable {
    private Integer id;
    @Size(min =3,max = 100)
    @NotEmpty
    private String name;
    @Size(min =3,max = 25)
    @NotEmpty
    @Pattern(regexp = "/([a-z]+)/i" )
    private String username;
    private String email;
    private String picture;
    private Integer groupId;
    private GroupDto group;
}