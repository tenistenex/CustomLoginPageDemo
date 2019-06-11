package com.example.demo3.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class MyController {
	@GetMapping("/")
	public String index() {    
	return "index";
	}
	
	@GetMapping("/login")
	 public String login () {
	        return "login";
	  }
	@GetMapping("/error")
	 public String error () {
	        return "error";
	  }
	
	
	
}
