package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ReplyService service = new ReplyService();

        System.out.println(service.reply("hi", ReplyService.ReplyType.FORMAL));
        // Hello. How may I assist you today?

        System.out.println(service.reply("hello", ReplyService.ReplyType.FRIENDLY));
        // Hi! 👋 What’s up?

        System.out.println(service.reply("blabla", ReplyService.ReplyType.CONCISE));
        // Please clarify.

        System.out.println(service.reply("   ", ReplyService.ReplyType.FORMAL));
        // Please say something.
    }
}
