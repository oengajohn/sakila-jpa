package io.github.oengajohn.sakilaappjpa.controller.dto;

import io.github.oengajohn.sakilaappjpa.entity.Film;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

/**
 * DTO for {@link Film}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class FilmDto implements Serializable {
    private Integer filmId;
    @NotNull
    @Size(max = 128)
    private String title;
    private String description;
    private Integer releaseYear;
    private Short languageId;
    private Short originalLanguageId;
    private Short rentalDuration;
    @NotNull
    private BigDecimal rentalRate;
    private Integer length;
    @NotNull
    private BigDecimal replacementCost;
    private String rating;
    private String specialFeatures;
    @NotNull
    private Instant lastUpdate;

    private List<CategoryDto> categories;
    private List<ActorDto> actors;
}