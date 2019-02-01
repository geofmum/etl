package edu.mum.framework.base.job;

import edu.mum.framework.base.read.DataReader;
import edu.mum.framework.base.transform.TransformComponent;
import edu.mum.framework.base.write.DataWriter;

public class Job extends AbstractJob {
    public Job(DataReader reader, DataWriter writer, TransformComponent transformer) {
        super(reader, writer, transformer);
    }
}
