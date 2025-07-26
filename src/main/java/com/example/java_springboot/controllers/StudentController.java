package com.example.java_springboot.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_springboot.dtos.CreateStudentRequestDto;
import com.example.java_springboot.dtos.StudentResponseDto;
import com.example.java_springboot.dtos.UpdateStudentRequestDto;
import com.example.java_springboot.services.StudentServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentServices studentServices;

    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @GetMapping
    public List<StudentResponseDto> getAllStudents() {
        return studentServices.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentResponseDto getStudentById(@PathVariable Long id) {
        return studentServices.getStudentById(id);
    }

    @PostMapping
    public StudentResponseDto createStudent(@RequestBody @Valid CreateStudentRequestDto dto) {
        return studentServices.createStudent(dto);
    }

    @PutMapping("/{id}")
    public StudentResponseDto updateStudent(@PathVariable Long id, @RequestBody @Valid UpdateStudentRequestDto dto) {
        return studentServices.updateStudent(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentServices.deleteStudent(id);
    }
}