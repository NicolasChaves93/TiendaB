package com.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.models.ConsolidadoDTO;
import com.proyecto.models.VentaDTO;
import com.proyecto.repositories.IConsolidadoDAO;
import com.proyecto.repositories.IVentaDAO;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/consolidado")
public class ConsolidadoController {
	
	@Autowired
	private IVentaDAO ventasRepository;
	@Autowired
	private IConsolidadoDAO consoRepository;
	
	@GetMapping("/")
	public List<ConsolidadoDTO> readAll(){
		List<VentaDTO> ventas = ventasRepository.findAll();
		double sumBogota = 0;
		double sumMedellin = 0;
		double sumCali = 0;
		
		// Obtiene las ventas por ciudad
		for(VentaDTO venta: ventas) {
			if(venta.getNombre_ciudad().equals("Bogota")) {
				sumBogota = sumBogota + venta.getTotal_venta();
			}
			if(venta.getNombre_ciudad().equals("Cali")) {
				sumCali = sumCali + venta.getTotal_venta();
			}
			if(venta.getNombre_ciudad().equals("Medellin")) {
				sumMedellin = sumMedellin + venta.getTotal_venta();
			}
		}
		
		// Guarda las ventas totales por ciudad
		consoRepository.insert(new ConsolidadoDTO("Bogota",sumBogota));
		consoRepository.insert(new ConsolidadoDTO("Cali",sumCali));
		consoRepository.insert(new ConsolidadoDTO("Medellin",sumMedellin));
		
		// Obtiene los registros de la tabla consolidados
		return consoRepository.findAll();
	}

}
