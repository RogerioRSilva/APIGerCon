package br.com.gercon.controller;

import br.com.gercon.domain.model.Conta;
import br.com.gercon.domain.repository.ContaRepository;
import br.com.gercon.domain.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaRepository repository;

    @Autowired
    private ContaService service;

    @PostMapping
    public Conta listarContas(@RequestBody Conta conta) {
        service.saveConta(conta);
        repository.save(conta);
        return conta;
    }

    @GetMapping("/listarcontas")
    public Iterable<Conta> listarContas() {
        return repository.findAll();
    }

    @GetMapping("/buscarconta/{id}")
    public Conta buscarConta(@PathVariable("id") Long id) {
        return repository.findById(id).orElse(null);
    }

    @DeleteMapping("/deletarconta/{id}")
    public void deletarConta(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/atualizarconta/{id}")
    public Conta atualizarConta(@PathVariable("id") Long id, @RequestBody Map<String, Object> updates) {
        return service.updateContaField(id, updates);
    }
}
