package com.example.faculty_management.dto;
import lombok.Data;
import java.time.LocalDate;

@Data
public class FacultyDTO {

    private Long id;
    private String employeeId;
    private String fullName;
    private String email;
    private String phone;
    private String department;
    private String designation;
    private String employmentType;
    private LocalDate joiningDate;
    private String status;

}







