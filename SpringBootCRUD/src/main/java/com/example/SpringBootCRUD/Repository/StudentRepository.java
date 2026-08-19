package com.example.SpringBootCRUD.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootCRUD.Entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    Optional<StudentEntity> findByIdAndDeletedIsFalse(Long id);

    List<StudentEntity> findByDeletedIsFalse();
}