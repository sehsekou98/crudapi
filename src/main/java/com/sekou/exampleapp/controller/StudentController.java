package com.sekou.exampleapp.controller;

import com.sekou.exampleapp.repository.StudentRepository;
import com.sekou.exampleapp.student.StudentEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class StudentController {
    public final StudentRepository studentRepository;

    @PostMapping("/students")
    public ResponseEntity<StudentEntity> createStudent(@RequestBody StudentEntity student) {
        StudentEntity saveStudent = studentRepository.save(student);
        return new ResponseEntity<>(saveStudent, HttpStatus.CREATED);
    }

    @GetMapping("/all-students")
    public ResponseEntity<List<StudentEntity>> getAllStudent() {
        List<StudentEntity> students = studentRepository.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/students/by-id/{student_id}")
    public ResponseEntity<StudentEntity> getStudentById( @PathVariable ("student_id") Integer studentId) {

        Optional<StudentEntity> student = studentRepository.findById(studentId);
        return student.map(studentEntity -> new ResponseEntity<>(studentEntity, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @DeleteMapping("/students/{student_id}")
    public void deleteStudent(@PathVariable("student_id") Integer id) {
        studentRepository.deleteById(id);
    }

    @GetMapping("/students/by-name/{studentName}")
    public ResponseEntity<StudentEntity> getStudentByName(@PathVariable("studentName") String studentName) {
        StudentEntity student = studentRepository.findStudentByName(studentName);

        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}










