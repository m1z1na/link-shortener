package ru.m1z1na.linkshortener.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import ru.m1z1na.linkshortener.dto.CreateShortLinkRequestDto;
import ru.m1z1na.linkshortener.model.LinkInfo;
import ru.m1z1na.linkshortener.service.LinkInfoService;

@Slf4j
@RequiredArgsConstructor
@Service("linkInfoServiceProxy")
public class LogExecutionTimeLinkInfoServiceProxy implements LinkInfoService {
    private final LinkInfoService linkInfoService;

    @Override
    public LinkInfo createLinkInfo(CreateShortLinkRequestDto createShortLinkRequest) {
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
}
