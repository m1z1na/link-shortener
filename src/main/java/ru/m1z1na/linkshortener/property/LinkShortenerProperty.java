package ru.m1z1na.linkshortener.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "link-shortener")
public record LinkShortenerProperty(int shortLinkLength,
                                    boolean logExecutioProxy) {

}