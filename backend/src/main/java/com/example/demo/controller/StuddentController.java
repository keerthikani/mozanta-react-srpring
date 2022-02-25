package com.example.demo.controller;
import java.util.List;
import java.util.regex.Pattern;

import com.example.demo.model.student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentMongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
@CrossOrigin


public class StudentController {
	@Autowired
	private StudentService studentService;
	
	
	@PostMapping("/send")
	public ResponseEntity<Student> save(@RequestBody Student student) 
	{
		
		if (student.getUserName() == "" || student.getStandard() == "" || student.getDivision() == "" || student.getGender() == "" || student.getDob() == ""
			|| student.getUserName() == null || student.getStandard() == null || student.getDivision() == null || student.getGender() == null || student.getDob() == null
			 || !(Pattern.matches("^[A-Za-z ]*$",(student.getUserName())))
			 || !(Pattern.matches("^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$",(student.getDob()))) 
			 || !(Pattern.matches("^(I{1,3}|I{0,1}V|VI{0,3}|I{0,1}X|XI{0,2})$",(student.getStandard())))
			 || !(Pattern.matches("^(A|B|C)$",(student.getDivision())))
			 || !(Pattern.matches("^(male|female)$",(student.getGender())))
			 ) 
		{ 
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE); 
		}
		else 
		{
			student.setRollNumber(studentService.getSequenceNumber(student.getSequenceName())); 
			return new ResponseEntity<>(studentService.save(student),HttpStatus.ACCEPTED); 
		}
	}
	
	
	@RequestMapping("/getAll") 
	public List<Student> getAll(){
		return studentService.getAll();
	}
	
	
	@RequestMapping("/getAllByName")
	public List<Student> getAllSorted(){
		return studentService.getAllSorted();
	}
	
}



