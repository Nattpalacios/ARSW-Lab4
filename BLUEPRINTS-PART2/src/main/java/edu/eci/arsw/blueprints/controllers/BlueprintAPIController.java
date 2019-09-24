/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.controllers;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.services.BlueprintsServices;

/**
 *
 * @author hcadavid
 */
@RestController
@RequestMapping(value = "/blueprints")
public class BlueprintAPIController {
	
	@Autowired
	private BlueprintsServices bps;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAllBlueprints(){
	    try {
	    	Set<Blueprint> allBp = bps.getAllBlueprints();
	        return new ResponseEntity<>(allBp,HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, ex);
	        return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
	    }        
	}
    
	@GetMapping("/{author}")
	public ResponseEntity<?> getAllBlueprintsByAuthor(@PathVariable("author") String author){
	    try {
	    	Set<Blueprint> allBpByAuthor = bps.getBlueprintsByAuthor(author);
	        return new ResponseEntity<>(allBpByAuthor,HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, ex);
	        return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
	    }        
	}
	
	@GetMapping("/{author}/{name}")
	public ResponseEntity<?> getABlueprintByAuthor(@PathVariable("author") String author, @PathVariable("name") String name){
	    try {
	    	Blueprint allBluep = bps.getBlueprint(author, name);
	        return new ResponseEntity<>(allBluep,HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, ex);
	        return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
	    }        
	}
	
	@PostMapping("")	
	public ResponseEntity<?> addNewBluePrint(@RequestBody Blueprint o){
	    try {
	        bps.addNewBlueprint(o);
	        return new ResponseEntity<>(HttpStatus.CREATED);
	    } catch (Exception ex) {
	        Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, ex);
	        return new ResponseEntity<>("Error bla bla bla",HttpStatus.FORBIDDEN);            
	    }        

	}
    
}
