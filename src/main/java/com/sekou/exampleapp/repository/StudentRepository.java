package com.sekou.exampleapp.repository;

import com.sekou.exampleapp.student.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {


    StudentEntity findStudentByName(String studentName);
}
