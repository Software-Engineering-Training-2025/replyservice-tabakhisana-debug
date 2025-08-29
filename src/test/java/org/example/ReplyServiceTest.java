package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReplyServiceTest {

    private final ReplyService service = new ReplyService();

    // ===== Helpers =====
    private void assertReply(String expected, String input, ReplyService.ReplyType type) {
        assertEquals(expected, service.reply(input, type),
                () -> "Input=[" + input + "], Type=" + type);
    }

    // ===== FORMAL =====
    @Test
    void formal_canonical_messages() {
        // Null / blank
        assertReply("Please say something.", null, ReplyService.ReplyType.FORMAL);
        assertReply("Please say something.", "", ReplyService.ReplyType.FORMAL);
        assertReply("Please say something.", "   \t  ", ReplyService.ReplyType.FORMAL);

        // Canonical inputs
        assertReply("Hello. How may I assist you today?", "hi", ReplyService.ReplyType.FORMAL);
        assertReply("Hello. How may I assist you today?", "hello", ReplyService.ReplyType.FORMAL);
        assertReply("I am functioning properly. How may I assist you?", "how are you", ReplyService.ReplyType.FORMAL);
        assertReply("I can assist with that. Please provide more details.", "i need help", ReplyService.ReplyType.FORMAL);
        assertReply("Certainly. Please describe the account issue.", "can you help me with my account", ReplyService.ReplyType.FORMAL);
        assertReply("You are welcome.", "thanks", ReplyService.ReplyType.FORMAL);
        assertReply("Goodbye.", "bye", ReplyService.ReplyType.FORMAL);
        assertReply("I am your virtual assistant.", "what is your name", ReplyService.ReplyType.FORMAL);

        // Any other text
        assertReply("Could you clarify your request?", "what time is it", ReplyService.ReplyType.FORMAL);
    }

    // ===== FRIENDLY =====
    @Test
    void friendly_canonical_messages() {
        // Null / blank
        assertReply("Please say something.", null, ReplyService.ReplyType.FRIENDLY);
        assertReply("Please say something.", "", ReplyService.ReplyType.FRIENDLY);
        assertReply("Please say something.", "   \t  ", ReplyService.ReplyType.FRIENDLY);

        // Canonical inputs
        assertReply("Hey there! 😊 How can I help?", "hi", ReplyService.ReplyType.FRIENDLY);
        assertReply("Hi! 👋 What’s up?", "hello", ReplyService.ReplyType.FRIENDLY);
        assertReply("Doing great! 😄 How can I help?", "how are you", ReplyService.ReplyType.FRIENDLY);
        assertReply("I’ve got you! 🙂 Tell me a bit more.", "i need help", ReplyService.ReplyType.FRIENDLY);
        assertReply("Sure thing! 😊 What’s wrong with the account?", "can you help me with my account", ReplyService.ReplyType.FRIENDLY);
        assertReply("Anytime! 🙌", "thanks", ReplyService.ReplyType.FRIENDLY);
        assertReply("See you later! 👋", "bye", ReplyService.ReplyType.FRIENDLY);
        assertReply("I’m your helper bot 🤖", "what is your name", ReplyService.ReplyType.FRIENDLY);

        // Any other text
        assertReply("Could you tell me more?", "what time is it", ReplyService.ReplyType.FRIENDLY);
    }

    // ===== CONCISE =====
    @Test
    void concise_canonical_messages() {
        // Null / blank
        assertReply("Please say something.", null, ReplyService.ReplyType.CONCISE);
        assertReply("Please say something.", "", ReplyService.ReplyType.CONCISE);
        assertReply("Please say something.", "   \t  ", ReplyService.ReplyType.CONCISE);

        // Canonical inputs
        assertReply("Hello. How can I help?", "hi", ReplyService.ReplyType.CONCISE);
        assertReply("Hello. How can I help?", "hello", ReplyService.ReplyType.CONCISE);
        assertReply("I’m good. How can I help?", "how are you", ReplyService.ReplyType.CONCISE);
        assertReply("Share details; I’ll help.", "i need help", ReplyService.ReplyType.CONCISE);
        assertReply("Describe the account issue…", "can you help me with my account", ReplyService.ReplyType.CONCISE);
        assertReply("You’re welcome.", "thanks", ReplyService.ReplyType.CONCISE);
        assertReply("Goodbye.", "bye", ReplyService.ReplyType.CONCISE);
        assertReply("I’m your assistant.", "what is your name", ReplyService.ReplyType.CONCISE);

        // Any other text
        assertReply("Please clarify.", "what time is it", ReplyService.ReplyType.CONCISE);
    }
}

