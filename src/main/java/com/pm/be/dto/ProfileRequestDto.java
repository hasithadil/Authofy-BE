package com.pm.be.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfileRequestDto {

    @Size(min = 6 , message = "Password must be at least 6 characters long")
    private String password;

    @Email(message = "Email should be valid")
    @NotNull(message = "Email cannot be empty")
    private String email;

    @NotBlank(message = "Name cannot be blank")
    private String name;
}
