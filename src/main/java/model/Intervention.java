package model;

import java.util.ArrayList;

public class Intervention extends Treatment{

    private String name;

    public Intervention(String name) {
        super(name);
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Intervention" + this.name;
    }
    
    
    
    
}
