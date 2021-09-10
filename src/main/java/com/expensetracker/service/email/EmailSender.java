package com.expensetracker.service.email;

public interface EmailSender {

    void send(String to, String email);
}
