
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
@RequestMapping("/api/gasemissions")
public class GasEmissionController {

	@Autowired
	private GasEmissionService gasEmissionService;

	@GetMapping
	public List<GasEmission> getAllGasEmissions() {
		return gasEmissionService.getAllGasEmissions();
	}

	@GetMapping("/gasemission/{id}")
	public ResponseEntity<GasEmission> getGasEmissionById(@PathVariable Long id) {
		GasEmission gasEmission = gasEmissionService.getGasEmissionById(id);
		if (gasEmission != null) {
			return new ResponseEntity<>(gasEmission, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/newgasemission")
	public ResponseEntity<GasEmission> addGasEmission(@RequestBody GasEmission gasEmission) {
		GasEmission savedGasEmission = gasEmissionService.addGasEmission(gasEmission);
		return new ResponseEntity<>(savedGasEmission, HttpStatus.CREATED);
	}

	@PutMapping("/updategasemission/{id}")
	public ResponseEntity<GasEmission> updateGasEmission(@PathVariable Long id, @RequestBody GasEmission gasEmission) {
		GasEmission updatedGasEmission = gasEmissionService.updateGasEmission(id, gasEmission);
		if (updatedGasEmission != null) {
			return new ResponseEntity<>(updatedGasEmission, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deletegasemission/{id}")
	public ResponseEntity<Void> deleteGasEmission(@PathVariable Long id) {
		gasEmissionService.deleteGasEmission(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
