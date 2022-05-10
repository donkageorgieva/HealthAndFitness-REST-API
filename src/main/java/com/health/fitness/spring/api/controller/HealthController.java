package com.health.fitness.spring.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

	@PostMapping("/bmi")
	public double calculateBMI(double kg, double cm) {
		double meters = cm / 100;
		double bmi = kg / (meters * meters);
		return bmi;
	}
}
