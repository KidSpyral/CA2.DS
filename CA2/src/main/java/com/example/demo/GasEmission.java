package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GasEmission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long emid;

	private String category;
    private int year;
    private String scenario;
    private String gasUnits;
    private String nk;
    private double value;
    
	public GasEmission(String category, int year, String scenario, String gasUnits, String nk,
			double value) {
		super();
		this.category = category;
		this.year = year;
		this.scenario = scenario;
		this.gasUnits = gasUnits;
		this.nk = nk;
		this.value = value;
	}
	
	public GasEmission (){
	
	}
	
	public Long getEmid() {
		return emid;
	}

	public void setEmid(Long emid) {
		this.emid = emid;
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

	public String getScenario() {
		return scenario;
	}

	public void setScenario(String scenario) {
		this.scenario = scenario;
	}

	public String getGasUnits() {
		return gasUnits;
	}

	public void setGasUnits(String gasUnits) {
		this.gasUnits = gasUnits;
	}

	public String getNk() {
		return nk;
	}

	public void setNk(String nk) {
		this.nk = nk;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
