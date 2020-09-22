package com.example.aparat.model;

public interface IMessageListener<T> {

    public void onSuccess(T response);
    public void onFailure(T errorResponse);
}
