package io.myCode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/msg")
	public String get()
	{
		return "Welcome to the Home Controller";
	}

}
