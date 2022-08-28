package com.firealgo.completerestapidemoapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aspects")
public class VerifyAspectsLoggingController {
	
	@GetMapping("/add")
	public int add(Integer a, Integer b) {
		int[] arr = new int[2];
//		int val = arr[10];
		return a + b;
		
	}
	@GetMapping("/minus")
	public String substract(@RequestParam("a") String a, @RequestParam("b") String b) {
		return a + b;
	}

}
