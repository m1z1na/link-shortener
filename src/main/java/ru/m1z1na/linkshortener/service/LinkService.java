package ru.m1z1na.linkshortener.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import ru.m1z1na.linkshortener.dto.CreateShortLinkRequestDto;

import static ru.m1z1na.linkshortener.util.Constants.SHORT_LINK_LENGTH;

@Service
public class LinkService {

    public String generateShortLink(CreateShortLinkRequestDto request) {
        return RandomStringUtils.randomAlphanumeric(SHORT_LINK_LENGTH);
    }

}