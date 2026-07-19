package com.example.demo.reader;

import java.util.List;

import org.springframework.batch.infrastructure.item.ItemReader;
import org.springframework.stereotype.Component;

import com.example.demo.model.Employee;

import jakarta.annotation.PostConstruct;

@Component
public class EmployeeReader implements ItemReader<Employee> {

	private List<Employee> employees;
	private int count = 0;

	@PostConstruct
	public void init() {

		employees = List.of(

				new Employee(1, "John", 50000), new Employee(2, "David", 65000), new Employee(3, "Sam", 72000),
				new Employee(4, "Mike", 80000)

		);
	}

	@Override
	public Employee read() {

		if (count < employees.size()) {

			return employees.get(count++);
		}

		return null;
	}

}