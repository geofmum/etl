package edu.mum.base.job;

import edu.mum.base.read.DataReader;
import edu.mum.base.transform.TransformComponent;
import edu.mum.base.write.DataWriter;

public class Job extends AbstractJob {
    public Job(DataReader reader, DataWriter writer, TransformComponent transformer) {
        super(reader, writer, transformer);
    }
}
