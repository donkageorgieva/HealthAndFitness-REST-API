package com.health.fitness.spring.api.controller;

import org.springframework.stereotype.Controller;

@Controller
public class HealthController {

	public double getBMI(double kg, double cm) {
		double meters = cm / 100;
		double bmi = kg / (meters * meters);
		return bmi;
	}
}
