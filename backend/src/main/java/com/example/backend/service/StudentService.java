package com.example.backend.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.backend.model.DbSequence;
import com.example.backend.model.Student;
import com.example.backend.repository.StudentRepository;


@Service
public class StudentService {
	
	
	
	@Autowired
    private MongoOperations mongoOperations;


	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student save(Student student) 
	{
		return studentRepository.save(student);
	}
	
	public List<Student> getAll(){ 
		return studentRepository.findAll();
	}
	
	 public List<Student> getAllSorted(){ 
		return studentRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
	}
	 
	 public int getSequenceNumber(String sequenceName) { 
	        
	        Query query = new Query(Criteria.where("id").is(sequenceName));
	        Update update = new Update().inc("seq", 1);
	        DbSequence counter = mongoOperations
	                .findAndModify(query,
	                        update, options().returnNew(true).upsert(true),
	                        DbSequence.class);

	        return !Objects.isNull(counter) ? counter.getSeq() : 1;
	 }

	public List<Student> findAll(Sort ascending) {
		return null;
	}
}
