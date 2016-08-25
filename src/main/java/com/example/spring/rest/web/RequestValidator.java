package com.example.spring.rest.web;

import com.example.spring.rest.validation.CreateRequest;
import com.example.spring.rest.validation.UpdateRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class RequestValidator {

    @Autowired
    Validator validator;

    public void validateCreateRequest(List<?> entityList) {
        validateRequest(entityList, CreateRequest.class);
    }

    public void validateUpdateRequest(List<?> entityList) {
        validateRequest(entityList, UpdateRequest.class);
    }

    public void validateCreateRequest(Object entity) {
        validateRequest(entity, CreateRequest.class);
    }

    public void validateUpdateRequest(Object entity) {
        validateRequest(entity, UpdateRequest.class);
    }

    private void validateRequest(List<?> entityList, Class<?> requestType) {
        for (Object entity : entityList) {
            validateRequest(entity, requestType);
        }
    }

    private void validateRequest(Object entity, Class<?> requestType) {
        Set<ConstraintViolation<?>> violations = new HashSet<>();
        violations.addAll(validator.validate(entity, requestType));

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(getErrorString(violations), violations);
        }
    }

    private String getErrorString(Set<ConstraintViolation<?>> violations) {
        StringBuilder errorString = new StringBuilder("Validation Error: ");

        for (ConstraintViolation<?> violation : violations) {
            if (!StringUtils.isEmpty(violation.getMessage())) {
                errorString.append(violation.getPropertyPath()
                                            .toString())
                           .append(" ")
                           .append(violation.getMessage())
                           .append("\n");
                break;
            }
        }
        return errorString.toString();
    }
}
