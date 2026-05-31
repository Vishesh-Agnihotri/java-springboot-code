package com.example.demo.reader;

import java.util.List;

import org.springframework.batch.infrastructure.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.MonitoringRecord;

@Configuration
public class MonitoringReader {

	@Bean
	public ListItemReader<MonitoringRecord> reader() {

		return new ListItemReader<>(List.of(new MonitoringRecord("USER-SERVICE", "UP"),
				new MonitoringRecord("ORDER-SERVICE", "UP"), new MonitoringRecord("PAYMENT-SERVICE", "DOWN")));
	}
}