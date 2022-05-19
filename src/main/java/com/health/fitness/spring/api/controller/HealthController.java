package com.health.fitness.spring.api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import healt.fitness.api.model.CalorieVariations;
import healt.fitness.api.model.HealthStatus;


@RestController
@CrossOrigin("*")
public class HealthController {

	@GetMapping("/bmi")
	public HealthStatus calculateBMIMetric(@RequestParam Double height, @RequestParam Double weight  ) {
		height = height / 100;
		double bmi = weight / (height * height);
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

	@GetMapping("/calories")
	public CalorieVariations  calculteCalories(@RequestParam Double height,  @RequestParam Double weight, @RequestParam  int age,  @RequestParam char gender, @RequestParam char activity) {
		double bmr = 0;
		int calories = 0;
		if(gender == 'm') {
	    bmr = 66.5 + (13.75 * weight) + (5.003 * height ) - (6.75 * age);
		} else if (gender == 'f') {
			bmr = 655.1 + (9.563 * weight) + (1.850 * height) - (4.676 * age);
		} 
		if(activity == 'n') {
			calories = (int)(bmr * 1.2);
		} else if (activity == 's') {
			calories = (int)(bmr * 1.375);
		}else if (activity == 'm') {
			calories = (int)(bmr * 1.55);
		}else if (activity == 'l') {
			calories = (int)(bmr * 1.725);
		}else if (activity == 'x') {
			calories = (int)(bmr * 1.9);
		}
		
		return new CalorieVariations(calories - 500,calories - 200, calories, calories + 200);

	}
	

}
