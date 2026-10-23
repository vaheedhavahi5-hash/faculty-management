package com.example.faculty_management.repository;
import com.example.faculty_management.FacultyManagementApplication;

import com.example.faculty_management.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

}


