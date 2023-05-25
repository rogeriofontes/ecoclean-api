package br.com.una.ecoclean.ecocleanapi.api.controller;

import br.com.una.ecoclean.ecocleanapi.model.entities.Agendamento;
import br.com.una.ecoclean.ecocleanapi.model.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<Agendamento> salvar(@RequestBody Agendamento agendamento){
        Agendamento AgendamentoSalvo = agendamentoService.salvar(agendamento);

        if (AgendamentoSalvo == null) {
            return ResponseEntity.noContent().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(AgendamentoSalvo.getId()).toUri();
            return ResponseEntity.created(uri).body(agendamento);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agendamento> alterar(@PathVariable Long id, @RequestBody Agendamento agendamento){
        Agendamento aendamentoSalvo = agendamentoService.altera(id, agendamento);

        if (aendamentoSalvo == null) {
            return ResponseEntity.noContent().build();
        }

        //earlier return
        return ResponseEntity.ok(agendamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> buscaPorId(@PathVariable Long id) {
        Optional<Agendamento> Agendamento = agendamentoService.buscaPorId(id);

        if (!Agendamento.isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(Agendamento.get());
        }
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> buscaPorTodos() {
        List<Agendamento> todos = agendamentoService.todos();

        if (todos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(todos);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removePorId(@PathVariable Long id){
        agendamentoService.removePorId(id);

        return ResponseEntity.noContent().build();
    }
}
