package com.a_chat.a_chat;

import org.springframework.http.ResponseEntity;

public interface Command<I, O>{
    ResponseEntity<O> execute(I input);
}
