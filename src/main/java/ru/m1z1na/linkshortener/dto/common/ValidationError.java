package ru.m1z1na.linkshortener.dto.common;

import lombok.Builder;

@Builder
public record ValidationError(String field, String message) {
}