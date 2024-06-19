package ru.m1z1na.linkshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.m1z1na.linkshortener.dto.CreateShortLinkRequestDto;
import ru.m1z1na.linkshortener.service.LinkInfoService;

import javax.annotation.PostConstruct;
import java.time.ZonedDateTime;

@SpringBootApplication
public class LinkShortenerApp {
    @Autowired
    @Qualifier("linkInfoServiceProxy")
    private LinkInfoService linkService;

    @PostConstruct
    public void pc() {
        CreateShortLinkRequestDto shortLinkRequest =
                new CreateShortLinkRequestDto(
                        "https://github.com/m1z1na",
                        ZonedDateTime.now(),
                        "m1z1na",
                        true);

        var newLink = linkService.createLinkInfo(shortLinkRequest);
        System.out.println(linkService.getByShortLink(newLink.getShortLink()));
    }

    public static void main(String[] args) {
        SpringApplication.run(LinkShortenerApp.class);
    }
}