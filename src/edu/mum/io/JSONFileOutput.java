package edu.mum.io;

import edu.mum.base.DataOutput;

import java.util.Collection;
import java.util.List;

public class JSONFileOutput implements DataOutput {
    @Override
    public void write(Object data) {
        if (data instanceof Collection){
            // iterate through the collection to obtain the items
        } else {
            // extract the object's properties
        }
    }


    @Override
    public void initialize() {

    }
}
