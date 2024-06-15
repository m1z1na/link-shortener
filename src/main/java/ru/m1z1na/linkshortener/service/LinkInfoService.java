package ru.m1z1na.linkshortener.service;
import ru.m1z1na.linkshortener.dto.CreateShortLinkRequestDto;
import ru.m1z1na.linkshortener.model.LinkInfo;

public interface LinkInfoService {

    LinkInfo createLinkInfo(CreateShortLinkRequestDto request) ;
    String getByShortLink(String shortLink) ;
}
