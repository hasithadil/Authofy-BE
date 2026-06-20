package com.pm.be.service;

import com.pm.be.dto.ProfileRequestDto;
import com.pm.be.dto.ProfileResponseDto;
import com.pm.be.entity.User;
import com.pm.be.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final UserRepo userRepo;

    @Override
    public ProfileResponseDto createProfile(ProfileRequestDto requestDto) {
        User newProfile = convertToUserEntity(requestDto);
        newProfile = userRepo.save(newProfile);

        return convertToProfileResponseDto(newProfile);
    }

    public User convertToUserEntity(ProfileRequestDto requestDto) {
        return User.builder()
                .userId(UUID.randomUUID().toString())
                .name(requestDto.getName())
                .email(requestDto.getEmail())
                .password(requestDto.getPassword())
                .isAccountVerified(false) // New profiles are not verified by default
                .resetOtpExpireAt(0L) // Default value for OTP expiration
                .verifyOtp(null)
                .verifyOtpExpireAt(0L)
                .resetOtp(null)
                .build();
    }

    public ProfileResponseDto convertToProfileResponseDto(User user) {
        return ProfileResponseDto.builder()
                .userId(String.valueOf(user.getId()))
                .name(user.getName())
                .email(user.getEmail())
                .isAccountVerified(user.getIsAccountVerified())
                .build();
    }
}
