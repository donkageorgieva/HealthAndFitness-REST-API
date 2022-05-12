package com.health.fitness.spring.api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import healt.fitness.api.model.CalorieVariations;
import healt.fitness.api.model.FitnessStatus;
import healt.fitness.api.model.HealthStatus;
import healt.fitness.api.model.Metrics;

@RestController
@CrossOrigin("*")
public class HealthController {
 
	@PostMapping("/bmi")
	public HealthStatus calculateBMIMetric(@RequestBody Metrics metrics) {
	
		double bmi = metrics.weight / (metrics.height * metrics.height);
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
	public CalorieVariations  calculteCalories(@RequestBody FitnessStatus stats) {
		double bmr = 0;
		int calories = 0;
		if(stats.gender == 'm') {
	    bmr = 66.5 + (13.75 * stats.weight) + (5.003 * stats.height ) - (6.75 * stats.age);
		} else if (stats.gender == 'f') {
			bmr = 655.1 + (9.563 * stats.weight) + (1.850 * stats.height) - (4.676 * stats.age);
		} 
		if(stats.activityFactor == 'n') {
			calories = (int)(bmr * 1.2);
		} else if (stats.activityFactor == 's') {
			calories = (int)(bmr * 1.375);
		}else if (stats.activityFactor == 'm') {
			calories = (int)(bmr * 1.55);
		}else if (stats.activityFactor == 'l') {
			calories = (int)(bmr * 1.725);
		}else if (stats.activityFactor == 'x') {
			calories = (int)(bmr * 1.9);
		}
		
		return new CalorieVariations(calories - 500,calories - 200, calories, calories + 200);

	}
	

}
