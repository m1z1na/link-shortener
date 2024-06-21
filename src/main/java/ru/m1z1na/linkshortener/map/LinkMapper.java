package ru.m1z1na.linkshortener.map;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import ru.m1z1na.linkshortener.dto.CreateShortLinkRequestDto;
import ru.m1z1na.linkshortener.model.LinkInfo;

@Mapper(componentModel = "spring")
public interface LinkMapper {
    @InheritInverseConfiguration
    LinkInfo getEntityFromDto(CreateShortLinkRequestDto shortLinkRequest);

}