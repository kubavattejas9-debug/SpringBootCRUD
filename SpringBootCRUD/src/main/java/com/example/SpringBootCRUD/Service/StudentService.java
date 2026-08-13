package com.example.SpringBootCRUD.Service;

import com.example.SpringBootCRUD.Entity.StudentEntity;
import com.example.SpringBootCRUD.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    

    public StudentEntity createdStudent(StudentEntity studentReq){
        StudentEntity studentResp = studentRepository.save(studentReq);
        return studentResp;
    }
    

    public StudentEntity getStudent(Long id) {
        Optional<StudentEntity> studentResp = studentRepository.findById(id);

        if(studentResp.isPresent()){
            return studentResp.get();
        }
        return null;
    }
    

    public List<StudentEntity> getAllStudent(){
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        return studentEntityList;
    }
    
    
    public StudentEntity updateStudent(Long id,StudentEntity studentReq) {
    	Optional<StudentEntity> ExistingStudent = studentRepository.findById(id);
    	
    	if(ExistingStudent.isEmpty()) {
    		return null;
    	}
		StudentEntity studentToSave=ExistingStudent.get();
		studentToSave.setName(studentReq.getName());
		studentToSave.setRollno(studentReq.getRollno());
		studentToSave.setAge(studentReq.getAge());
		studentToSave.setEmail(studentReq.getEmail());
		studentToSave.setSubject(studentReq.getSubject());
		
		return studentRepository.save(studentToSave);
	}

    
	public Boolean deleteStudent(Long id) {
		Boolean isStudent = studentRepository.existsById(id);		
		if(!isStudent) return false;
		
		studentRepository.deleteById(id);
		
		return true;
	}
}
