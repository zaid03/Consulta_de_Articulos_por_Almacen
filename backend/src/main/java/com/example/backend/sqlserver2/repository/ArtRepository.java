package com.example.backend.sqlserver2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.backend.sqlserver2.model.Art;
import com.example.backend.sqlserver2.model.ArtId;

@Repository
public interface ArtRepository extends JpaRepository<Art, ArtId>, JpaSpecificationExecutor<Art> {
    
}