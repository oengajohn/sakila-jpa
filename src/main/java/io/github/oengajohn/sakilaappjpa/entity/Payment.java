package io.github.oengajohn.sakilaappjpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "payment",indexes = {
        @Index(name = "fk_payment_rental",columnList = "rental_id"),
        @Index(name = "idx_fk_customer_id",columnList = "customer_id"),
        @Index(name = "idx_fk_staff_id",columnList = "staff_id"),
})
public class Payment {
    @Id
    @Column(name = "payment_id", columnDefinition = "smallint UNSIGNED")
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false, foreignKey = @ForeignKey(
            name = "fk_payment_customer"
    ))
    private Customer customer;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "staff_id",  foreignKey = @ForeignKey(
            name = "fk_payment_staff"
    ))
    private Staff staff;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "rental_id", foreignKey = @ForeignKey(
            name = "fk_payment_rental"
    ))
    private Rental rental;

    @NotNull
    @Column(name = "amount", nullable = false, precision = 5, scale = 2)
    private BigDecimal amount;

    @NotNull
    @Column(name = "payment_date", nullable = false)
    private Instant paymentDate;

    @Column(name = "last_update")
    private Instant lastUpdate;

}