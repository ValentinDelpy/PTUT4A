/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Soul
 */
public class Symptom {
    String name;
    
    public Symptom(String n){
        this.name = n;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String n){
        this.name = n;
    }
    
    @Override 
    public String toString(){
        return "Symptom : "+this.name;
    }
}
