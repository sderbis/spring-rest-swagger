package com.example.spring.rest.model;

import java.io.Serializable;

public class CreateResult implements Serializable {
    private int totalCreated;

    public CreateResult() {
    }

    public CreateResult(int totalCreated) {
        this.totalCreated = totalCreated;
    }

    public int getTotalCreated() {
        return totalCreated;
    }

    public void setTotalCreated(int totalCreated) {
        this.totalCreated = totalCreated;
    }
}
