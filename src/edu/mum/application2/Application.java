package edu.mum.application2;

import edu.mum.application2.transformations.SortTransformer;
import edu.mum.framework.Pipeline;
import edu.mum.framework.base.job.Job;
import edu.mum.framework.base.read.DataReader;
import edu.mum.framework.base.read.csv.CSVReaderAdapter;
import edu.mum.framework.base.transform.TransformComponent;
import edu.mum.framework.base.transform.Transformer;
import edu.mum.framework.base.write.DataWriter;
import edu.mum.framework.base.write.adapters.JSONWriteAdapter;

public class Application {
    public static void main(String[] args) {
        Pipeline pipeline = Pipeline.getInstance();

        DataReader reader = new DataReader(new CSVReaderAdapter("example.csv", ","));
        DataWriter writer = new DataWriter(new JSONWriteAdapter("example.json"));

        TransformComponent transformer = new SortTransformer(new Transformer())
                .sortDescendingBy("Year");

        pipeline.addJob(new Job(reader, writer, transformer));

        pipeline.start();
    }
}