package com.example.jdbi.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperRequestDto {

    private Long developerId;

    @NonNull
    private String name;

}
