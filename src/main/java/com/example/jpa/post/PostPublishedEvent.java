package com.example.jpa.post;

import org.springframework.context.ApplicationEvent;

public class PostPublishedEvent extends ApplicationEvent {

    private final Custom custom;

    public PostPublishedEvent(Object source) {
        super(source);
        this.custom = (Custom) source;
    }

    public Custom getCustom() {
        return custom;
    }
}
