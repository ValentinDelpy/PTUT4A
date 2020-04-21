/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.emcrisis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import model.Disease;
import model.Ontology;
import model.Patient;
import model.Symptom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.reasoner.ConsoleProgressMonitor;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerConfiguration;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.SimpleConfiguration;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;

public class Services {

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
    
    public static List<Disease> getDiseases() throws OWLOntologyCreationException{
        Ontology ont = new Ontology(new File("EMCrisis.owx"));
        OWLOntology o = ont.getOntology();
        OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
        ConsoleProgressMonitor progressMonitor = new ConsoleProgressMonitor();
        OWLReasonerConfiguration config = new SimpleConfiguration(progressMonitor);
        OWLReasoner reasoner = reasonerFactory.createReasoner(o, config);
        reasoner.precomputeInferences(); 
        List<Disease> l = new ArrayList<>();
        for(OWLClass allclasses : o.getClassesInSignature()){
            if(allclasses.toStringID().indexOf("#Symptom")>0){
                NodeSet<OWLClass> cls;
                cls = reasoner.getSubClasses(allclasses,false);
                for(OWLClass c : cls.getFlattened()){
                    l.add(new Disease(c.getIRI().getShortForm().toString()));
                }
            }
        }
        return l;
    }

}
