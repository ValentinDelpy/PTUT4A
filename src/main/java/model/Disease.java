/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pauline
 */
public class Disease {

    public Disease(String hasDisease, ArrayList<Intervention> interventions) {
        this.hasDisease = hasDisease;
        this.interventions = interventions;
        symptoms = new ArrayList<>();
    }
    
    public Disease(String hasDisease){
        this.hasDisease = hasDisease;
        symptoms = new ArrayList<>();
    }
    
    String hasDisease;
    List<Symptom> symptoms;
    /**
     * The list of activities for the disease
     */
    ArrayList<Intervention> interventions;

    public String getHasDisease() {
        return hasDisease;
    }

    public void setHasDisease(String hasDisease) {
        this.hasDisease = hasDisease;
    }

    public ArrayList<Intervention> getInterventions() {
        return interventions;
    }

    public void setInterventions(ArrayList<Intervention> interventions) {
        this.interventions = interventions;
    }
    
    public void addSymptom(Symptom s){
        this.symptoms.add(s);
    }
    
    public List<Symptom> getSymptoms(){
        return this.symptoms;
    }
    
    public Symptom getSymptom(Symptom s){
        Symptom r = null;
        for(Symptom sy : this.getSymptoms()){
            if(sy.getName().equals(s.getName())){
                r = sy;
                return r;
            }
        }
        return r;
    }
    
}
