package ru.m1z1na.linkshortener.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.m1z1na.linkshortener.service.LinkInfoService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class LinkShortenerController {
    private final LinkInfoService linkInfoService;

    @GetMapping("/short-link/{shortLink}")
    public ResponseEntity<String> getByShortLink(@PathVariable String shortLink) {
        log.info("Поступил запрос на открытие длинной ссылки по короткой: {}", shortLink);
        var link = linkInfoService.getByShortLink(shortLink);
        return ResponseEntity.status(HttpStatus.TEMPORARY_REDIRECT)
                .header(HttpHeaders.LOCATION, link)
                .build();
    }

}
