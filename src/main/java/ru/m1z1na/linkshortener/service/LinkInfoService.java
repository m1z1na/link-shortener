package ru.m1z1na.linkshortener.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import ru.m1z1na.linkshortener.dto.CreateShortLinkRequestDto;
import ru.m1z1na.linkshortener.exception.NotFoundException;
import ru.m1z1na.linkshortener.model.LinkInfo;
import ru.m1z1na.linkshortener.repository.LinkInfoRepository;
import ru.m1z1na.linkshortener.repository.impl.LinkInfoRepositoryImpl;
import static ru.m1z1na.linkshortener.util.Constants.SHORT_LINK_LENGTH;

@Service
public class LinkInfoService {
    private final LinkInfoRepository linkInfoRepository = new LinkInfoRepositoryImpl();

    public LinkInfo createLinkInfo(CreateShortLinkRequestDto request) {
        LinkInfo link = new LinkInfo(request);
        link.setShortLink(RandomStringUtils.randomAlphanumeric(SHORT_LINK_LENGTH));
        return linkInfoRepository.save(link);
    }

    public String getByShortLink(String shortLink) throws Exception {
        LinkInfo link = linkInfoRepository.findByShortLink(shortLink).orElseThrow(() -> new NotFoundException("link not found"));
        return link.getLink();
    }
}