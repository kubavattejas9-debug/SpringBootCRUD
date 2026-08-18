package com.example.SpringBootCRUD.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootCRUD.Entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    Optional<StudentEntity> findByIdAndDeletedIsFalse(Long id);

    List<StudentEntity> findByDeletedIsFalse();

    Boolean existsByEmail(String emailId);
}