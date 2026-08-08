package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.DataNotFoundException;
import com.example.demo.model.tablea;
import com.example.demo.repository.TableRepository;
import com.example.demo.service.TableaService;
@Service
public class TableaServiceimpl implements TableaService {
	TableRepository tableRepository;

	public TableaServiceimpl(TableRepository tableRepository) {
		super();
		this.tableRepository = tableRepository;
	}

	@Override
	public List<tablea> getAll() {
		return tableRepository.findAll();
	}

	@Override
	public tablea getById(Long id) {
		return tableRepository.findById(id).orElseThrow(() -> new DataNotFoundException("NotFound"));
	}
	
	@Override
	public void deleteById(Long id) {
		tablea data = tableRepository.findById(id).orElseThrow(() -> new DataNotFoundException("NotFound"));
		if(data!=null) {
			tableRepository.deleteById(id);
		}
	}
	
	@Override
	public void addData(tablea data, Long id) {
		tableRepository.save(data);
		System.out.println("Data added");
	}
	
	@Override
	public ResponseEntity<String> updateData(Long id, tablea data) {
		tablea existingData = tableRepository.findById(id).orElseThrow(() -> new DataNotFoundException("NotFound"));
		if(existingData!=null) {
			existingData.setAddress(data.getAddress());
			existingData.setCity(data.getCity());
			existingData.setId(data.getId());
			existingData.setName(data.getName());
		}
		return ResponseEntity.ok("Updated data");
	}
}
