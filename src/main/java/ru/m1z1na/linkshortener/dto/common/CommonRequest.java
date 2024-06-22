package ru.m1z1na.linkshortener.dto.common;

import lombok.Data;

@Data
public class CommonRequest <T>{
    private T body;
}
