package ru.m1z1na.linkshortener.service;

import ru.m1z1na.linkshortener.dto.CreateShortLinkRequestDto;
import ru.m1z1na.linkshortener.dto.CreateShortLinkResponseDto;
import ru.m1z1na.linkshortener.model.LinkInfo;

import java.util.List;

public interface LinkInfoService {

    CreateShortLinkResponseDto createLinkInfo(CreateShortLinkRequestDto request);

    String getByShortLink(String shortLink);

    List<LinkInfo> findAll();

    void delete(String shortLink);
}
