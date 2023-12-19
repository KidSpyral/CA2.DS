package com.example.demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonParserToRun {

	public static void main(String[] args) throws IOException {

		File jsonFile = new File("C:/Users/kidsp/Downloads/GreenhouseGasEmissions2023.json");

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(jsonFile);

		int validEntries = 0;

		JsonNode emissionsNode = rootNode.get("Emissions");

		for (JsonNode emission : emissionsNode) {
			String category = emission.path("Category").asText();
			String gasUnits = emission.path("Gas Units").asText();
			double value = emission.path("Value").asDouble();

			if (value > 0) {
				validEntries++;

				System.out.println("Category: " + category);
				System.out.println("Gas Units: " + gasUnits);
				System.out.println("Value: " + value);
				System.out.println("                   ");

			}

		}

		System.out.println("\nTotal valid entries: " + validEntries);
		// Extract data properties
		JsonNode dataNode = rootNode.get("data");
		if (dataNode != null) {
			int year = dataNode.path("date").asInt();
			String country = dataNode.path("country").asText();

			System.out.println("Date: " + year);
			System.out.println("Country: " + country);
		} else {
			System.out.println("No 'data' object found in the JSON.");
		}
	}
}
