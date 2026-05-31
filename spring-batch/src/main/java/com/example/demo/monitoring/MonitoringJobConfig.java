package com.example.demo.monitoring;

import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.item.support.ListItemReader;
import org.springframework.batch.infrastructure.support.transaction.ResourcelessTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.demo.model.MonitoringRecord;
import com.example.demo.processor.MonitoringProcessor;
import com.example.demo.writer.KafkaMonitoringWriter;

@Configuration
public class MonitoringJobConfig {
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new ResourcelessTransactionManager();
	}

	@Bean
	public Step monitoringStep(JobRepository jobRepository, PlatformTransactionManager transactionManager,
			ListItemReader<MonitoringRecord> reader, MonitoringProcessor processor, KafkaMonitoringWriter writer) {

		return new StepBuilder("monitoringStep", jobRepository)
				.<MonitoringRecord, MonitoringRecord>chunk(2, transactionManager).reader(reader).processor(processor)
				.writer(writer).build();
	}

	@Bean
	public Job monitoringJob(JobRepository jobRepository, Step monitoringStep) {

		return new JobBuilder("monitoringJob", jobRepository).start(monitoringStep).build();
	}
}