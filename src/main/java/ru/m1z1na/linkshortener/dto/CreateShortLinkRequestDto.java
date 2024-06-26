package ru.m1z1na.linkshortener.dto;

import lombok.*;

import java.time.ZonedDateTime;

//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//public class CreateShortLinkRequestDto {
//
//    @NotEmpty(message = "Ссылка не может быть пустой")
//    @Size(min = 10, max = 4096, message = "Длина ссылки не может быть меньше 10 и больше 4096")
//    @Pattern(regexp = "^((https?|ftp|smtp):\\/\\/)?(www.)?[a-z0-9]+\\.[a-z]+(\\/[a-zA-Z0-9#]+\\/?)*$", message = "Ссылка не соответсвует паттерну URL")
//    String link;
//
//    @Future(message = "Дата окончания ссылки должна быть в будущем")
//    ZonedDateTime endTime;
//
//    @NotEmpty(message = "Описание не может быть пустым")
//    String description;
//
//    @NotNull(message = "Поле активности не может быть пустым")
//    Boolean active;
//
//}
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateShortLinkRequestDto {

    private String link;
    private ZonedDateTime endTime;
    private String description;
    private Boolean active;

}