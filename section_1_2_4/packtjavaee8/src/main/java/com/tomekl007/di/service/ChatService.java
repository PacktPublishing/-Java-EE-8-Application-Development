package com.tomekl007.di.service;


import com.tomekl007.di.interceptor.Audited;

public class ChatService {
    @Audited
    public String deliverMessage(String msg) {
        return msg;
    }
}
