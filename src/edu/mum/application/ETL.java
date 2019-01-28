package edu.mum.application;

import edu.mum.Pipeline;
import edu.mum.base.job.Job;
import edu.mum.base.read.CSVReaderAdapter;
import edu.mum.base.read.DataReader;
import edu.mum.base.transform.RenameFieldDecorator;
import edu.mum.base.transform.TransformComponent;
import edu.mum.base.transform.Transformer;
import edu.mum.base.transform.computedfield.ComputedFieldDecorator;
import edu.mum.base.write.DataWriter;
import edu.mum.base.write.adapters.JSONWriteAdapter;

import java.util.ArrayList;

public class ETL {
    public static void main(String[] args){
        Pipeline pipeline = Pipeline.getInstance();
        csvJob(pipeline);

        Pipeline.getInstance().start();
    }

    public static void csvJob(Pipeline pipeline){
        DataReader reader = new DataReader(new CSVReaderAdapter("example.csv", ","));
        DataWriter writer = new DataWriter(new JSONWriteAdapter("example.json"));
        TransformComponent transformer = new RenameFieldDecorator(new Transformer())
                .rename("Year", "decade");

        TransformComponent computedFieldDecorator = new ComputedFieldDecorator(transformer)
                .addComputedField("Computed", new ArrayList<String>() {{add("Year"); add("Flood");} });

        pipeline.addJob(new Job(reader, writer, computedFieldDecorator));
    }
}
