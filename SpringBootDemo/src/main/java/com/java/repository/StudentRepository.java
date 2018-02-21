package com.java.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.java.model.Student;

public interface StudentRepository extends PagingAndSortingRepository<Student, Integer>{
	
	public List<Student> findByName(String name);
	
	public Page<Student> findByNameContaining(String name, Pageable p);

	@Query(value="from Student where marks > ?", nativeQuery=false)
	public List<Student> findByQuote(String quote);
	
	
	public Student findByIdAndName(int id, String name);
	
	public List<Student> findDistinctStudentByName(String name);
	
	public List<Student> findByNameIgnoreCase(String name);
	
	public List<Student> findByNameOrderByIdAsc(String name);
	
	
	
	
	
}
