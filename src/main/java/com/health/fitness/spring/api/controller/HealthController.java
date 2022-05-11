package com.health.fitness.spring.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import healt.fitness.api.model.HealthStatus;
import healt.fitness.api.model.Metrics;

@RestController
public class HealthController {

	@PostMapping("/bmi")
	public HealthStatus calculateBMI(@RequestBody Metrics metrics) {
		double meters = metrics.height / 100;
		double bmi = metrics.weight / (meters * meters);
		String bmiRange;
		if(bmi < 18.5) {
			bmiRange = "underweight";
		} else if (bmi > 18.5 && bmi<24.9) {
			bmiRange = "healthy";
		} else {
			bmiRange = "overweight";
		}
		return new HealthStatus( bmi, bmiRange);
	}
}
