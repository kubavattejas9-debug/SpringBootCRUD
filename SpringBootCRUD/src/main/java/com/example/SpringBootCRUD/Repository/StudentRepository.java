package com.example.SpringBootCRUD.Repository;

import com.example.SpringBootCRUD.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity , Long> {
	
}
