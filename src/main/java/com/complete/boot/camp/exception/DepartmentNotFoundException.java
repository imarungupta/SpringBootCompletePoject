package com.complete.boot.camp.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DepartmentNotFoundException extends Exception{
    Logger logger = LoggerFactory.getLogger(DepartmentNotFoundException.class);
    public DepartmentNotFoundException() {
        super();
    }
    public DepartmentNotFoundException(String message) {
        super(message);
        logger.error("Exception found in department-"+message);
    }
    public DepartmentNotFoundException(String message, Throwable cause) {
        super(message, cause);
        logger.error("Exception found in department-"+message +"Cause-"+cause);
    }
    public DepartmentNotFoundException(Throwable cause) {
        super(cause);
        logger.error("Exception found in department-Throwable-"+cause);
    }
    protected DepartmentNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        logger.error("Exception found in department-Throwable-"+cause+"writableStackTrace-"+writableStackTrace);
    }
}
