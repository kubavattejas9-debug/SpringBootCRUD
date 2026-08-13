package com.example.SpringBootCRUD.Controller;

import com.example.SpringBootCRUD.Entity.StudentEntity;
import com.example.SpringBootCRUD.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<StudentEntity> CreateStudent(@RequestBody StudentEntity studentEntity){

       StudentEntity createdStudent = studentService.createdStudent(studentEntity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<StudentEntity> getStudent(@PathVariable Long id){
        StudentEntity studentResp = studentService.getStudent(id);

        if(studentResp == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentResp);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentEntity>> getAllStudent(){
        List<StudentEntity> studentList = studentService.getAllStudent();

        if(studentList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<StudentEntity> updateStudent(@PathVariable Long id,@RequestBody StudentEntity studentReqs){
        StudentEntity studentResp = studentService.updateStudent(id,studentReqs);

        if(studentResp == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentResp);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
    	Boolean isDeleted = studentService.deleteStudent(id);
    	
    	if(!isDeleted) {
    		return ResponseEntity.notFound().build();
    	}
    	return ResponseEntity.ok("Record Deleted");
    }
}
