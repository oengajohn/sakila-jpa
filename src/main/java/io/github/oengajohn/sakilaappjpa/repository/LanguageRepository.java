package io.github.oengajohn.sakilaappjpa.repository;

import io.github.oengajohn.sakilaappjpa.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Short> {
}