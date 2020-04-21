package com.mycompany.emcrisis;

import model.Ontology;
import model.Disease;
import model.Patient;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import model.Symptom;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Soul
 */
public class App {

    
    public static void main(String args[]) throws OWLOntologyCreationException{
        //Ontology ont = new Ontology(new File("EMCrisis.owx"));
	//	ArrayList<OWLClass> list = new ArrayList<>();
	//	for (OWLClass cls : ont.getOntology().getClassesInSignature()) {
	//		list.add(cls);
	//	}
        List<Disease> diseases = new ArrayList<>();
        Patient p = new Patient("oui");
        Symptom toux = new Symptom("Toux");
        Symptom fievre = new Symptom("Fievre");
        Symptom congestion = new Symptom("Congestion nasale");
        Symptom saignement = new Symptom("Saignement");
        
        Disease grippe = new Disease("Grippe");
        Disease rhume = new Disease("Rhume");
        Disease hemorragie = new Disease("Hemorragie");
        
        grippe.addSymptom(toux);
        grippe.addSymptom(fievre);
        grippe.addSymptom(congestion);
        
        rhume.addSymptom(toux);
        rhume.addSymptom(congestion);
        
        hemorragie.addSymptom(fievre);
        hemorragie.addSymptom(saignement);
        
        p.addSymptom(toux);
        p.addSymptom(fievre);
        
        diseases.add(rhume);
        diseases.add(grippe);
        diseases.add(hemorragie);
        
        System.out.println(determineDisease(p,diseases).getHasDisease());

    }
    
    
    public static Disease determineDisease(Patient p, List<Disease> diseases){
        Disease d = null;
        float maxPrct = 0;
        HashMap<Disease, Float> classification = new HashMap<>();
        for(Symptom s : p.getSymptoms()){
            for(Disease di : diseases){
                if(di.getSymptom(s)!=null){
                    if(!classification.containsKey(di)){
                        classification.put(di,(float) 1.0);
                    } else {
                        classification.put(di,classification.get(di)+1);
                    }
                    if(classification.get(di)/di.getSymptoms().size()>maxPrct){
                        maxPrct = classification.get(di)/di.getSymptoms().size();
                        d = di;
                        //System.out.println(maxPrct);
                    }
                }
            }
        }
        return d;
    }
}

