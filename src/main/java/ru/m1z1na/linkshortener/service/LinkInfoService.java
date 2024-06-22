package ru.m1z1na.linkshortener.service;

import ru.m1z1na.linkshortener.dto.CreateShortLinkRequestDto;
import ru.m1z1na.linkshortener.dto.CreateShortLinkResponseDto;

public interface LinkInfoService {

    CreateShortLinkResponseDto createLinkInfo(CreateShortLinkRequestDto request) ;
    String getByShortLink(String shortLink) ;
}
