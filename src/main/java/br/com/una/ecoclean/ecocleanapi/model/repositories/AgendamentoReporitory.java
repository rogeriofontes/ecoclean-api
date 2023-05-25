package br.com.una.ecoclean.ecocleanapi.model.repositories;

import br.com.una.ecoclean.ecocleanapi.model.entities.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoReporitory extends JpaRepository<Agendamento, Long> {
}
