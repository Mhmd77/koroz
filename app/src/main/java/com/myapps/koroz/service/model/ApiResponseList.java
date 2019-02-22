package com.myapps.koroz.service.model;


import java.util.List;

/**
 * Created by elham on 3/10/17.
 */

public class ApiResponseList<T> { //extends Event> {

    private List<T> data;
    private String message;
    private boolean hasError;

    public ApiResponseList(List<T> data, String message, boolean hasError) {
        this.data = data;
        this.message = message;
        this.hasError = hasError;
    }

    public ApiResponseList() {
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    @Override
    public String toString() {
        return "ApiResponseList{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", hasError=" + hasError +
                '}';
    }
}

