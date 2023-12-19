package com.example.demo;

import java.util.List;
import com.example.demo.GasEmission;

public interface GasEmissionService {
	
	List<GasEmission> getAllGasEmissions();

	GasEmission getGasEmissionById(Long id);

	GasEmission addGasEmission(GasEmission gasEmission);

	GasEmission updateGasEmission(Long id, GasEmission gasEmission);

	void deleteGasEmission(Long id);

}
