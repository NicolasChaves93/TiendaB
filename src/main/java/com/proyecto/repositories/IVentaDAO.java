package com.proyecto.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.models.VentaDTO;

@Repository
public interface IVentaDAO extends MongoRepository<VentaDTO,String>{

}
