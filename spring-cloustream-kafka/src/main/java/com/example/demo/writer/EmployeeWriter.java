package com.example.demo.writer;

import org.springframework.batch.infrastructure.item.Chunk;
import org.springframework.batch.infrastructure.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import com.example.demo.model.Employee;

@Component
public class EmployeeWriter implements ItemWriter<Employee> {

	@Autowired
	private StreamBridge streamBridge;

	@Override
	public void write(Chunk<? extends Employee> chunk) {

		chunk.forEach(employee -> {

			streamBridge.send("topicname-out-0", employee);

			System.out.println("Published : " + employee);

		});

	}

}