package com.proyecto.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db_consolidado")
public class ConsolidadoDTO {
	
	public ConsolidadoDTO(String ciudad, double total_ventas){
		this.ciudad = ciudad;
		this.total_ventas = total_ventas;
		this.fecha = new Date();
	}
	
	@Id
	private String _id;
	private String ciudad;
	private double total_ventas;
	private Date fecha;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public double getTotal_ventas() {
		return total_ventas;
	}
	public void setTotal_ventas(double total_ventas) {
		this.total_ventas = total_ventas;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
