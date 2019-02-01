package edu.mum.application;

import edu.mum.framework.Pipeline;
import edu.mum.framework.base.job.Job;
import edu.mum.framework.base.read.csv.CSVReaderAdapter;
import edu.mum.framework.base.read.DataReader;
import edu.mum.framework.base.transform.RenameFieldDecorator;
import edu.mum.framework.base.transform.TransformComponent;
import edu.mum.framework.base.transform.Transformer;
import edu.mum.framework.base.transform.computedfield.ComputedFieldDecorator;
import edu.mum.framework.base.write.DataWriter;
import edu.mum.framework.base.write.adapters.JSONWriteAdapter;

import java.util.ArrayList;

public class ETL {
    public static void main(String[] args){
        Pipeline pipeline = Pipeline.getInstance();
        createCSVJob(pipeline);

        Pipeline.getInstance().start();
    }

    public static void createCSVJob(Pipeline pipeline){
        DataReader reader = new DataReader(new CSVReaderAdapter("example.csv", ","));
        DataWriter writer = new DataWriter(new JSONWriteAdapter("example.json"));
        TransformComponent transformer = new RenameFieldDecorator(new Transformer())
                .rename("Flood", "Flood-Magnitude");

        TransformComponent computedFieldDecorator = new ComputedFieldDecorator(transformer)
                .addComputedField("Computed", new ArrayList<String>() {{add("Year"); add("Flood");} });

        pipeline.addJob(new Job(reader, writer, computedFieldDecorator));
    }
}
