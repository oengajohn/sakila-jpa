package io.github.oengajohn.sakilaappjpa.controller.dto;

import io.github.oengajohn.sakilaappjpa.entity.Actor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link Actor}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ActorDto implements Serializable {

    Integer id;
    @NotNull
    @Size(max = 45)
    String firstName;
    @NotNull
    @Size(max = 45)
    String lastName;
    @NotNull
    Instant lastUpdate;
}