package healt.fitness.api.model;

public class HealthStatus {
public Double bmi;
public String bmiRange;
public HealthStatus(double bmi, String bmiRange) {
	this.bmi = bmi;
	this.bmiRange = bmiRange;
	
}
}
