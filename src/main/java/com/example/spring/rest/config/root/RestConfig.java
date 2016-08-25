package com.example.spring.rest.config.root;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.example.spring.rest.service", "com.example.spring.rest.config.root"})
public class RestConfig {
}