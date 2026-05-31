package com.example.demo.writer;

import org.springframework.batch.infrastructure.item.Chunk;
import org.springframework.batch.infrastructure.item.ItemWriter;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.model.MonitoringRecord;

@Component
public class KafkaMonitoringWriter implements ItemWriter<MonitoringRecord> {

	private final KafkaTemplate<String, String> kafkaTemplate;

	public KafkaMonitoringWriter(KafkaTemplate<String, String> kafkaTemplate) {

		this.kafkaTemplate = kafkaTemplate;
	}

	@Override
	public void write(Chunk<? extends MonitoringRecord> chunk) {

		for (MonitoringRecord record : chunk.getItems()) {

			String message = record.getServiceName() + " : " + record.getStatus();

			kafkaTemplate.send("monitoring-topic", message);

			System.out.println("Sent To Kafka : " + message);
		}
	}
}