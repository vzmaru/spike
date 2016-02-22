package com.fmr.papr.poc.intg;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.integration.launch.JobLaunchRequest;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.Message;

import java.io.File;

/**
 * Created by vishal on 2/17/16.
 */
public class FileMessageToJobRequest {

    private Job job;

    public void setJob(Job job) {
        this.job = job;
    }

    @Transformer
    public JobLaunchRequest toRequest(Message<File> message) {
        JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
        String fileName = message.getPayload().getName();
        fileName = fileName.substring(0, fileName.lastIndexOf('.'));
        String[] jobParams = fileName.split("_");
        String jobId = jobParams[0];
        String compositeId = jobParams[1];
        jobParametersBuilder.addString("jobId", jobId);
        jobParametersBuilder.addString("compositeId", compositeId);
        return new JobLaunchRequest(job, jobParametersBuilder.toJobParameters());
    }
}
