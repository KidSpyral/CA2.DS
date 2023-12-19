package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.GasEmissionRepository;

@Service
public class GasEmissionServiceImpl implements GasEmissionService {

	@Autowired
	private GasEmissionRepository gasEmissionRepository;

	@Override
	public List<GasEmission> getAllGasEmissions() {
		return gasEmissionRepository.findAll();
	}

	@Override
	public GasEmission getGasEmissionById(Long id) {
		return gasEmissionRepository.findById(id).orElse(null);
	}

	@Override
	public GasEmission addGasEmission(GasEmission gasEmission) {
		return gasEmissionRepository.save(gasEmission);
	}

	@Override
	public GasEmission updateGasEmission(Long id, GasEmission updatedGasEmission) {
		Optional<GasEmission> existingGasEmissionOptional = gasEmissionRepository.findById(id);
		if (existingGasEmissionOptional.isPresent()) {
			GasEmission existingGasEmission = existingGasEmissionOptional.get();
			existingGasEmission.setCategory(updatedGasEmission.getCategory());
			existingGasEmission.setYear(updatedGasEmission.getYear());
			existingGasEmission.setScenario(updatedGasEmission.getScenario());
			existingGasEmission.setGasUnits(updatedGasEmission.getGasUnits());
			existingGasEmission.setNk(updatedGasEmission.getNk());
			existingGasEmission.setValue(updatedGasEmission.getValue());
			return gasEmissionRepository.save(existingGasEmission);
		} else {
			return null;
		}
	}

	@Override
	public void deleteGasEmission(Long id) {
		gasEmissionRepository.deleteById(id);
	}

}
