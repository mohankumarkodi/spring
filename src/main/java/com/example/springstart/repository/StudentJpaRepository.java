package com.example.springstart.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springstart.model.Student;

import java.util.ArrayList;


@Repository
public interface StudentJpaRepository extends JpaRepository<Student,Integer>  {

}
