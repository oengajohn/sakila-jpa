package io.github.oengajohn.sakilaappjpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "store",indexes = {
        @Index(name = "idx_unique_manager",columnList = "manager_staff_id"),
        @Index(name = "idx_fk_address_id",columnList = "address_id")
})

public class Store {
    @Id
    @Column(name = "store_id", columnDefinition = "tinyint UNSIGNED")
    private Short storeId;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "manager_staff_id", nullable = false, foreignKey = @ForeignKey(
            name = "fk_store_staff"
    ))
    @ToString.Exclude
    private Staff managerStaff;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false, foreignKey = @ForeignKey(
            name = "fk_store_address"
    ))
    @ToString.Exclude
    private Address address;

    @NotNull
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

}