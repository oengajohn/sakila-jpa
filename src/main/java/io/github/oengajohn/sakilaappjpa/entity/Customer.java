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
@Table(name = "customer",indexes = {
        @Index(name = "idx_fk_address_id",columnList = "address_id"),
        @Index(name = "idx_fk_store_id",columnList = "store_id")
})
public class Customer {
    @Id
    @Column(name = "customer_id", columnDefinition = "smallint UNSIGNED")
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_id", nullable = false, foreignKey = @ForeignKey(
            name = "fk_customer_store"
    ))
    private Store store;

    @Size(max = 45)
    @NotNull
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Size(max = 45)
    @NotNull
    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Size(max = 50)
    @Column(name = "email", length = 50)
    private String email;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false, foreignKey = @ForeignKey(
            name = "fk_customer_address"
    ))
    private Address address;

    @NotNull
    @Column(name = "active", nullable = false)
    private Boolean active = false;

    @NotNull
    @Column(name = "create_date", nullable = false)
    private Instant createDate;

    @Column(name = "last_update")
    private Instant lastUpdate;

    @PrePersist
    public void setCreateDate() {
        createDate = Instant.now();
        lastUpdate = Instant.now();
    }

    @PreUpdate
    public void setLastUpdate() {
        lastUpdate = Instant.now();
    }


}