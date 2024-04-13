package com.sekou.exampleapp.repository;

import com.sekou.exampleapp.school.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<SchoolEntity, Integer> {
}
