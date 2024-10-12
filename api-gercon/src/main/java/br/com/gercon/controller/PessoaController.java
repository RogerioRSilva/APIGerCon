package br.com.gercon.controller;

import br.com.gercon.domain.model.Pessoa;
import br.com.gercon.domain.repository.PessoaRepository;
import br.com.gercon.domain.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private PessoaService service;

    @GetMapping("/listarpessoas")
    public Iterable<Pessoa> listarPessoas() {
        return repository.findAll();
    }

    @GetMapping("/buscarpessoa/{id}")
    public Pessoa buscarPessoa(@PathVariable("id") Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa) {
        repository.save(pessoa);
        return pessoa;
    }

    @PutMapping("/atualizarpessoa/{id}")
    public Pessoa atualizarPessoa(@PathVariable("id") Long id, @RequestBody Map<String, Object> updates) {
        return service.updatePessoaField(id, updates);
    }

    @DeleteMapping("/deletarpessoa/{id}")
    public void deletarPessoa(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }
}
