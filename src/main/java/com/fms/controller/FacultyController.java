package com.fms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fms.model.Faculty;
import com.fms.services.FacultyServices;

@Controller
public class FacultyController {
	
	@Autowired
	private FacultyServices facultyServices;

	@RequestMapping("/")
	public String indexPage() {
		return "index";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Faculty faculty) {
		
		System.out.println(faculty.getName() +" ======== "+faculty.getId());
		Faculty fData = facultyServices.saveFaculty(faculty);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("faculty-data");
		modelAndView.addObject("f", fData);
		return modelAndView;
	}
}
