package edu.mum.application;

import edu.mum.Pipeline;
import edu.mum.base.job.Job;

public class ETL {
    public static void main(String[] args){
        Pipeline pipeline = Pipeline.getInstance();

        Job job = new Job();

        Pipeline.getInstance().start();
    }

    public static void csvJob(Pipeline pipeline){
    }
}
