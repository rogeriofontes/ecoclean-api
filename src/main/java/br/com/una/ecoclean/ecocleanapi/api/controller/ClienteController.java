package br.com.una.ecoclean.ecocleanapi.api.controller;

import br.com.una.ecoclean.ecocleanapi.model.entities.Cliente;
import br.com.una.ecoclean.ecocleanapi.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService tipoDeLimpezaService;

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente Cliente){
        Cliente ClienteSalvo = tipoDeLimpezaService.salvar(Cliente);

        if (ClienteSalvo == null) {
            return ResponseEntity.noContent().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ClienteSalvo.getId()).toUri();
            return ResponseEntity.created(uri).body(Cliente);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> alterar(@PathVariable Long id, @RequestBody Cliente Cliente){
        Cliente ClienteSalvo = tipoDeLimpezaService.altera(id, Cliente);

        if (ClienteSalvo == null) {
            return ResponseEntity.noContent().build();
        }

        //earlier return
        return ResponseEntity.ok(Cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscaPorId(@PathVariable Long id) {
        Optional<Cliente> Cliente = tipoDeLimpezaService.buscaPorId(id);

        if (!Cliente.isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(Cliente.get());
        }
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> buscaPorTodos() {
        List<Cliente> todos = tipoDeLimpezaService.todos();

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
