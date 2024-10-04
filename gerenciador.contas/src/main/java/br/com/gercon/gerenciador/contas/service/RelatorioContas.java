package br.com.gercon.gerenciador.contas.service;

import br.com.gercon.gerenciador.contas.model.Conta;
import br.com.gercon.gerenciador.contas.repository.ContaRepository;
import br.com.gercon.gerenciador.contas.util.StatusConta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class RelatorioContas {

    // TODO: Implementar método que gere um relatório de contas
    // Esse relatorio deve conter as seguintes informações:
    // - Quantidade de contas pagas
    // - Quantidade de contas pendentes
    // - Quantidade de contas atrasadas
    // - Valor total das contas pagas
    // - Valor total das contas pendentes
    // - Valor total das contas atrasadas
    // - Valor total de todas as contas
    // - Média de valor das contas pagas
    // - Média de valor das contas pendentes
    // - Média de valor das contas atrasadas
    // - Média de valor de todas as contas
    // - Maior valor de conta paga
    // - Maior valor de conta pendente
    // - Maior valor de conta atrasada

    // Dica: Utilize o método findAll() do ContaRepository para obter todas as contas

    @Autowired
    private ContaRepository contaRepository;


    public void gerarRelatorio() {
        List<Conta> contas = contaRepository.findAll();

        long qtdContasPagas = contas.stream().filter(c -> c.getStatusConta().equals(StatusConta.PAGA)).count();
        long qtdContasPendentes = contas.stream().filter(c -> c.getStatusConta().equals(StatusConta.PENDENTE)).count();
        long qtdContasAtrasadas = contas.stream().filter(c -> c.getStatusConta().equals(StatusConta.ATRASADA)).count();

        Double valorTotalContasPagas = contas.stream()
                .filter(c -> c.getStatusConta().equals(StatusConta.PAGA))
                .map(Conta::getValorConta)
                .reduce(Double.ZERO, Double::add);

        Double valorTotalContasPendentes = contas.stream()
                .filter(c -> c.getStatusConta().equals(StatusConta.PENDENTE))
                .map(Conta::getValorConta)
                .reduce(Double.ZERO, Double::add);

        Double valorTotalContasAtrasadas = contas.stream()
                .filter(c -> c.getStatusConta().equals(StatusConta.ATRASADA))
                .map(Conta::getValorConta)
                .reduce(Double.ZERO, Double::add);

        Double valorTotalContas = contas.stream()
                .map(Conta::getValorConta)
                .reduce(Double.ZERO, Double::add);

        Double mediaValorContasPagas = valorTotalContasPagas(Double.valueOf(qtdContasPagas), Double.ROUND_HALF_UP);
        Double mediaValorContasPendentes = valorTotalContasPendentes.divide(Double.valueOf(qtdContasPendentes), Double.ROUND_HALF_UP);
        Double mediaValorContasAtrasadas = valorTotalContasAtrasadas.divide(Double.valueOf(qtdContasAtrasadas), Double.ROUND_HALF_UP);
        Double mediaValorContas = valorTotalContas.divide(Double.valueOf(contas.size()), Double.ROUND_HALF_UP);

        Double maiorValorContaPaga = contas.stream()
                .filter(c -> c.getStatusConta().equals(StatusConta.PAGA))
                .map(Conta::getValorConta)
                .max(Double::compareTo)
                .orElse(Double.ZERO);

        Double maiorValorContaPendente = contas.stream()
                .filter(c -> c.getStatusConta().equals(StatusConta.PENDENTE))
                .map(Conta::getValorConta)
                .max(Double::compareTo)
                .orElse(Double.ZERO);

        Double maiorValorContaAtrasada = contas.stream()
                .filter(c -> c.getStatusConta().equals(StatusConta.ATRASADA))
                .map(Conta::getValorConta)
                .max(Double::compareTo)
                .orElse(Double.ZERO);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("relatorio_contas.txt"))) {
            writer.write("Quantidade de contas pagas: " + qtdContasPagas);
            writer.newLine();
            writer.write("Quantidade de contas pendentes: " + qtdContasPendentes);
            writer.newLine();
            writer.write("Quantidade de contas atrasadas: " + qtdContasAtrasadas);
            writer.newLine();
            writer.write("Valor total das contas pagas: " + valorTotalContasPagas);
            writer.newLine();
            writer.write("Valor total das contas pendentes: " + valorTotalContasPendentes);
            writer.newLine();
            writer.write("Valor total das contas atrasadas: " + valorTotalContasAtrasadas);
            writer.newLine();
            writer.write("Valor total de todas as contas: " + valorTotalContas);
            writer.newLine();
            writer.write("Média de valor das contas pagas: " + mediaValorContasPagas);
            writer.newLine();
            writer.write("Média de valor das contas pendentes: " + mediaValorContasPendentes);
            writer.newLine();
            writer.write("Média de valor das contas atrasadas: " + mediaValorContasAtrasadas);
            writer.newLine();
            writer.write("Média de valor de todas as contas: " + mediaValorContas);
            writer.newLine();
            writer.write("Maior valor de conta paga: " + maiorValorContaPaga);
            writer.newLine();
            writer.write("Maior valor de conta pendente: " + maiorValorContaPendente);
            writer.newLine();
            writer.write("Maior valor de conta atrasada: " + maiorValorContaAtrasada);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
