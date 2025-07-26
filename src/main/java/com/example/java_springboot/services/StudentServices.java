package com.example.java_springboot.services;

import com.example.java_springboot.dtos.CreateStudentRequestDto;
import com.example.java_springboot.dtos.StudentResponseDto;
import com.example.java_springboot.dtos.UpdateStudentRequestDto;
import com.example.java_springboot.entities.Student;
import com.example.java_springboot.repositories.StudentJpaRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServices {

    private final StudentJpaRepository studentRepository;

    public StudentServices(StudentJpaRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentResponseDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        // Chuyển List<Student> sang List<StudentResponseDto>
        return students.stream()
                .map(student -> new StudentResponseDto(

                        student.getId(),
                        student.getName(),
                        student.getEmail(),
                        student.getAddress()))
                .toList();
    }

    public StudentResponseDto getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return new StudentResponseDto(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getAddress());
    }

    public StudentResponseDto createStudent(CreateStudentRequestDto dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setAddress(dto.getAddress());
        Student saved = studentRepository.save(student);
        return new StudentResponseDto(saved.getId(), saved.getName(), saved.getEmail(), saved.getAddress());

    }

    public StudentResponseDto updateStudent(Long id, UpdateStudentRequestDto dto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setAddress(dto.getAddress());
        Student saved = studentRepository.save(student);
        return new StudentResponseDto(saved.getId(), saved.getName(), saved.getEmail(), saved.getAddress());
    }

    public void deleteStudent(Long id) {
        studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        studentRepository.deleteById(id);
    }
}
