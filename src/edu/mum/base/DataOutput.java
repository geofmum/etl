package edu.mum.base;

public interface DataOutput {
    public <T> void write(T data);
    public void initialize();
}
