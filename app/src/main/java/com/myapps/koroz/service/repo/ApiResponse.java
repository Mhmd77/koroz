package com.myapps.koroz.service.repo;

import com.google.gson.annotations.SerializedName;

public class ApiResponse<T> { //extends Event> {
    @SerializedName("Data")
    private T data;
    @SerializedName("")
    private String message;
    @SerializedName("HasError")
    private boolean hasError;

    public ApiResponse(T data, String message, boolean hasError) {
        this.data = data;
        this.message = message;
        this.hasError = hasError;
    }

    public ApiResponse() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
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
        return "ApiResponse{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", hasError=" + hasError +
                '}';
    }
}