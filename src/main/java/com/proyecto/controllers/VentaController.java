package com.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.models.VentaDTO;
import com.proyecto.repositories.IVentaDAO;


@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/ventas")
public class VentaController {
	
	@Autowired
	private IVentaDAO repository;
	
	@PostMapping("/venta")
	public VentaDTO create(@Validated @RequestBody VentaDTO v) {
		return repository.insert(v);
	}
	
	@GetMapping("/")
	public List<VentaDTO> readAll(){
		return repository.findAll();
	}
}
