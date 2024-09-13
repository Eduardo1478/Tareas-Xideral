package com.example.shopping_cart_rest_api_jpa.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BatchScheduler {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job salesReportJob;

    // Schedule to run the sales report every day at 1 AM
    @Scheduled(cron = "0 0 1 * * ?")
    public void runSalesReportJob() throws Exception {
        JobParameters params = new JobParametersBuilder()
            .addLong("time", System.currentTimeMillis()) // Unique job parameter to prevent duplicate runs
            .toJobParameters();
        jobLauncher.run(salesReportJob, params);
    }
}
