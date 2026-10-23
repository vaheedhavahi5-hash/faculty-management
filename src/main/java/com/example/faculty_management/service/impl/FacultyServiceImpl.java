package com.example.faculty_management.service.impl;



import com.example.faculty_management.dto.FacultyDTO;
import com.example.faculty_management.entity.Faculty;
import com.example.faculty_management.repository.FacultyRepository;
import com.example.faculty_management.service.FacultyService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public FacultyDTO saveFaculty(FacultyDTO facultyDTO) {

        Faculty faculty = new Faculty();

        faculty.setEmployeeId(facultyDTO.getEmployeeId());
        faculty.setFullName(facultyDTO.getFullName());
        faculty.setEmail(facultyDTO.getEmail());
        faculty.setPhone(facultyDTO.getPhone());
        faculty.setDepartment(facultyDTO.getDepartment());
        faculty.setDesignation(facultyDTO.getDesignation());
        faculty.setEmploymentType(facultyDTO.getEmploymentType());
        faculty.setJoiningDate(facultyDTO.getJoiningDate());
        faculty.setStatus(facultyDTO.getStatus());

        Faculty savedFaculty = facultyRepository.save(faculty);

        return convertToDTO(savedFaculty);
    }

    @Override
    public List<FacultyDTO> getAllFaculty() {

        return facultyRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    @Override
    public FacultyDTO getFacultyById(Long id) {

        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Faculty not found with id: " + id));

        return convertToDTO(faculty);
    }

    @Override
    public FacultyDTO updateFaculty(Long id, FacultyDTO facultyDTO) {

        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Faculty not found with id: " + id));

        faculty.setEmployeeId(facultyDTO.getEmployeeId());
        faculty.setFullName(facultyDTO.getFullName());
        faculty.setEmail(facultyDTO.getEmail());
        faculty.setPhone(facultyDTO.getPhone());
        faculty.setDepartment(facultyDTO.getDepartment());
        faculty.setDesignation(facultyDTO.getDesignation());
        faculty.setEmploymentType(facultyDTO.getEmploymentType());
        faculty.setJoiningDate(facultyDTO.getJoiningDate());
        faculty.setStatus(facultyDTO.getStatus());

        Faculty updatedFaculty = facultyRepository.save(faculty);

        return convertToDTO(updatedFaculty);
    }

    @Override
    public void deleteFaculty(Long id) {

        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Faculty not found with id: " + id));

        facultyRepository.delete(faculty);
    }

    private FacultyDTO convertToDTO(Faculty faculty) {

        FacultyDTO dto = new FacultyDTO();

        dto.setId(faculty.getId());
        dto.setEmployeeId(faculty.getEmployeeId());
        dto.setFullName(faculty.getFullName());
        dto.setEmail(faculty.getEmail());
        dto.setPhone(faculty.getPhone());
        dto.setDepartment(faculty.getDepartment());
        dto.setDesignation(faculty.getDesignation());
        dto.setEmploymentType(faculty.getEmploymentType());
        dto.setJoiningDate(faculty.getJoiningDate());
        dto.setStatus(faculty.getStatus());

        return dto;
    }
}



