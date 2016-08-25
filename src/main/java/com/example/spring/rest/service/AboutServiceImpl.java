package com.example.spring.rest.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AboutServiceImpl extends BaseRestService implements AboutService {

    @Value("${buildTimestamp}")
    String buildTimestamp;

    @Value("${version}")
    String version;

    @Value("${groupId}")
    String groupId;

    @Value("${artifactId}")
    String artifactId;

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public String getBuildTimestamp() {
        return buildTimestamp;
    }
}
