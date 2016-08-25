package com.example.spring.rest.web;

import com.example.spring.rest.exception.GizmoNotFoundException;
import com.example.spring.rest.exception.ServiceException;
import com.example.spring.rest.model.ErrorInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class DefaultExceptionHandler {

    private static final Logger LOG = LogManager.getLogger(DefaultExceptionHandler.class);

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorInfo handleConstraintViolationException(ConstraintViolationException e) {
        ErrorInfo errorInfo = new ErrorInfo();

        for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
            String message = constraintViolation.getPropertyPath()
                                                .toString()
                                                .concat(": ")
                                                .concat(constraintViolation.getMessage());
            LOG.error(message);
            errorInfo.addError(message);
        }

        return errorInfo;
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorInfo handleServiceException(ServiceException e) {
        return errorResponse(e);
    }

    @ExceptionHandler(GizmoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorInfo handleServiceException(GizmoNotFoundException e) {
        return errorResponse(e);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorInfo handleIllegalArgumentException(IllegalArgumentException e) {
        return errorResponse(e);
    }

    private ErrorInfo errorResponse(Exception e) {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.addError(e.getLocalizedMessage());
        LOG.error(e.getLocalizedMessage());
        return errorInfo;
    }
}
