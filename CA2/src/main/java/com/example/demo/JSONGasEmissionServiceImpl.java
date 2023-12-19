package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.GasEmissionRepository;
import com.example.demo.repository.JSONGasEmissionRepository;

@Service
public class JSONGasEmissionServiceImpl implements JSONGasEmissionService{
	

	@Autowired
	private JSONGasEmissionRepository JSONgasEmissionRepository;
	

	@Override
	public List<JSONGasEmission> getAllJSONGasEmissions() {
		return JSONgasEmissionRepository.findAll();
	}

	@Override
	public JSONGasEmission getJSONGasEmissionById(Long id) {
		return JSONgasEmissionRepository.findById(id).orElse(null);
	}

	@Override
	public JSONGasEmission addJSONGasEmission(JSONGasEmission JSONgasEmission) {
		return JSONgasEmissionRepository.save(JSONgasEmission);
	}

	@Override
	public JSONGasEmission updateJSONGasEmission(Long id, JSONGasEmission updatedJSONGasEmission) {
		Optional<JSONGasEmission> existingJSONGasEmissionOptional = JSONgasEmissionRepository.findById(id);
		if (existingJSONGasEmissionOptional.isPresent()) {
			JSONGasEmission existingJSONGasEmission = existingJSONGasEmissionOptional.get();
			existingJSONGasEmission.setCategory(updatedJSONGasEmission.getCategory());
			existingJSONGasEmission.setYear(updatedJSONGasEmission.getYear());
			existingJSONGasEmission.setGasUnits(updatedJSONGasEmission.getGasUnits());
			existingJSONGasEmission.setValue(updatedJSONGasEmission.getValue());
			return JSONgasEmissionRepository.save(existingJSONGasEmission);
		} else {
			return null;
		}
	}

	@Override
	public void deleteJSONGasEmission(Long id) {
		JSONgasEmissionRepository.deleteById(id);
	}

}
