package com.example.spring.rest.model;

import java.io.Serializable;

public class AboutInfo implements Serializable {

    private String version;
    private String buildTimestamp;

    public AboutInfo() {
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBuildTimestamp() {
        return buildTimestamp;
    }

    public void setBuildTimestamp(String buildTimestamp) {
        this.buildTimestamp = buildTimestamp;
    }
}
