package model;


import java.io.File;
import static jdk.nashorn.internal.codegen.OptimisticTypesPersistence.load;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Soul
 */
public class Ontology {

    private OWLOntologyManager man;
    private OWLOntology o;

    public Ontology(File file) throws OWLOntologyCreationException {
        man = OWLManager.createOWLOntologyManager();
        o = man.loadOntologyFromOntologyDocument(file);
    }
    
    public void toPrint(){
        System.out.println(this.o);
    }
    
    public OWLOntology getOntology(){
        return this.o;
    }
    
    public OWLOntologyManager getManager(){
        return this.man;
    }
}
