package com.example.jdbi.controller;


import com.example.jdbi.dto.request.DeveloperRequestDto;
import com.example.jdbi.dto.response.DeveloperResponseDto;
import com.example.jdbi.service.DeveloperService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/developer")
@AllArgsConstructor
public class DeveloperController {

    private final DeveloperService developerService;

    @PostMapping
    public Long saveOrUpdateDeveloper(@RequestBody DeveloperRequestDto developerRequestDto) {
        return developerService.saveNewDeveloper(developerRequestDto);
    }

    @PutMapping
    public void updateDeveloper(@RequestBody DeveloperRequestDto developerRequestDto) {
        developerService.updateDeveloper(developerRequestDto);
    }

    @GetMapping
    public DeveloperResponseDto findDeveloperById(@RequestParam Long developerId) {
        return developerService.findDeveloperById(developerId);
    }

    @DeleteMapping
    public void removeDeveloperById(@RequestParam Long developerId) {
        developerService.removeDeveloperById(developerId);
    }

}
