package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class JSONGasEmission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long emid;
	
	private String category;
    private String gasUnits;
    private double value;
    private int year;
    
    public JSONGasEmission(String category, int year, String gasUnits, double value) {
		super();
		this.category = category;
		this.year = year;
		this.gasUnits = gasUnits;
		this.value = value;
	}
    
    public JSONGasEmission() {
	
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGasUnits() {
		return gasUnits;
	}

	public void setGasUnits(String gasUnits) {
		this.gasUnits = gasUnits;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
