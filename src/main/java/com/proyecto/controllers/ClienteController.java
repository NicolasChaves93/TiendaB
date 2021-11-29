package com.proyecto.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.models.ClienteDTO;
import com.proyecto.repositories.IClienteDAO;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	private IClienteDAO repository;
	
	@PostMapping("/cliente")
	public ClienteDTO create(@Validated @RequestBody ClienteDTO c) {
		return repository.insert(c);
	}
	
	@GetMapping("/")
	public List<ClienteDTO> readAll(){
		return repository.findAll();
	}
	
	@GetMapping("/cliente/{id}")
	public Optional<ClienteDTO> readId(@PathVariable String id){
		return repository.findById(id);
	}
	
	@PutMapping("/cliente/{id}")
	public ClienteDTO update(@PathVariable String id, @Validated @RequestBody ClienteDTO c) {
		return repository.save(c);
	}
	
	@DeleteMapping("/cliente/{id}")
	public void delete(@PathVariable String id) {
		repository.deleteById(id);
	}
}
