package com.example.backend.controller;

import com.example.backend.dto.ArticulosPorAlmcenProjection;
import com.example.backend.sqlserver2.repository.MeaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController
@RequestMapping("/api/mea")
public class MeaController {
    @Autowired
    private MeaRepository meaRepository;

    private static final String SIN_RESULTADO = "Sin resultado";
    private static final String ERROR = "Error :";
    private static final int PAGE_SIZE = 20;

    //selecting existencias for articles
    @GetMapping("/fetch-articulos-por-almacen/{ent}")
    public ResponseEntity<?> fetchArticulosPorAlmacen(
        @PathVariable Integer ent,
        @RequestParam(defaultValue = "0") int page
    ) {
        try {
            List<ArticulosPorAlmcenProjection> Almacenes = meaRepository.findByENT(ent, PageRequest.of(page, PAGE_SIZE));
            if (Almacenes.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(SIN_RESULTADO);
            }

            return ResponseEntity.ok(Almacenes);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ERROR + ex.getMessage());
        }
    }
}