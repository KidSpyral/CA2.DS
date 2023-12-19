package com.example.demo;

import java.util.List;
import com.example.demo.JSONGasEmission;

public interface JSONGasEmissionService {
	
	List<JSONGasEmission> getAllJSONGasEmissions();
	
	JSONGasEmission getJSONGasEmissionById(Long id);

	JSONGasEmission addJSONGasEmission(JSONGasEmission JSONgasEmission);

	JSONGasEmission updateJSONGasEmission(Long id, JSONGasEmission JSONgasEmission);

	void deleteJSONGasEmission(Long id);

}
