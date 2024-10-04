package br.com.gercon.gerenciador.contas.repository;

import br.com.gercon.gerenciador.contas.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
}
