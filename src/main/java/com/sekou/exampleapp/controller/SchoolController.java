package com.sekou.exampleapp.controller;

import com.sekou.exampleapp.repository.SchoolRepository;
import com.sekou.exampleapp.school.SchoolEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v2")
public class SchoolController {
    private final SchoolRepository schoolRepository;

    @PostMapping("/school")
    public ResponseEntity<SchoolEntity> create(@RequestBody SchoolEntity school) {
        SchoolEntity saveSchool = schoolRepository.save(school);
        return ResponseEntity.ok(saveSchool);
    }
}
