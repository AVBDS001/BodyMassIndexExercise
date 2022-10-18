package entities;

import services.BodyMassIndex;

public class Pacient implements BodyMassIndex {
    private String name;
    private Double bodyMass;
    private Double height;

    public Pacient() {
    }

    public Pacient(String name, Double bodyMass, Double height) {
        if (bodyMass <= 0 || height <= 0) {
            throw new IllegalStateException("Error: invalid input");
        }
        else {
            this.name = name;
            this.bodyMass = bodyMass;
            this.height = height;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBodyMass() {
        return bodyMass;
    }

    public void setBodyMass(Double bodyMass) {
        this.bodyMass = bodyMass;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public double BMI() {
        return bodyMass / Math.pow(height, 2);
    }

    @Override
    public String bmiClassification() {
        if (BMI() < 20.0) {
            return "Underweight";
        }
        else if (BMI() >= 20.0 && BMI() < 25.0) {
            return "Normal";
        }
        else if (BMI() >= 25.0 && BMI() < 30.0) {
            return "Overweight";
        }
        else if (BMI() >= 30.0 && BMI() < 35.0) {
            return "Obese";
        }
        else if (BMI() >= 35.0) {
            return "Extremely obese";
        }
        else {
            return "Invalid values";
        }
    }

    public String toString() {
        return   "Name: " + name
                +"\nBody mass: " + bodyMass
                +"\nHeight: " + height
                +"\nBMI: " + String.format("%.2f", BMI())
                +"\n";
    }
}
