package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jsongasemissions")
public class JSONGasEmissionController {

	@Autowired
	private JSONGasEmissionService JSONgasEmissionService;

	@GetMapping
	public List<JSONGasEmission> getAllJSONGasEmissions() {
		return JSONgasEmissionService.getAllJSONGasEmissions();
	}

	@GetMapping("/jsongasemission/{id}")
	public ResponseEntity<JSONGasEmission> getJSONGasEmissionById(@PathVariable Long id) {
		JSONGasEmission JSONgasEmission = JSONgasEmissionService.getJSONGasEmissionById(id);
		if (JSONgasEmission != null) {
			return new ResponseEntity<>(JSONgasEmission, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/newjsongasemission")
	public ResponseEntity<JSONGasEmission> addJSONGasEmission(@RequestBody JSONGasEmission JSONgasEmission) {
		JSONGasEmission savedJSONGasEmission = JSONgasEmissionService.addJSONGasEmission(JSONgasEmission);
		return new ResponseEntity<>(savedJSONGasEmission, HttpStatus.CREATED);
	}

	@PutMapping("/updatejsongasemission/{id}")
	public ResponseEntity<JSONGasEmission> updateJSONGasEmission(@PathVariable Long id,
			@RequestBody JSONGasEmission JSONgasEmission) {
		JSONGasEmission updatedJSONGasEmission = JSONgasEmissionService.updateJSONGasEmission(id, JSONgasEmission);
		if (updatedJSONGasEmission != null) {
			return new ResponseEntity<>(updatedJSONGasEmission, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deletejsongasemission/{id}")
	public ResponseEntity<Void> deleteJSONGasEmission(@PathVariable Long id) {
		JSONgasEmissionService.deleteJSONGasEmission(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
