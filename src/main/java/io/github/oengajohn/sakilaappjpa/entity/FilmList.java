package io.github.oengajohn.sakilaappjpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;

/**
 * Mapping for DB view
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Immutable

public class FilmList {
    @Column(name = "FID", columnDefinition = "smallint UNSIGNED not null")
    private Integer fid;

    @Size(max = 128)
    @NotNull
    @Column(name = "title", nullable = false, length = 128)
    private String title;

    @Lob
    @Column(name = "description")
    private String description;

    @Size(max = 25)
    @Column(name = "category", length = 25)
    private String category;

    @NotNull
    @Column(name = "price", nullable = false, precision = 4, scale = 2)
    private BigDecimal price;

    @Column(name = "length", columnDefinition = "smallint UNSIGNED")
    private Integer length;

    @Lob
    @Column(name = "rating")
    private String rating;

    @Lob
    @Column(name = "actors")
    private String actors;

}