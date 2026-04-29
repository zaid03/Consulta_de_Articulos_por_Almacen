package com.example.backend.sqlserver2.repository;

import com.example.backend.dto.ArticulosPorAlmcenProjection;
import com.example.backend.sqlserver2.model.Mea;
import com.example.backend.sqlserver2.model.MeaId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface MeaRepository extends JpaRepository<Mea, MeaId> {
    //selecting articulos por almacen
    List<ArticulosPorAlmcenProjection> findByENT(Integer ent, Pageable pageable);
}