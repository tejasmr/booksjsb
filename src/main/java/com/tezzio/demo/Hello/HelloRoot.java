package com.tezzio.demo.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRoot {
	@GetMapping
	public String helloRoot() {
		return "Hello, root";
	}
}
