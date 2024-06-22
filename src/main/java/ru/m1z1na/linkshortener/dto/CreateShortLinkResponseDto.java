package ru.m1z1na.linkshortener.dto;

import lombok.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateShortLinkResponseDto {
    private UUID id;
    private String link;
    private ZonedDateTime endTime;
    private String description;
    private Boolean active;
    private String shortLink;
}
