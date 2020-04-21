/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.emcrisis;

import com.mycompany.emcrisis.Services;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.DELETE;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import model.Disease;
import model.Patient;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Soul
 */
@Controller
@Path("/api")
public class Webservice {

    Services services;

    public Webservice() {
        this.services = new Services();
    }

    @GET
    @Path("emcrisis")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getDisease(Patient p) throws JAXBException, OWLOntologyCreationException {
        List<Disease> l = services.getDiseases();
        return Response.ok(services.determineDisease(p, l)).build();
    }

    //@PUT
    //@Path("product")
    //@Consumes({MediaType.APPLICATION_JSON})
    //public void editProduct(@FormParam("data")String data, @FormParam("username")String username) throws FileNotFoundException, JAXBException {
    //    //ProductType product = new Gson().fromJson(data, ProductType.class);
    //    services.updateProduct(username, product);
    //}

    //@PUT
    //@Path("manager")
    ////@Consumes({MediaType.APPLICATION_JSON})
    //public void editManager(@FormParam("data")String data, @FormParam("username")String username) throws FileNotFoundException, JAXBException {
    //    PallierType manager = new Gson().fromJson(data, PallierType.class);
     //   services.updateManager(username, manager);

    //}
    
    //@PUT
    //@Path("upgrade")
    //@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    //public void editUpgrade(@FormParam("data")String data, @FormParam("username")String username) throws JAXBException, FileNotFoundException{
     //   PallierType upgrade = new Gson().fromJson(data, PallierType.class);
     //   services.updateUpgrade(username, upgrade);
    //}//
    //@PUT
    //@Path("angelupgrade")
    //@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    //public void editAngelUpgrade(@FormParam("data")String data, @FormParam("username")String username) throws JAXBException, FileNotFoundException{
    //    PallierType upgrade = new Gson().fromJson(data, PallierType.class);
    //    services.updateUpgrade(username, upgrade);
    //}
    
    //@DELETE
    //@Path("world")
    //@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    //public void resetWorld(@FormParam("username")String username) throws FileNotFoundException, JAXBException{
    //    World w = services.readWorldFromXml(username);
     //   double scoreToKeep = w.getScore();
    //    double totalangels = w.getTotalangels();
     //   double activeangels = 150 * Math.sqrt(w.getScore()/Math.pow(10, 15))-totalangels;   
     //   JAXBContext jaxbContext;

     //   InputStream input = getClass().getClassLoader().getResourceAsStream("world.xml");
     //   jaxbContext = JAXBContext.newInstance(World.class);
     //   Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    //    World newWorld = (World) jaxbUnmarshaller.unmarshal(input);
     //   newWorld.setScore(scoreToKeep);
      //  newWorld.setTotalangels(totalangels + activeangels);
      //  newWorld.setActiveangels(activeangels);
      //  services.saveWorldToXml(newWorld, username);
    }

