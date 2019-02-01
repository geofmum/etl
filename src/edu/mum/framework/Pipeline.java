package edu.mum.framework;

import edu.mum.framework.base.job.Job;

import java.util.ArrayList;
import java.util.List;

public class Pipeline {
    public static Pipeline instance;
    private List<Job> jobs = new ArrayList<>();

    private Pipeline() {
    }

    public static Pipeline getInstance() {
        synchronized (Pipeline.class) {
            if (instance == null) {
                instance = new Pipeline();
            }
        }

        return instance;
    }

    public void start() {
        jobs.forEach(job -> job.run());
    }

    public Pipeline addJob(Job job) {
        jobs.add(job);
        return this;
    }
}
