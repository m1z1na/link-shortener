package ru.m1z1na.linkshortener.repository;

import ru.m1z1na.linkshortener.model.LinkInfo;
import java.util.Optional;

public interface LinkInfoRepository {

    Optional<LinkInfo> findByShortLink(String shortLink);

    LinkInfo save(LinkInfo link);

}
