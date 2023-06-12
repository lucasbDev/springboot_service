package com.RHPback.projeto.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.RHPback.projeto.entities.Gestor;
import com.RHPback.projeto.repository.GestorRepository;
import com.RHPback.projeto.service.GestorService;

@RestController
@RequestMapping(value = "/gestor")
public class GestorController {

	@Autowired
	private GestorService service;
	@Autowired
	private GestorRepository repository;
	
       /////////////////// GET//////////////////
	/////////////////////////////////////////////
	
	@GetMapping
	public ResponseEntity<List<Gestor>> findAll() {

		List<Gestor> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Gestor> findById(@PathVariable Long id) {
		Gestor obj = service.findById(id);//
		return ResponseEntity.ok().body(obj);
	}
           ///////////////////////POST//////////////////////
	/////////////////////////////////////////////////////////////
	
	@PostMapping
	public ResponseEntity<Gestor> insert(@RequestBody Gestor obj) {
		obj = service.insert(obj);
		// return ResponseEntity.ok().body( obj);// retorna 200 q n é o ideal

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdGestor()).toUri();

		return ResponseEntity.created(uri).body(obj);
	}
        //////////////// DELETE//////////////////////////
	////////////////////////////////////////////////////////
	@DeleteMapping(value = "/{id}")

	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}
	
	////////////////////// PUT////////////////////////
	///////////////////////////////////////////////////
	
	@PutMapping("/{id}")
	public ResponseEntity<Gestor> update(@PathVariable Long id, @RequestBody Gestor obj) {
	    Optional<Gestor> optionalGestor = repository.findById(id) ;
	    
	    if (optionalGestor.isPresent()) {
	        Gestor gestor = optionalGestor.get();
	        
	       
	        gestor.setNome(obj.getNome());
	        gestor.setEmail(obj.getEmail());
	        gestor.setSenha(obj.getSenha());
	      
	        
	       repository.save(gestor); 
	        
	        return ResponseEntity.ok(gestor);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}


	}



