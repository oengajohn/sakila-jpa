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
@Table(name = "film_actor",indexes = {
        @Index(name = "idx_fk_film_id",columnList = "film_id")
})
public class FilmActor {
    @EmbeddedId
    private FilmActorId id;

    @MapsId("actorId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "actor_id", nullable = false,columnDefinition = "smallint UNSIGNED",foreignKey = @ForeignKey(
            name = "fk_film_actor_actor"
    ))
    private Actor actor;

    @MapsId("filmId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "film_id", nullable = false,columnDefinition = "smallint UNSIGNED",foreignKey = @ForeignKey(
            name = "fk_film_actor_film"
    ))
    private Film film;

    @NotNull
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

}