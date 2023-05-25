package br.com.una.ecoclean.ecocleanapi.model.service.impl;

import br.com.una.ecoclean.ecocleanapi.model.entities.Agendamento;
import br.com.una.ecoclean.ecocleanapi.model.repositories.AgendamentoReporitory;
import br.com.una.ecoclean.ecocleanapi.model.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoServiceImpl implements AgendamentoService {

    @Autowired
    private AgendamentoReporitory agendamentoReporitory;

    @Override
    public Agendamento salvar(Agendamento agendamento) {
        return agendamentoReporitory.save(agendamento);
    }

    @Override
    public Agendamento altera(Long id, Agendamento agendamento) {
        agendamento.setId(id);
        return agendamentoReporitory.save(agendamento);
    }

    @Override
    public Optional<Agendamento> buscaPorId(Long id) {
        return agendamentoReporitory.findById(id);
    }

    @Override
    public List<Agendamento> todos() {
        return agendamentoReporitory.findAll();
    }

    @Override
    public void removePorId(Long id) {
        agendamentoReporitory.deleteById(id);
    }
}
