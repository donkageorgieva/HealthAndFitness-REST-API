package com.health.fitness.spring.api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import healt.fitness.api.model.FitnessStatus;
import healt.fitness.api.model.HealthStatus;
import healt.fitness.api.model.Metrics;

@RestController
@CrossOrigin("*")
public class HealthController {
 
	@PostMapping("/bmi")
	public HealthStatus calculateBMIMetric(@RequestBody Metrics metrics) {
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
  
	@PostMapping("/calories")
	public double  calculteCalories(@RequestBody FitnessStatus stats) {
		double bmr = 0;
		if(stats.gender == 'm') {
	    bmr = 66.5 + (13.75 * stats.weight) + (5.003 * stats.height ) - (6.75 * stats.age);
		} else if (stats.gender == 'f') {
			bmr = 655.1 + (9.563 * stats.weight) + (1.850 * stats.height) - (4.676 * stats.age);
		} 
		return  bmr;
	}
	

}
