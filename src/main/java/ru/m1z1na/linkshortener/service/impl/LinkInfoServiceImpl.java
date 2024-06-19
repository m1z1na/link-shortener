package ru.m1z1na.linkshortener.service.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.m1z1na.linkshortener.dto.CreateShortLinkRequestDto;
import ru.m1z1na.linkshortener.exception.NotFoundException;
import ru.m1z1na.linkshortener.model.LinkInfo;
import ru.m1z1na.linkshortener.repository.LinkInfoRepository;
import ru.m1z1na.linkshortener.service.LinkInfoService;

import java.util.UUID;


@Service("linkInfoService")
public class LinkInfoServiceImpl implements LinkInfoService {

    @Value("${link-shortener.short-link-length}")
    private int shortLinkLength;
    @Autowired
    private final LinkInfoRepository linkInfoRepository;

    public LinkInfoServiceImpl(LinkInfoRepository linkInfoRepository) {
        this.linkInfoRepository = linkInfoRepository;
    }

    public LinkInfo createLinkInfo(CreateShortLinkRequestDto request) {
        LinkInfo link = new LinkInfo(request);
        link.setId(UUID.randomUUID());
        link.setShortLink(RandomStringUtils.randomAlphanumeric(shortLinkLength));
        return linkInfoRepository.save(link);
    }

    public String getByShortLink(String shortLink) {
        LinkInfo link = linkInfoRepository.findByShortLink(shortLink)
                .orElseThrow(() -> new NotFoundException(String.format("link %s not found", shortLink)));
        return link.getLink();
    }
}