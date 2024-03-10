package io.github.oengajohn.sakilaappjpa.controller.dto;

import io.github.oengajohn.sakilaappjpa.entity.Language;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link Language}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class LanguageDto implements Serializable {
    private Short id;
    @NotNull
    @Size(max = 20)
    private String name;
    @NotNull
    private Instant lastUpdate;
}