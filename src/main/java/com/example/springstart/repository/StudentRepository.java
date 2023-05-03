package com.example.springstart.repository;
import java.util.ArrayList;

import com.example.springstart.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository {
    ArrayList<Student> getstudents();
    Student getStudentById(int studentId);
    Student updateStudent(int studentId,Student student);

    String deletestudent(int studentId);

}
