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
 * @author Soul
 */
public class Patient {
    String name;
    String surname;
    int age;
    Gender gender;
    boolean ambulance = false;
    
    List<Symptom> symptoms;
    List<Treatment> treatments;
    AgeClassification ac;
    List<HealthRiskFactor> HRFs;
    WeaknessClassification wc;
    
    public Patient(String n, String s, boolean a, Gender g, int age){
        this.name = n;
        this.surname = s;
        this.ambulance = a;
        this.age = age;
        this.gender = g;
        this.doAgeClassification(age);
        this.symptoms = new ArrayList();
        this.treatments = new ArrayList();
        this.HRFs = new ArrayList();
    }
    public void setAgeClassification(AgeClassification ac){
        this.ac = ac;
    }
    public void setWeaknessClassification(WeaknessClassification wc){
        this.wc = wc;
    }
    public void setName(String n){
        this.name = n;
    }
    public void setSurname(String s){
        this.surname = s;
    }
    public void setAge(int a){
        this.age = a;
        this.doAgeClassification(a); 
    }
    public void setDriven(boolean c){
        this.ambulance = c;
    }
    public void setGender(Gender g){
        this.gender = g;
    }   
    public void doAgeClassification(int a){
        if(a < 18){
            this.setAgeClassification(AgeClassification.YOUNG);
        }
        else if(18<=a && a<60){
            this.setAgeClassification(AgeClassification.ADULT);
        }
        else if(60<=a){
            this.setAgeClassification(AgeClassification.ELDERLY);
            this.setWeaknessClassification(WeaknessClassification.WEAK);
        }
    }
    public void addSymptom(Symptom s){
        this.symptoms.add(s);
    }
    public void addTreatment(Treatment t){
        this.treatments.add(t);
    }
    public void addHRF(HealthRiskFactor h){
        this.HRFs.add(h);
    }  
    public String getName(){
        return this.name;
    }
    public String getSurname(){
        return this.surname;
    }
    public int getAge(){
        return this.age;
    }
    public boolean cameByAmbulance(){
        return this.ambulance;
    }
    public Gender getGender(){
        return this.gender;
    }
    public AgeClassification getAgeClassification(){
        return this.ac;
    }
    public WeaknessClassification getWeaknessClassification(){
        return this.wc;
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
    public List<Treatment> getTreatments(){
        return this.treatments;
    }
    public Treatment getTreatment(Treatment t){
        Treatment r = null;
        for(Treatment tr : this.getTreatments()){
            if(tr.getName().equals(t.getName())){
                r = tr;
                return r;
            }
        }
        return r;
    }
    public List<HealthRiskFactor> getHRFs(){
        return this.HRFs;
    }
    public HealthRiskFactor getHRF(HealthRiskFactor h){
        HealthRiskFactor r = null;
        for(HealthRiskFactor he : this.getHRFs()){
            if(he == h){
                r = he;
                return r;
            }
        }
        return r;
    }
    public void setWeakness(){
        if(this.getHRFs().size()!=0){
            this.setWeaknessClassification(WeaknessClassification.WEAK);
        } else{
            this.setWeaknessClassification(WeaknessClassification.NORMAL);
        }
    }
}
