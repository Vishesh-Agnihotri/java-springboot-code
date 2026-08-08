package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.tablea;
import com.example.demo.service.TableaService;

@RestController
public class TableController {
	TableaService tableaService;
	
	public TableController(TableaService tableaService) {
		super();
		this.tableaService = tableaService;
	}

	@GetMapping("/all")
	public List<tablea> getAll(){
		return tableaService.getAll();
	}
	
	@GetMapping("/get/{id}")
	public tablea getById(@PathVariable Long id) {
		return tableaService.getById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Long id) {
		tableaService.deleteById(id);
	}
	
	@PostMapping("/add/{id}")
	public void addData(@RequestBody tablea data,@PathVariable Long id) {
		tableaService.addData(data,id);
	}
	
	@PutMapping("/updateData/{id}")
	public void updateData(@PathVariable Long id, @RequestBody tablea data) {
		tableaService.updateData(id,data);
	}
}
