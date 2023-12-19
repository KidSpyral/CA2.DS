package com.example.demo.repository;

import com.example.demo.GasEmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GasEmissionRepository extends JpaRepository<GasEmission,
Long> {
	// Additional custom queries can be added here if needed
	}

