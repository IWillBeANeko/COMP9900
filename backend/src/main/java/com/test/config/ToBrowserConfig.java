package com.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.io.IOException;

@Configuration
public class ToBrowserConfig {

    @Value("${obj.index.url:http://localhost:8090}")
    private String url;

    @EventListener({ApplicationReadyEvent.class})
    public void applicationReadyEvent() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
