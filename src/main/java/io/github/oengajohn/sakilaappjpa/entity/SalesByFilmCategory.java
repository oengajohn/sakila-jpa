package io.github.oengajohn.sakilaappjpa.entity;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
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
public class SalesByFilmCategory {
    @Size(max = 25)
    @NotNull
    @Column(name = "category", nullable = false, length = 25)
    private String category;

    @Column(name = "total_sales", precision = 27, scale = 2)
    private BigDecimal totalSales;

}