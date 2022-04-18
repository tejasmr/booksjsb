package com.tezzio.booksjsb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Root {
	@GetMapping("/")
	public String rootView() {
		return "common/root";
	}
}
