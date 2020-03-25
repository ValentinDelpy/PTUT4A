import model.Ontology;
import java.io.File;
import java.util.ArrayList;
import java.util.Set;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
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
    static OWLClass disease;
    
    public static void main(String args[]) throws OWLOntologyCreationException{
        Ontology ont = new Ontology(new File("EMCrisis.owx"));
		ArrayList<OWLClass> list = new ArrayList<>();
		for (OWLClass cls : ont.getOntology().getClassesInSignature()) {
			list.add(cls);
		}
		for (OWLClass cls : list){
			//System.out.println(cls.getIRI().getFragment());
			//System.out.println(cls.getIRI().getRemainder().get());
//		}
            OWLReasonerFactory orf = new StructuralReasonerFactory();
        // Create the reasoner for the ontology
            OWLReasoner reasoner = orf.createReasoner(ont.getOntology());
        // Look for inferences in the ontology
            reasoner.precomputeInferences();
            ArrayList<OWLClass> test = new ArrayList<>();
                    for (final OWLSubClassOfAxiom subClasse : ont.getOntology().getAxioms(AxiomType.SUBCLASS_OF)) {
                        if (subClasse.getSuperClass() instanceof OWLClass
                                && subClasse.getSubClass() instanceof OWLClass) {
                            System.out.println(subClasse.getSubClass().getClass().getTypeName()
                                    + " extends " + subClasse.getSuperClass().getClass().getTypeName());
                        }
}
    }
}
}
