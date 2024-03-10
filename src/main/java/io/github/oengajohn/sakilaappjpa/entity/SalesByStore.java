package io.github.oengajohn.sakilaappjpa.entity;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;

/**
 * Mapping for DB view
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Immutable
public class SalesByStore {
    @Size(max = 101)
    @Column(name = "store", length = 101)
    private String store;

    @Size(max = 91)
    @Column(name = "manager", length = 91)
    private String manager;

    @Column(name = "total_sales", precision = 27, scale = 2)
    private BigDecimal totalSales;

}