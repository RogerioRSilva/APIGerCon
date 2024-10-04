package br.com.gercon.gerenciador.contas.service;

import br.com.gercon.gerenciador.contas.model.Conta;
import br.com.gercon.gerenciador.contas.model.Pessoa;
import br.com.gercon.gerenciador.contas.repository.ContaRepository;
import br.com.gercon.gerenciador.contas.repository.PessoaRepository;
import br.com.gercon.gerenciador.contas.util.StatusConta;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.BiConsumer;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional
    public void saveConta(Conta conta){
        Pessoa pessoa = conta.getPessoa();
        if(pessoa != null && pessoa.getId_pessoa() == null){
            pessoaRepository.save(pessoa);
        }
        contaRepository.save(conta);
    }

    @Transactional
    public Conta updateContaField(Long id, Map<String, Object> updates) {
        Conta conta = contaRepository.findById(id).orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        Map<String, BiConsumer<Conta, Object>> fieldMap = new HashMap<>();
        fieldMap.put("statusConta", (c, v) -> c.setStatusConta(StatusConta.valueOf((String) v)));
        fieldMap.put("dataPagamento", (c, v) -> c.setDataPagamento((String) v));

        // Adicione outros campos conforme necessário

        updates.forEach((key, value) -> {
            BiConsumer<Conta, Object> consumer = fieldMap.get(key);
            if (consumer != null) {
                consumer.accept(conta, value);
            } else {
                throw new IllegalArgumentException("Campo não suportado: " + key);
            }
        });

        return contaRepository.save(conta);
    }

}
