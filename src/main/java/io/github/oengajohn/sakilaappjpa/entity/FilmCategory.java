package io.github.oengajohn.sakilaappjpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "film_category")
public class FilmCategory {
    @EmbeddedId
    private FilmCategoryId id;

    @MapsId("filmId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "film_id", nullable = false,columnDefinition = "smallint UNSIGNED",foreignKey = @ForeignKey(
            name = "fk_film_category_film"
    ))
    private Film film;

    @MapsId("categoryId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false,columnDefinition = "tinyint UNSIGNED",foreignKey = @ForeignKey(
            name = "fk_film_category_category"
    ))
    private Category category;

    @NotNull
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

}