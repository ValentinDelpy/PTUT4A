
import java.io.File;
import org.semanticweb.owlapi.apibinding.OWLManager;
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

    public Ontology(File file) {
        this.man = OWLManager.createOWLOntologyManager();
        try {
            o = man.loadOntologyFromOntologyDocument(new File(file.getAbsolutePath()));
            System.out.println(o);
        } catch (OWLOntologyCreationException e) {
            e.printStackTrace();
        }

    }
}
