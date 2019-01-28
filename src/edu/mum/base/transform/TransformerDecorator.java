package edu.mum.base.transform;

public class TransformerDecorator implements TransformComponent{
    protected TransformComponent transformer;

    public TransformerDecorator(TransformComponent transformer){
        this.transformer = transformer;
    }

    @Override
    public void transform() {
        transformer.transform();
    }
}
