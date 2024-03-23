package io.github.oengajohn.sakilaappjpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "film",indexes = {
        @Index(name = "idx_title", columnList = "title"),
        @Index(name = "idx_fk_language_id", columnList = "language_id"),
        @Index(name = "idx_fk_original_language_id", columnList = "original_language_id"),
})
public class Film {
    @Id
    @Column(name = "film_id", columnDefinition = "smallint UNSIGNED")
    private Integer filmId;

    @Size(max = 128)
    @NotNull
    @Column(name = "title", nullable = false, length = 128)
    private String title;


    @Column(name = "description",columnDefinition = "tinytext")
    private String description;

    @Column(name = "release_year",columnDefinition = "YEAR")
    private Integer releaseYear;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "language_id",foreignKey = @ForeignKey(
            name = "fk_film_language"
    ))
    private Language language;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "original_language_id",foreignKey = @ForeignKey(
            name = "fk_film_language_original"
    ))
    private Language originalLanguage;

    @Column(name = "rental_duration", columnDefinition = "tinyint UNSIGNED")
    private Short rentalDuration;

    @NotNull
    @Column(name = "rental_rate", nullable = false, precision = 4, scale = 2)
    private BigDecimal rentalRate;

    @Column(name = "length", columnDefinition = "smallint UNSIGNED")
    private Integer length;

    @NotNull
    @Column(name = "replacement_cost", nullable = false, precision = 5, scale = 2)
    private BigDecimal replacementCost;

    @Column(name = "rating",columnDefinition = "ENUM('G','PG','PG-13','R','NC-17') DEFAULT 'G'")
    private String rating;

    @Lob
    @Column(name = "special_features",columnDefinition = "SET('Trailers','Commentaries','Deleted Scenes','Behind the Scenes')")
    private String specialFeatures;

    @NotNull
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @PrePersist
    @PreUpdate
    public void setCreateDate() {
        lastUpdate = Instant.now();
    }


}