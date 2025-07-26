package com.example.java_springboot.dtos;

import lombok.Data;

@Data

public class StudentResponseDto {
    private Long id;
    private String name;
    private String email;
    private String address;

    public StudentResponseDto(Long id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }
}
