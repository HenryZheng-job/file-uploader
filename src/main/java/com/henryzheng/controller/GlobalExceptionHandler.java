package com.henryzheng.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * Created by hanzheng on 8/10/17.
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestPartException.class)
    public String handleMissingServletRequestPartException(Exception e) {
        return e.getMessage();
    }

}
