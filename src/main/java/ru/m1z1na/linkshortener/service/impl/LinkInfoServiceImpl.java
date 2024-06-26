package ru.m1z1na.linkshortener.service.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import ru.m1z1na.linkshortener.dto.CreateShortLinkRequestDto;
import ru.m1z1na.linkshortener.dto.CreateShortLinkResponseDto;
import ru.m1z1na.linkshortener.exception.NotFoundException;
import ru.m1z1na.linkshortener.map.LinkMapper;
import ru.m1z1na.linkshortener.model.LinkInfo;
import ru.m1z1na.linkshortener.property.LinkShortenerProperty;
import ru.m1z1na.linkshortener.repository.LinkInfoRepository;
import ru.m1z1na.linkshortener.service.LinkInfoService;

import java.util.List;
import java.util.UUID;


@Service("linkInfoService")
public class LinkInfoServiceImpl implements LinkInfoService {

    private final LinkInfoRepository linkInfoRepository;
    private final LinkShortenerProperty linkShortenerProperty;
    private final LinkMapper linkMapper;

    public LinkInfoServiceImpl(LinkInfoRepository linkInfoRepository, LinkShortenerProperty linkShortenerProperty, LinkMapper linkMapper) {
        this.linkInfoRepository = linkInfoRepository;
        this.linkShortenerProperty = linkShortenerProperty;
        this.linkMapper = linkMapper;
    }

    public CreateShortLinkResponseDto createLinkInfo(CreateShortLinkRequestDto request) {
        LinkInfo link = linkMapper.getEntityFromDto(request);
//        System.out.println(linkMapper.fromCreateRequest(request));
        System.out.println(link);
        link.setId(UUID.randomUUID());
        link.setShortLink(RandomStringUtils.randomAlphanumeric(linkShortenerProperty.getShortLinkLength()));
        linkInfoRepository.save(link);

        return CreateShortLinkResponseDto.builder()
                .id(link.getId())
                .link(link.getLink())
                .endTime(link.getEndTime())
                .description(link.getDescription())
                .active(link.getActive())
                .shortLink(link.getShortLink())
                .build();
    }

    public String getByShortLink(String shortLink) {
        LinkInfo link = linkInfoRepository.findByShortLink(shortLink)
                .orElseThrow(() -> new NotFoundException(String.format("link %s not found", shortLink)));
        return link.getLink();
    }

    @Override
    public List<LinkInfo> findAll() {
        return linkInfoRepository.findAll();
    }

    @Override
    public void delete(String shortLink) {
        linkInfoRepository.delete(shortLink);
    }
}