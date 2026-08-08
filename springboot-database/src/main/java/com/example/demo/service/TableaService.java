package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.tablea;


public interface TableaService {

	List<tablea> getAll();
	tablea getById(Long id);
	void deleteById(Long id);
	void addData(tablea data, Long id);
	ResponseEntity<String> updateData(Long id, tablea data);
}
