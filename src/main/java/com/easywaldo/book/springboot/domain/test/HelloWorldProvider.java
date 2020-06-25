package com.easywaldo.book.springboot.domain.test;

public class HelloWorldProvider implements MessageProvider {

    @Override
    public String getMessage() {
        return "Hello World";
    }
}
