package com.sridhar.dev.shopping_cart.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String resource,String fieldName,Object fieldValue){
        super(String.format("%s not found with %s : %s",resource,fieldName, fieldValue));
    }
}
