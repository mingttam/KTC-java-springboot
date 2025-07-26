package com.example.java_springboot.dtos;

import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Data
public class UpdateStudentRequestDto {
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Email(message = "Email is not valid")
    @NotBlank(message = "Email is required")
    private String email;

    private String address;
}