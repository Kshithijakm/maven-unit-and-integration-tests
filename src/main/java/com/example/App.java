package com.example;

public class App {
    private MessageService service;

    public App(MessageService service) {
        this.service = service;
    }

    public String getFullMessage() {
        return service.getGreeting();
    }

    public static void main(String[] args) {
        System.out.println("App is running!");
    }
}
