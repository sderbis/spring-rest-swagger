package com.example.spring.rest.service;

import com.example.spring.rest.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class BaseRestService {
    private static final Logger LOG = LogManager.getLogger(BaseRestService.class);

    /**
     * Use this method to log the @Exception message and the stack trace
     *
     * @param exception - the Exception to be logged
     * @throws ServiceException - common exception for all service methods
     */
    public void logAndThrowServiceException(Exception exception) throws ServiceException {
        LOG.error(exception.getMessage(), exception);
        throw new ServiceException(exception);
    }

    /**
     * Logs a simple message
     *
     * @param message - the message to be logged
     * @throws ServiceException - common exception for all service methods
     */
    public void logAndThrowServiceException(String message) throws ServiceException {
        LOG.error(message);
        throw new ServiceException(message);
    }
}
