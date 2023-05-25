package br.com.una.ecoclean.ecocleanapi.model.repositories;

import br.com.una.ecoclean.ecocleanapi.model.entities.TipoLimpeza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDeLimpezaRepository extends JpaRepository<TipoLimpeza, Long> {
}
