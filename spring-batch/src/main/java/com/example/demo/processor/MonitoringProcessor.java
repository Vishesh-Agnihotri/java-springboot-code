package com.example.demo.processor;


import org.springframework.batch.infrastructure.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.demo.model.MonitoringRecord;

@Component
public class MonitoringProcessor implements ItemProcessor<MonitoringRecord, MonitoringRecord> {

	@Override
	public MonitoringRecord process(MonitoringRecord item) {

		item.setStatus(item.getStatus().toUpperCase());

		System.out.println("Processing : " + item.getServiceName() + " -> " + item.getStatus());

		return item;
	}
}