package com.example.spring.rest.model;

import java.util.ArrayList;
import java.util.List;

public class ErrorInfo {
    private List<String> errors;

    public ErrorInfo() {
        errors = new ArrayList<>();
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public void addError(String message) {
        errors.add(message);
    }
}
