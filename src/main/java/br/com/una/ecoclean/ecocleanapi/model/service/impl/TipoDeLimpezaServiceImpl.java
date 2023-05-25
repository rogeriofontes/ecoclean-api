package br.com.una.ecoclean.ecocleanapi.model.service.impl;

import br.com.una.ecoclean.ecocleanapi.model.entities.TipoLimpeza;
import br.com.una.ecoclean.ecocleanapi.model.repositories.TipoDeLimpezaRepository;
import br.com.una.ecoclean.ecocleanapi.model.service.TipoDeLimpezaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDeLimpezaServiceImpl implements TipoDeLimpezaService {

    @Autowired
    private TipoDeLimpezaRepository tipoDeLimpezaRepository;

    @Override
    public TipoLimpeza salvar(TipoLimpeza tipoLimpeza) {
        return tipoDeLimpezaRepository.save(tipoLimpeza);
    }

    @Override
    public TipoLimpeza altera(Long id, TipoLimpeza tipoLimpeza) {
        tipoLimpeza.setId(id);
        return tipoDeLimpezaRepository.save(tipoLimpeza);
    }

    @Override
    public Optional<TipoLimpeza> buscaPorId(Long id) {
        return tipoDeLimpezaRepository.findById(id);
    }

    @Override
    public List<TipoLimpeza> todos() {
        return tipoDeLimpezaRepository.findAll();
    }

    @Override
    public void removePorId(Long id) {
        tipoDeLimpezaRepository.deleteById(id);
    }
}
