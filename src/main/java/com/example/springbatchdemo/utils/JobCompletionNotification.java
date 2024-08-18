package com.example.springbatchdemo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotification implements JobExecutionListener {

    private static Logger logger = LoggerFactory.getLogger(JobCompletionNotification.class);
    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            logger.info("Job completed successfully. Job Status: " + jobExecution.getStatus());
        }
    }
}
