package com.example.demo.launcher;

import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.parameters.JobParameters;
import org.springframework.batch.core.job.parameters.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BatchLauncher {

	private final JobLauncher jobLauncher;
	private final Job job1;
	private final Job job2;

	public BatchLauncher(JobLauncher jobLauncher, Job job1, Job job2) {

		this.jobLauncher = jobLauncher;
		this.job1 = job1;
		this.job2 = job2;
	}

	@Scheduled(fixedDelay = 60000)
	public void launchJobs() throws Exception {

		JobParameters parameters = new JobParametersBuilder()

				.addLong("time", System.currentTimeMillis())

				.toJobParameters();

		jobLauncher.run(job1, parameters);

		jobLauncher.run(job2, parameters);

	}

}