package com.fms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.fms.model.Faculty;
import com.fms.repository.FacultyRepository;

@Service
public class FacultyServices {

	@Autowired
	private FacultyRepository facultyRepository;

	@CacheEvict(value="faculty_info" ,allEntries=true)
	public Faculty saveFaculty(Faculty faculty) {
		return facultyRepository.save(faculty);
	}
	
	@Cacheable(value="faculty_info") 
	public List<Faculty> getFacultyList() {
		return facultyRepository.findAll();
	}
	
	public Faculty getFacultyId(Integer id) {
		return facultyRepository.findById(id).get();
	}
	
	public List<Faculty> getFacultyByName(String name) {
		return facultyRepository.findByAddress(name);//findByName(name);
	}
	
	public List<Faculty> getFacultyByNameOrAddress(Faculty search) {
		return facultyRepository.findByAddressAndName(search.getAddress(),search.getName());
	}
	
	public List<Faculty> deleteByFacultyId(Integer id) {
		facultyRepository.deleteById(id);
		return getFacultyList();
	}
	
	
}
