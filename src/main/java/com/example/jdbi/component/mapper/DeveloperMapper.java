package com.example.jdbi.component.mapper;

import com.example.jdbi.dto.request.DeveloperRequestDto;
import com.example.jdbi.dto.response.DeveloperResponseDto;
import com.example.jdbi.model.Developer;
import org.springframework.stereotype.Component;

@Component
public class DeveloperMapper {

    public Developer toModel(DeveloperRequestDto requestDto) {
        return Developer.builder()
                .developerId(requestDto.getDeveloperId())
                .name(requestDto.getName())
                .build();
    }

    public DeveloperResponseDto toDeveloperResponse(Developer model) {
        return DeveloperResponseDto.builder()
                .developerId(model.getDeveloperId())
                .name(model.getName())
                .build();
    }
}
