package edu.mum.base;

import edu.mum.utils.Observable;
import edu.mum.utils.Observer;

public class Loader implements Observer {
    private String channel;
    private DataOutput output;

    public Loader(String channel, DataOutput output){
        this.channel = channel;
    }

    public void load(Object data){
        System.out.println(data);
    }

    @Override
    public void subscribe(Observable obj) {
        obj.subscribe(channel, this);
    }

    @Override
    public void subscribe(String event, Observable obj) {
        obj.subscribe(event, this);
    }

    @Override
    public void update(Object data) {

    }
}
