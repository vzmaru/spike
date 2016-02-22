package com.fmr.papr.poc;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;

public class App {
    public static void main(String[] args) {

        String[] springConfig =
                {
                        "spring/app-context.xml"
                };

        AbstractApplicationContext context = new ClassPathXmlApplicationContext(springConfig);

        // launchJob(context);
        context.registerShutdownHook();

        System.out.println("\n========================================================="
                + "\n                                                         "
                + "\n    Waiting for Job execution to finish.                 "
                + "\n                                                         "
                + "\n=========================================================" );

        final QueueChannel completeApplicationChannel =
                context.getBean("completeApplication", QueueChannel.class);

        completeApplicationChannel.receive();

        System.out.println("\nDone!!");

        System.exit(0);
    }

    private static void launchJob(ApplicationContext context) {
        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean("spikeCE");

        try {

            JobExecution execution = jobLauncher.run(job, new JobParametersBuilder()
                    .addString("jobId", "1")
                    .addString("compositeId", "1001")
                    .toJobParameters());
            System.out.println("Exit Status : " + execution.getStatus());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
