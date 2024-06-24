package ru.m1z1na.linkshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
public class LinkShortenerApp {

    public static void main(String[] args) {
        SpringApplication.run(LinkShortenerApp.class);
    }
}