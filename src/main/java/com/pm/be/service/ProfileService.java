package com.pm.be.service;

import com.pm.be.dto.ProfileRequestDto;
import com.pm.be.dto.ProfileResponseDto;

public interface ProfileService {
    ProfileResponseDto createProfile(ProfileRequestDto requestDto);
}
