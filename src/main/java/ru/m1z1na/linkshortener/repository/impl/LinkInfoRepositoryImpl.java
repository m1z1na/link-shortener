package ru.m1z1na.linkshortener.repository.impl;

import ru.m1z1na.linkshortener.model.LinkInfo;
import ru.m1z1na.linkshortener.repository.LinkInfoRepository;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class LinkInfoRepositoryImpl implements LinkInfoRepository {
    private final Map<String, LinkInfo> storage = new ConcurrentHashMap<>();

    @Override
    public Optional<LinkInfo> findByShortLink(String shortLink) {
        return Optional.ofNullable(storage.get(shortLink));
    }

    @Override
    public LinkInfo save(LinkInfo link) {
        storage.put(link.getShortLink(), link);
        return link;
    }

}
