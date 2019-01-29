package edu.mum.application;

import edu.mum.Pipeline;
import edu.mum.base.job.Job;
import edu.mum.base.read.csv.CSVReaderAdapter;
import edu.mum.base.read.DataReader;
import edu.mum.base.transform.RenameFieldDecorator;
import edu.mum.base.transform.TransformComponent;
import edu.mum.base.transform.Transformer;
import edu.mum.base.transform.computedfield.ComputedFieldDecorator;
import edu.mum.base.utils.date.DateFormat;
import edu.mum.base.utils.date.DateFormatFactory;
import edu.mum.base.utils.date.DateParser;
import edu.mum.base.write.DataWriter;
import edu.mum.base.write.adapters.CSVWriterAdapter;
import edu.mum.base.write.adapters.JSONWriteAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ETL {
    public static void main(String[] args){
        Pipeline pipeline = Pipeline.getInstance();
        csvJob(pipeline);

        Pipeline.getInstance().start();
    }

    public static void csvJob(Pipeline pipeline){
        DataReader reader = new DataReader(new CSVReaderAdapter("example.csv", ","));
        DataWriter writer = new DataWriter(new JSONWriteAdapter("example.json"));
        DataWriter csvWriter=new DataWriter(new CSVWriterAdapter("output.csv", ","));
        TransformComponent transformer = new RenameFieldDecorator(new Transformer())
                .rename("Year", "decade");

        TransformComponent computedFieldDecorator = new ComputedFieldDecorator(transformer)
                .addComputedField("Computed", new ArrayList<String>() {{add("Year"); add("Flood");} });

        //pipeline.addJob(new Job(reader, writer, computedFieldDecorator));

        pipeline.addJob(new Job(reader, csvWriter, computedFieldDecorator));
    }
}
