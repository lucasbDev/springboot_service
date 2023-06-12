package com.RHPback.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.RHPback.projeto.entities.Gestor;

@Repository
public interface GestorRepository extends JpaRepository<Gestor,Long> {
}

