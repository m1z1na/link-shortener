package ru.m1z1na.linkshortener.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.m1z1na.linkshortener.dto.CreateShortLinkRequestDto;
import ru.m1z1na.linkshortener.dto.CreateShortLinkResponseDto;
import ru.m1z1na.linkshortener.dto.common.CommonRequest;
import ru.m1z1na.linkshortener.dto.common.CommonResponse;
import ru.m1z1na.linkshortener.model.LinkInfo;
import ru.m1z1na.linkshortener.service.LinkInfoService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/link-infos")
public class LinkInfoController {

    private final LinkInfoService linkInfoService;

    @PostMapping
    public CommonResponse<CreateShortLinkResponseDto> createLink(@RequestBody @Valid CommonRequest<CreateShortLinkRequestDto> request) {
        log.info("Поступил запрос на создание короткой ссылки {}", request);
        CreateShortLinkResponseDto response = linkInfoService.createLinkInfo(request.getBody());
        return CommonResponse.<CreateShortLinkResponseDto>builder()
                .body(response)
                .build();
    }

    @GetMapping
    public CommonResponse<List<LinkInfo>> getAll() {
        log.info("Поступил получение всех ссылок");
        var list = linkInfoService.findAll();
        return CommonResponse.<List<LinkInfo>>builder()
                .body(list)
                .build();
    }

    @DeleteMapping("/{shortLink}")
    public void deleteShortLink(@PathVariable String shortLink) {
        log.info("Поступил запрос на удаление короткой ссылки {}", shortLink);
        linkInfoService.delete(shortLink);
    }
}
