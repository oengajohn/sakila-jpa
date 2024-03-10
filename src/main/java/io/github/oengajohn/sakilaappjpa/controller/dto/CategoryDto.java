package io.github.oengajohn.sakilaappjpa.controller.dto;

import io.github.oengajohn.sakilaappjpa.entity.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link Category}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CategoryDto implements Serializable {
    Short id;
    @NotNull
    @Size(max = 25)
    String name;
    @NotNull
    Instant lastUpdate;
}