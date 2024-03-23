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
@Table(name = "rental",indexes = {
        @Index(name = "rental_date",columnList = "rental_date,inventory_id,customer_id"),
        @Index(name = "idx_fk_customer_id",columnList = "customer_id"),
        @Index(name = "idx_fk_inventory_id",columnList = "inventory_id"),
        @Index(name = "idx_fk_staff_id",columnList = "staff_id")
})
public class Rental {
    @Id
    @Column(name = "rental_id", nullable = false)
    private Integer rentalId;

    @NotNull
    @Column(name = "rental_date", nullable = false)
    private Instant rentalDate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "inventory_id", nullable = false, foreignKey = @ForeignKey(
            name = "fk_rental_inventory"
    ))
    private Inventory inventory;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false, foreignKey = @ForeignKey(
            name = "fk_rental_customer"
    ))
    private Customer customer;

    @Column(name = "return_date")
    private Instant returnDate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "staff_id", nullable = false, foreignKey = @ForeignKey(
            name = "fk_rental_staff"
    ))
    private Staff staff;

    @NotNull
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

}