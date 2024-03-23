package io.github.oengajohn.sakilaappjpa.controller.dto;

import io.github.oengajohn.sakilaappjpa.entity.Country;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link Country}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CountryDto implements Serializable {
    private Integer countryId;
    @NotNull
    @Size(max = 50)
    private String country;
    @NotNull
    private Instant lastUpdate;
}