package edu.mum.base;

import edu.mum.utils.Observable;
import edu.mum.utils.Observer;

public class Transformer implements Observer {
    private String channel;
    private Transformer parser;

    public Transformer(){

    }

    public Transformer(String channel){
        this.channel = channel;
    }

    public void registerParser(Transformer parser){
        this.parser = parser;
    }

    public void transform(Object data){
        if (hasParser())
            parser.transform(data);
        else
            Pipeline.getInstance().emit(channel, data);
    }

    public void transform(String channel, Object data){
        if (hasParser())
            parser.transform(channel, data);
        else
            Pipeline.getInstance().emit(channel, data);
    }

    public boolean hasParser(){
        return parser != null;
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
        transform(channel, data);
    }
}
