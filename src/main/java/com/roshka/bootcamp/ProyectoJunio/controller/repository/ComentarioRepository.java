package com.roshka.bootcamp.ProyectoJunio.controller.repository;

import com.roshka.bootcamp.ProyectoJunio.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long>{ }
