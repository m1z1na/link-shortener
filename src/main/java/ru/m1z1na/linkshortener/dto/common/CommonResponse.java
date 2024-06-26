package ru.m1z1na.linkshortener.dto.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import java.util.List;


@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CommonResponse<T>(T body, String errorMessage, List<ValidationError> validationErrorList) {
}