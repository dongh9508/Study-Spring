package com.donghun.nullsafty;

import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class EventService {

    @NotNull
    public String createEvent(@NotNull String name) {
        return  "hello " + name;
    }
}
