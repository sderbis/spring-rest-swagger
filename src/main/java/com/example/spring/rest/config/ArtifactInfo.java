package com.example.spring.rest.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ArtifactInfo {
    private static final String UNKNOWN = "unknown";
    private static Logger LOGGER = LogManager.getLogger(ArtifactInfo.class);
    private String version;
    private String groupId;
    private String artifactId;
    private String buildTimestamp;

    public ArtifactInfo() {
        Properties prop = new Properties();
        InputStream resourceAsStream = this.getClass()
                                           .getResourceAsStream("/version.properties");
        try {
            prop.load(resourceAsStream);
            version = prop.getProperty("version");
            groupId = prop.getProperty("groupId");
            artifactId = prop.getProperty("artifactId");
            buildTimestamp = prop.getProperty("buildTimestamp");
        } catch (IOException e) {
            LOGGER.warn(e.getMessage());
            version = UNKNOWN;
            groupId = UNKNOWN;
            artifactId = UNKNOWN;
            buildTimestamp = UNKNOWN;
        }
    }

    public String getVersion() {
        return version;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public String getBuildTimestamp() {
        return buildTimestamp;
    }
}
