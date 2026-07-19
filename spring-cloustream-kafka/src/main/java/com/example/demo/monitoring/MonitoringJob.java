package com.example.demo.monitoring;

import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.demo.model.Employee;
import com.example.demo.processor.EmployeeProcessor;
import com.example.demo.reader.EmployeeReader;
import com.example.demo.writer.EmployeeWriter;

@Configuration
public class MonitoringJob {

	@Autowired
	JobRepository jobRepository;

	@Autowired
	PlatformTransactionManager transactionManager;

	@Bean
	public Step step1(EmployeeReader reader, EmployeeProcessor processor, EmployeeWriter writer) {

		return new StepBuilder("step1", jobRepository).<Employee, Employee>chunk(2, transactionManager).reader(reader)
				.processor(processor).writer(writer).build();

	}

	@Bean
	public Step step2(EmployeeReader reader, EmployeeProcessor processor, EmployeeWriter writer) {

		return new StepBuilder("step2", jobRepository).<Employee, Employee>chunk(2, transactionManager).reader(reader)
				.processor(processor).writer(writer).build();

	}

	@Bean
	public Flow flow1(Step step1) {

		return new FlowBuilder<Flow>("flow1").start(step1).build();

	}

	@Bean
	public Flow flow2(Step step2) {

		return new FlowBuilder<Flow>("flow2").start(step2).build();

	}

	@Bean
	public Job job1(Flow flow1) {

		return new JobBuilder("job1", jobRepository).start(flow1).end().build();

	}

	@Bean
	public Job job2(Flow flow2) {

		return new JobBuilder("job2", jobRepository).start(flow2).end().build();

	}

}