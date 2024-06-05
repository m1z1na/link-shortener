package ru.m1z1na.linkshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.m1z1na.linkshortener.dto.CreateShortLinkRequestDto;
import ru.m1z1na.linkshortener.service.LinkInfoService;

import java.time.ZonedDateTime;

@SpringBootApplication
public class LinkShortenerApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(LinkShortenerApp.class);
        LinkInfoService linkService = new LinkInfoService();

        CreateShortLinkRequestDto shortLinkRequest =
                new CreateShortLinkRequestDto(
                        "https://github.com/m1z1na",
                        ZonedDateTime.now(),
                        "m1z1na",
                        true);

        System.out.println(linkService.getByShortLink(linkService.createLinkInfo(shortLinkRequest).getShortLink()).equals(shortLinkRequest.getLink()));
    }
}