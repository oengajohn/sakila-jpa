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
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "country_id", columnDefinition = "smallint UNSIGNED")
    private Integer countryId;

    @Size(max = 50)
    @NotNull
    @Column(name = "country", nullable = false, length = 50)
    private String country;

    @NotNull
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @PrePersist
    @PreUpdate
    public void setCreateDate() {
        lastUpdate = Instant.now();
    }


}