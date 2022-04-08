package com.tezzio.demo.Hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
	@RequestMapping("/")
	public String hello(Model model) {
		return "hello";
	}
}
