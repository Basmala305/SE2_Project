package com.Anime.AnimeProject.exception;

import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException {

    protected HttpStatus httpStatus;
    protected String errorMessage;
    protected Integer errorCode;

    public BaseException(ApiErrorType apiErrorType, HttpStatus httpStatus) {
        super(apiErrorType.getErrorMessage());
        this.httpStatus = httpStatus;
        this.errorMessage = apiErrorType.getErrorMessage();
        this.errorCode = apiErrorType.getErrorCode();
    }

    public BaseException(ApiErrorType apiErrorType, String errorMessage, HttpStatus httpStatus, Integer errorCode) {
        super(errorMessage);
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }
}
