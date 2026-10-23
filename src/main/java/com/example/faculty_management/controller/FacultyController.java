package com.example.faculty_management.controller;



import com.example.faculty_management.dto.FacultyDTO;
import com.example.faculty_management.service.FacultyService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculty")
@CrossOrigin(origins = "http://localhost:5173")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    // Create faculty
    @PostMapping
    public FacultyDTO saveFaculty(@RequestBody FacultyDTO facultyDTO) {
        return facultyService.saveFaculty(facultyDTO);
    }

    // Get all faculty
    @GetMapping
    public List<FacultyDTO> getAllFaculty() {
        return facultyService.getAllFaculty();
    }

    // Get faculty by ID
    @GetMapping("/{id}")
    public FacultyDTO getFacultyById(@PathVariable Long id) {
        return facultyService.getFacultyById(id);
    }

    // Update faculty
    @PutMapping("/{id}")
    public FacultyDTO updateFaculty(
            @PathVariable Long id,
            @RequestBody FacultyDTO facultyDTO) {
        return facultyService.updateFaculty(id, facultyDTO);
    }

    // Delete faculty
    @DeleteMapping("/{id}")
    public String deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return "Faculty deleted successfully";
    }
}


