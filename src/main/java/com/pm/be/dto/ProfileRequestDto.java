package com.pm.be.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfileRequestDto {
    private String password;
    private String email;
    private String name;
}
