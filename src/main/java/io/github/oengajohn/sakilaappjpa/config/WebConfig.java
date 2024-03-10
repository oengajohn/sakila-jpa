package io.github.oengajohn.sakilaappjpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Add your localhost URL
                .allowedMethods("*")
                .allowedHeaders("*")
                .maxAge(0)
                .exposedHeaders("*");
    }
}