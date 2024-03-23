package io.github.oengajohn.sakilaappjpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "film_text",indexes = {
        @Index(name = "idx_title_description",columnList = "title,description")
})
public class FilmText {
    @Id
    @Column(name = "film_id", columnDefinition = "smallint UNSIGNED")
    private Integer filmId;

    @Size(max = 255)
    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @Lob
    @Column(name = "description",columnDefinition = "TEXT(5000)")
    private String description;

}