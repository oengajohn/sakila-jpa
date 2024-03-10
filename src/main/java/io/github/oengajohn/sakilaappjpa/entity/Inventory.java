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
@Table(name = "inventory",indexes = {
        @Index(name = "idx_film_id",columnList = "film_id"),
        @Index(name = "idx_store_id_film_id",columnList = "store_id")
})
public class Inventory {
    @Id
    @Column(name = "inventory_id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "film_id", nullable = false, foreignKey = @ForeignKey(
            name = "fk_inventory_film"
    ))
    private Film film;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_id", nullable = false, foreignKey = @ForeignKey(
            name = "fk_inventory_store"
    ))
    private Store store;

    @NotNull
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

}