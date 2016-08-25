package com.example.spring.rest.config.root;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

@Configuration
public class RestSerializationConfig {

    @Bean(name = "restObjectMapper")
    public ObjectMapper restObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();

        // support for Java 8 dates
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // support for legacy dates
        final SimpleDateFormat instantDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        instantDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        mapper.setDateFormat(instantDateFormat);

        // unknown enum values should just map to null without throwing an exception
        mapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);

        return mapper;
    }
}
