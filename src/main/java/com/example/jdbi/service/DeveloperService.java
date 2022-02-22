package com.example.jdbi.service;

import com.example.jdbi.component.mapper.DeveloperMapper;
import com.example.jdbi.dto.request.DeveloperRequestDto;
import com.example.jdbi.dto.response.DeveloperResponseDto;
import com.example.jdbi.repository.DeveloperRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DeveloperService {

    private final DeveloperRepository developerRepository;

    private final DeveloperMapper developerMapper;

    @Transactional
    public Long saveNewDeveloper(DeveloperRequestDto developerRequestDto) {
        return developerRepository.saveNewDeveloper(developerMapper.toModel(developerRequestDto));
    }

    @Transactional
    public void updateDeveloper(DeveloperRequestDto developerRequestDto) {
        developerRepository.updateDeveloper(developerMapper.toModel(developerRequestDto));
    }

    public DeveloperResponseDto findDeveloperById(Long developerId) {
        return developerRepository.findDeveloperById(developerId)
                .orElseThrow(() -> new RuntimeException("Developer not found"));
    }

    public void removeDeveloperById(Long developerId) {
        developerRepository.removeDeveloperById(developerId);
    }

}
