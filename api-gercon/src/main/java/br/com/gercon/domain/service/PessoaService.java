package br.com.gercon.domain.service;

import br.com.gercon.domain.model.Conta;
import br.com.gercon.domain.model.Pessoa;
import br.com.gercon.domain.repository.PessoaRepository;
import br.com.gercon.domain.util.StatusConta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public Pessoa updatePessoaField(Long id, Map<String, Object> updates) {
        Pessoa pessoa = repository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        Map<String, BiConsumer<Pessoa, Object>> fieldMap = new HashMap<>();
        fieldMap.put("nome", (p, v) -> p.setNome((String) v));

        updates.forEach((key, value) -> {
            BiConsumer<Pessoa, Object> consumer = fieldMap.get(key);
            if (consumer != null) {
                consumer.accept(pessoa, value);
            } else {
                throw new IllegalArgumentException("Campo não suportado: " + key);
            }
        });

        return repository.save(pessoa);
    }
}
