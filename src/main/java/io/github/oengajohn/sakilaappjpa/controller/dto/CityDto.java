package io.github.oengajohn.sakilaappjpa.controller.dto;

import io.github.oengajohn.sakilaappjpa.entity.City;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link City}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CityDto implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 50)
    private String city;
    private Integer countryId;
    @NotNull
    private Instant lastUpdate;

    private CountryDto country;
}