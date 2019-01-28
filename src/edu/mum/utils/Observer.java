package edu.mum.utils;

public interface Observer{
    public void subscribe(Observable obj);
    public void subscribe(String event, Observable obj);
    public void update(Object data);
}
