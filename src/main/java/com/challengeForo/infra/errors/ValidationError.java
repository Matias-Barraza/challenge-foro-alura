package com.challengeForo.infra.errors;

import org.springframework.validation.FieldError;

public record ValidationError(String field, String error) {

    public ValidationError(FieldError error) {
        this(error.getField(), error.getDefaultMessage());
    }

}
