package edu.mum.base;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PropertyMapper {
    private static Set<String> attributes = new HashSet<>();

    public void registerAttributes (List<String> attributes){
        attributes.addAll(attributes);
    }

    public void registerAttribute(String attribute){
        attributes.add(attribute);
    }

}
