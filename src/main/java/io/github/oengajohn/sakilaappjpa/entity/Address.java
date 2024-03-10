package io.github.oengajohn.sakilaappjpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.locationtech.jts.geom.Geometry;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "address", indexes = {
        @Index(name = "idx_fk_city_id", columnList = "city_id"),
        @Index(name = "idx_location", columnList = "location")
})
public class Address {
    @Id
    @Column(name = "address_id", columnDefinition = "smallint UNSIGNED")
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "address", nullable = false, length = 50)
    private String address;

    @Size(max = 50)
    @Column(name = "address2", length = 50)
    private String address2;

    @Size(max = 20)
    @NotNull
    @Column(name = "district", nullable = false, length = 20)
    private String district;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false,foreignKey = @ForeignKey(
            name = "fk_address_city"
    ))
    private City city;

    @Size(max = 10)
    @Column(name = "postal_code", length = 10)
    private String postalCode;

    @Size(max = 20)
    @NotNull
    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    @NotNull
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @Column(name = "location", columnDefinition = "geometry not null")
    private Geometry location;

    @PrePersist
    @PreUpdate
    public void setCreateDate() {
        lastUpdate = Instant.now();
    }

}