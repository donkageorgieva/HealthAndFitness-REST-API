package com.health.fitness.spring.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import healt.fitness.api.model.Metrics;

@RestController
public class HealthController {

	@PostMapping("/bmi")
	public Double calculateBMI(@RequestBody Metrics metrics) {
		double meters = metrics.height / 100;
		double bmi = metrics.weight / (meters * meters);
		return bmi;
	}
}
