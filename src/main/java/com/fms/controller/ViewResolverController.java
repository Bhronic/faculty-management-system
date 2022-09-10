package com.fms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewResolverController {

	@RequestMapping("/")
	public String indexPage() {
		return "index";
	}
}
