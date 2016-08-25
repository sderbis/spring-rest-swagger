package com.example.spring.rest.config.servlet;

import com.example.spring.rest.config.ArtifactInfo;
import com.fasterxml.classmate.TypeResolver;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.Instant;

import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.schema.AlternateTypeRules.newRule;

@Configuration
@EnableSwagger2
public class RestSwaggerConfig {

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        TypeResolver typeResolver = new TypeResolver();

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(paths())
                .build()
                .alternateTypeRules(newRule(typeResolver.resolve(Instant.class), typeResolver.resolve(String.class)));
    }

    private Predicate<String> paths() {
        return regex("/.*");
    }

    private ApiInfo apiInfo() {
        ArtifactInfo artifactInfo = new ArtifactInfo();

        return new ApiInfo(
                "Gizmo REST API",
                "<img src='../../images/Widget_16x16.png'/>&nbsp;Gizmo API for managing gizmos</br>",
                artifactInfo.getVersion() + " (build timestamp: " + artifactInfo.getBuildTimestamp() + ")",
                "Gizmo API terms of service",
                "Gizmo Inc.",
                "API Licence Type",
                "../../APIlicense.html");
    }
}