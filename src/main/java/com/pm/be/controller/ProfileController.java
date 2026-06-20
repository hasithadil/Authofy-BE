package com.pm.be.controller;

import com.pm.be.dto.ProfileRequestDto;
import com.pm.be.dto.ProfileResponseDto;
import com.pm.be.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping("/register")
    public ProfileResponseDto register(@RequestBody ProfileRequestDto requestDto) {
        ProfileResponseDto response = profileService.createProfile(requestDto);
        // TODO: Add logic to send verification email here
        return response;
    }
}
