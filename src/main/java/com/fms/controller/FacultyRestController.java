package com.fms.controller;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fms.model.Faculty;
import com.fms.services.FacultyServices;

@RestController
public class FacultyRestController {
	
	private FacultyServices facultyServices;
	
	private JdbcTemplate jdbc;  
	
	public FacultyRestController(FacultyServices facultyServices, JdbcTemplate jdbc) {
		this.facultyServices = facultyServices;
		this.jdbc = jdbc;
	}

	@PostMapping("/faculty") 
	public Faculty saveFacultyData(@RequestBody Faculty faculty) {
		return facultyServices.saveFaculty(faculty);
	}
	
	@RequestMapping(value = "/faculty",method = RequestMethod.GET)
	public List<Faculty> getFacultyData() {

		System.out.println("customer information from cache");  
		return facultyServices.getFacultyList();
	}
	
	@RequestMapping(value = "/faculty/{id}",method = RequestMethod.GET)
	public Faculty getFacultyById(@PathVariable("id") Integer id ) {
		return facultyServices.getFacultyId(id);
	}
	
	@GetMapping("/faculty/name")
	public List<Faculty> getFacultyByFacultyName(@RequestParam ("name") String name) {
		return facultyServices.getFacultyByName(name);
	}
	
	
	@PostMapping("/faculty/search")
	public Faculty searchFacultyData(@RequestBody Faculty faculty) {
		List<Faculty> list = facultyServices.getFacultyList();
		return list.stream().filter(n -> n.getName().toLowerCase().contains(faculty.getName().toLowerCase())).findFirst().get();
	}
	
	@PostMapping("/faculty/api")
	public List<Faculty> searchAPIforFacultyData(@RequestBody Faculty serach) {
		List<Faculty> list = facultyServices.getFacultyByNameOrAddress(serach);
		return list;
	}
	
	
	@PatchMapping("/faculty")
	public Faculty updateFacultyData(@RequestBody Faculty faculty) {
		return facultyServices.saveFaculty(faculty);
	}
	
	
	@DeleteMapping("/faculty/{id}")
	public List<Faculty> deleteFacultyData(@PathVariable Integer id) {
		return facultyServices.deleteByFacultyId(id);
	}
	
    @RequestMapping("/insert")  
    public String index(){  
        jdbc.execute("insert into faculty_data(id,faculty_name,faculty_address)values(5,'javatpoint','mumbai')");  
        return"data inserted Successfully";  
    }  
	 
}

