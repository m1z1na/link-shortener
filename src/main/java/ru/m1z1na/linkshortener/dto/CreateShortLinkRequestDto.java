package ru.m1z1na.linkshortener.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateShortLinkRequestDto {

    private String link;
    private ZonedDateTime endTime;
    private String description;
    private Boolean active;

}
