package com.tomekl007.rest;

import java.util.*;

public class ChatService {
    private static final Map<String, List<String>> messages = new HashMap<>();

    void sendMessageTo(String userId, String msg) {
        List<String> m = messages.getOrDefault(userId, new LinkedList<>());
        m.add(msg);
        messages.put(userId, m);
    }

    String getLastMessage(String userId) {
        return Optional.ofNullable(messages.get(userId))
                .filter(v -> v.size() > 0)
                .map(v -> v.get(v.size() - 1))
                .orElse("");

    }
}
