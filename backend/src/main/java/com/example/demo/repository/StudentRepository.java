package com.keerthi.demo.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.keerthi.demo.model.Student;
@Repository
public interface StudentRepository extends MongoRepository<Student, String>{
    
}