package com.example.jdbi.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperResponseDto {

    private Long developerId;

    private String name;

}
