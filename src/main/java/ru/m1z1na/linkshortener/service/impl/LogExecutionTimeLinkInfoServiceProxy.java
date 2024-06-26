package ru.m1z1na.linkshortener.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import ru.m1z1na.linkshortener.dto.CreateShortLinkRequestDto;
import ru.m1z1na.linkshortener.dto.CreateShortLinkResponseDto;
import ru.m1z1na.linkshortener.model.LinkInfo;
import ru.m1z1na.linkshortener.service.LinkInfoService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Profile("dev")
@ConditionalOnProperty("link-shortener.enable-log-exec-time")
@Service("linkInfoServiceProxy")
public class LogExecutionTimeLinkInfoServiceProxy implements LinkInfoService {
    private final LinkInfoService linkInfoService;

    @Override
    public CreateShortLinkResponseDto createLinkInfo(CreateShortLinkRequestDto createShortLinkRequest) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            return linkInfoService.createLinkInfo(createShortLinkRequest);
        } finally {
            stopWatch.stop();
            log.info("Время создания ссылки составляем {} наносекунд", stopWatch.getTotalTimeNanos());
        }
    }

    @Override
    public String getByShortLink(String shortLink) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            return linkInfoService.getByShortLink(shortLink);
        } finally {
            stopWatch.stop();
            log.info("Время получения ссылки составляет {} наносекунд", stopWatch.getTotalTimeNanos());
        }
    }

    @Override
    public List<LinkInfo> findAll() {
        return findAll();
    }

    @Override
    public void delete(String shortLink) {
        delete(shortLink);
    }
}
