package com.test.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author yhpku
 */
public class MyJob implements org.quartz.Job {

    public MyJob() {
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.err.println("Hello World!  MyJob is executing.");
    }

    public static void main(String [] args){
        JobDetail job = newJob(MyJob.class)
                .withIdentity("job1", "group1")
                .build();

        // Trigger the job to run now, and then repeat every 40 seconds
        Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                                      .withIntervalInSeconds(40)
                                      .repeatForever())
                .build();

        // Grab the Scheduler instance from the Factory
        Scheduler scheduler = null;
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            // and start it off
            scheduler.start();

            // Tell quartz to schedule the job using our trigger
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
