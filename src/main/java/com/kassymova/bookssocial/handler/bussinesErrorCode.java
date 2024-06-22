package com.kassymova.bookssocial.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

public enum bussinesErrorCode {

    NO_CODE(0, NOT_IMPLEMENTED, "No code"),

    INCORRECT_CURRENT_PASSWORD(300, BAD_REQUEST, "Incorrect password"),

    NEW_PASSWORD_DOES_NOT_MATCH(301, BAD_REQUEST, "Password does not match"),

    ACCOUNT_DISABLED(303, FORBIDDEN, "User account is disabled"),

    BAD_CREDENTIALS(304, FORBIDDEN, "Account locked"),

    ACCOUNT_LOCKED(302, FORBIDDEN, "Login and / or password incorrect"),

    ;

    @Getter
    private final int code;
    @Getter
    private final String description;
    @Getter
    private final HttpStatus httpStatus;


    bussinesErrorCode(int code, HttpStatus httpStatus, String description) {
        this.code = code;
        this.description = description;
        this.httpStatus = httpStatus;
    }
}
