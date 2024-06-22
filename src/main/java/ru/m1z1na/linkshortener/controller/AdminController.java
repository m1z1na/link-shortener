package ru.m1z1na.linkshortener.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.m1z1na.linkshortener.dto.CreateShortLinkRequestDto;
import ru.m1z1na.linkshortener.dto.CreateShortLinkResponseDto;
import ru.m1z1na.linkshortener.dto.common.CommonRequest;
import ru.m1z1na.linkshortener.dto.common.CommonResponse;
import ru.m1z1na.linkshortener.service.LinkInfoService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/link-info")
public class AdminController {

    private final LinkInfoService linkInfoService;

    @PostMapping
    public CommonResponse<CreateShortLinkResponseDto> createLink(@RequestBody CommonRequest<CreateShortLinkRequestDto> request) {
        log.info("Поступил запрос на создание короткой ссылки: {}", request);
        return CommonResponse.<CreateShortLinkResponseDto>builder()
                .body(linkInfoService.createLinkInfo(request.getBody()))
                .build();
    }

}
