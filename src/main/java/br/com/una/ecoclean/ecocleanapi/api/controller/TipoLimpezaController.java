package br.com.una.ecoclean.ecocleanapi.api.controller;

import br.com.una.ecoclean.ecocleanapi.model.entities.TipoLimpeza;
import br.com.una.ecoclean.ecocleanapi.model.service.TipoDeLimpezaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipo-limpezas")
public class TipoLimpezaController {

    @Autowired
    private TipoDeLimpezaService tipoDeLimpezaService;

    @PostMapping
    public ResponseEntity<TipoLimpeza> salvar(@RequestBody TipoLimpeza tipoLimpeza){
        TipoLimpeza tipoLimpezaSalvo = tipoDeLimpezaService.salvar(tipoLimpeza);

        if (tipoLimpezaSalvo == null) {
            return ResponseEntity.noContent().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tipoLimpezaSalvo.getId()).toUri();
            return ResponseEntity.created(uri).body(tipoLimpeza);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoLimpeza> alterar(@PathVariable Long id, @RequestBody TipoLimpeza tipoLimpeza){
        TipoLimpeza tipoLimpezaSalvo = tipoDeLimpezaService.altera(id, tipoLimpeza);

        if (tipoLimpezaSalvo == null) {
            return ResponseEntity.noContent().build();
        }

        //earlier return
        return ResponseEntity.ok(tipoLimpeza);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoLimpeza> buscaPorId(@PathVariable Long id) {
        Optional<TipoLimpeza> tipoLimpeza = tipoDeLimpezaService.buscaPorId(id);

        if (!tipoLimpeza.isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(tipoLimpeza.get());
        }
    }

    @GetMapping
    public ResponseEntity<List<TipoLimpeza>> buscaPorTodos() {
        List<TipoLimpeza> todos = tipoDeLimpezaService.todos();

        if (todos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(todos);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removePorId(@PathVariable Long id){
        tipoDeLimpezaService.removePorId(id);

        return ResponseEntity.noContent().build();
    }
}


//
