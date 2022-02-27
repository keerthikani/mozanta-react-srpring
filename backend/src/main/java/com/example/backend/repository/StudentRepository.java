package com.example.backend.repository;




import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.backend.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> { 
	
}
