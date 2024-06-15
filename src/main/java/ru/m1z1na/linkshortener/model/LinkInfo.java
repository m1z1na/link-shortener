package ru.m1z1na.linkshortener.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.m1z1na.linkshortener.dto.CreateShortLinkRequestDto;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LinkInfo {

    private UUID id;
    private String link;
    private ZonedDateTime endTime;
    private String description;
    private Boolean active;
    private String shortLink;
    private Long openingCount;

    public LinkInfo(CreateShortLinkRequestDto createShortLinkRequest) {
        this.link = createShortLinkRequest.getLink();
        this.endTime = createShortLinkRequest.getEndTime();
        this.description = createShortLinkRequest.getDescription();
        this.active = createShortLinkRequest.getActive();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkInfo linkInfo = (LinkInfo) o;
        return Objects.equals(id, linkInfo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "LinkInfo{" +
                "id=" + id +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", shortLink='" + shortLink + '\'' +
                '}';
    }
}
