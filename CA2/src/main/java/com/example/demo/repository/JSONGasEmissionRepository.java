package com.example.demo.repository;

import com.example.demo.JSONGasEmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JSONGasEmissionRepository extends JpaRepository<JSONGasEmission,
Long> {
	// Additional custom queries can be added here if needed
	}