package com.vorobev.generalservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class DbParsingException extends RuntimeException{
    public DbParsingException(String message) {
        super(message);
    }
}
