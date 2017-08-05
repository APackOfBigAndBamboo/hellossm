package com.northgatecode.hellossm.controllers.exceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;
/**
 * Created by qianl on 12/26/2016.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(AccessDeniedException.class)
    public String accessDeniedErrorHandler(HttpServletRequest request, Exception ex) {
        logger.error("URL:" + request.getRequestURL() + " Exception:" + ex.getMessage());
        return "home/denied";
    }
    @ExceptionHandler(Exception.class)
    public String defaultErrorHandler(HttpServletRequest request, Exception ex) {
        logger.error("URL:" + request.getRequestURL() + " Exception:" + ex.getMessage());
        return "home/error";
    }
}