package com.fms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fms.model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

	List<Faculty> findByName(String name);
	
	List<Faculty> findByAddress(String name);

}
