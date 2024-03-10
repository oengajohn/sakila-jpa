package io.github.oengajohn.sakilaappjpa.repository;

import io.github.oengajohn.sakilaappjpa.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}