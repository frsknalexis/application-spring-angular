package com.dev.ws.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.ws.application.model.Servicio;

@Repository("servicioRepository")
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

}