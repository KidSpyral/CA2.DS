package com.example.demo;

import com.example.demo.repository.GasEmissionRepository;
import com.example.demo.repository.JSONGasEmissionRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JSONParser implements CommandLineRunner {

	@Autowired
	private JSONGasEmissionRepository JSONgasEmissionRepository;

	@Override
	public void run(String... args) throws Exception {

		File jsonFile = new File("C:/Users/kidsp/Downloads/GreenhouseGasEmissions2023.json");

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(jsonFile);

		JsonNode emissionsNode = rootNode.get("Emissions");

		for (JsonNode emission : emissionsNode) {
			String category = emission.path("Category").asText();
			String gasUnits = emission.path("Gas Units").asText();
			double value = emission.path("Value").asDouble();

			JsonNode dataNode = rootNode.get("data");
			if (dataNode != null) {
				int year = dataNode.path("date").asInt();

				if (value > 0) {

					JSONGasEmission JSONgasEmission = new JSONGasEmission(category, year, gasUnits, value);
					JSONgasEmissionRepository.save(JSONgasEmission);

				}

			}

		}
	}
}
