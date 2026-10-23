package com.example.faculty_management.service;




import com.example.faculty_management.dto.FacultyDTO;

import java.util.List;

public interface FacultyService {

    FacultyDTO saveFaculty(FacultyDTO facultyDTO);

    List<FacultyDTO> getAllFaculty();

    FacultyDTO getFacultyById(Long id);

    FacultyDTO updateFaculty(Long id, FacultyDTO facultyDTO);

    void deleteFaculty(Long id);
}



