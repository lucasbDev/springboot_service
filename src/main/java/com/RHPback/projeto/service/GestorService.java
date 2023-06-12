package com.RHPback.projeto.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.RHPback.projeto.entities.Gestor;
import com.RHPback.projeto.repository.GestorRepository;

@Service
public class GestorService {

	@Autowired
	private GestorRepository repository;

	public List<Gestor> findAll() {
		return repository.findAll();
	}

	public Gestor findById(Long id) {
		Optional<Gestor> obj = repository.findById(id);
		return obj.get();
		
	}

	public Gestor insert(Gestor obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
		
	}
	

	public Gestor update(Long id, Gestor obj) {
		
		Gestor entity=repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
		
		}
	

	
	private void updateData(Gestor entity, Gestor obj) {
		entity.setNome(obj.getNome());

		
	
	}

	
}

