package com.workforce.SpringException.exception;

public class RtnMessageForException {

    private String statusCode;
    private String error;
    private String errordesc;

    public RtnMessageForException(String statusCode, String error, String errordesc) {
        this.statusCode = statusCode;
        this.error = error;
        this.errordesc = errordesc;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrordesc() {
        return errordesc;
    }

    public void setErrordesc(String errordesc) {
        this.errordesc = errordesc;
    }
}
