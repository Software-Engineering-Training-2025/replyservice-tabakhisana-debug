package org.example;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class ReplyService {

    public enum ReplyType {
        FORMAL, FRIENDLY, CONCISE
    }

    private static final Map<String, Map<ReplyType, String>> RESPONSES = new HashMap<>();

    static {
        addResponse("hi",
                "Hello. How may I assist you today?",
                "Hey there! 😊 How can I help?",
                "Hello. How can I help?");

        addResponse("hello",
                "Hello. How may I assist you today?",
                "Hi! 👋 What’s up?",
                "Hello. How can I help?");

        addResponse("how are you",
                "I am functioning properly. How may I assist you?",
                "Doing great! 😄 How can I help?",
                "I’m good. How can I help?");

        addResponse("i need help",
                "I can assist with that. Please provide more details.",
                "I’ve got you! 🙂 Tell me a bit more.",
                "Share details; I’ll help.");

        addResponse("can you help me with my account",
                "Certainly. Please describe the account issue.",
                "Sure thing! 😊 What’s wrong with the account?",
                "Describe the account issue…");

        addResponse("thanks",
                "You are welcome.",
                "Anytime! 🙌",
                "You’re welcome.");

        addResponse("bye",
                "Goodbye.",
                "See you later! 👋",
                "Goodbye.");

        addResponse("what is your name",
                "I am your virtual assistant.",
                "I’m your helper bot 🤖",
                "I’m your assistant.");

        // fallback للـ "any other text"
        addResponse("any other text",
                "Could you clarify your request?",
                "Could you tell me more?",
                "Please clarify.");
    }

    // helper method لترتيب الإدخال
    private static void addResponse(String key, String formal, String friendly, String concise) {
        Map<ReplyType, String> map = new EnumMap<>(ReplyType.class);
        map.put(ReplyType.FORMAL, formal);
        map.put(ReplyType.FRIENDLY, friendly);
        map.put(ReplyType.CONCISE, concise);
        RESPONSES.put(key, map);
    }

    public String reply(String message, ReplyType type) {
        if (message == null || message.trim().isEmpty()) {
            return "Please say something.";
        }

        String normalized = message.trim().toLowerCase();

        Map<ReplyType, String> replies =
                RESPONSES.getOrDefault(normalized, RESPONSES.get("any other text"));

        return replies.get(type);
    }
}

