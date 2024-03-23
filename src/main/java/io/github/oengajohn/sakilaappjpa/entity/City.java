package io.github.oengajohn.sakilaappjpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "city",indexes = {
        @Index(name = "idx_fk_country_id",columnList = "country_id")
})
public class City {
    @Id
    @Column(name = "city_id", columnDefinition = "smallint UNSIGNED")
    private Integer cityId;

    @Size(max = 50)
    @NotNull
    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_id", nullable = false,foreignKey = @ForeignKey(
            name = "fk_city_country"
    ))
    private Country country;

    @NotNull
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @PrePersist
    @PreUpdate
    public void setCreateDate() {
        lastUpdate = Instant.now();
    }


}