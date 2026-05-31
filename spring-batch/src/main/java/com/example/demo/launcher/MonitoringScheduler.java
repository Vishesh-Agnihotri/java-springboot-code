package com.example.demo.launcher;

import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.parameters.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MonitoringScheduler {

	private final JobLauncher jobLauncher;
	private final Job monitoringJob;

	public MonitoringScheduler(JobLauncher jobLauncher, Job monitoringJob) {

		this.jobLauncher = jobLauncher;
		this.monitoringJob = monitoringJob;
	}

	@Scheduled(fixedRate = 6000)
	public void runJob() throws Exception {

		jobLauncher.run(monitoringJob,
				new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters());
	}
}