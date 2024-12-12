package com.example.api.esportes.repository;

import com.example.api.esportes.model.Participante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipanteRepository extends JpaRepository<Participante, Integer> {
}
