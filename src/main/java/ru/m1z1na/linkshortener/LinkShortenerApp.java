package ru.m1z1na.linkshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.m1z1na.linkshortener.dto.CreateShortLinkRequestDto;
import ru.m1z1na.linkshortener.service.LinkService;

@SpringBootApplication
public class LinkShortenerApp {

    public static void main(String[] args) {
        SpringApplication.run(LinkShortenerApp.class);
        LinkService linkService = new LinkService();
        System.out.println(linkService.generateShortLink(new CreateShortLinkRequestDto()));
    }
}