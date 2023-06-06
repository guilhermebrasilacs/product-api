package com.project3.ACSchapter5.productapi.advice;

import	java.time.LocalDateTime;

import	org.springframework.http.HttpStatus;
import	org.springframework.web.bind.annotation.ControllerAdvice;
import	org.springframework.web.bind.annotation.ExceptionHandler;
import	org.springframework.web.bind.annotation.ResponseBody;
import	org.springframework.web.bind.annotation.ResponseStatus;

import com.project5.ACSchapter8.shoppingclient.dto.ErrorDTO;
import com.project5.ACSchapter8.shoppingclient.exception.ProductNotFoundException;

@ControllerAdvice(basePackages = "com.project3.ACSchapter5.productapi.controller")
public class ProductControllerAdvice {
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorDTO handleUserNotFound(ProductNotFoundException userNotFoundException){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setStatus((HttpStatus.NOT_FOUND.value()));
        errorDTO.setMessage("Produto não encontrado.");
        errorDTO.setTimestamp(LocalDateTime.now());
        return errorDTO;
    }
}
