package com.example.spring.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GizmoNotFoundException extends RuntimeException {
    public GizmoNotFoundException(String id) {
        super("Could not find gizmo with id " + id);
    }
}
