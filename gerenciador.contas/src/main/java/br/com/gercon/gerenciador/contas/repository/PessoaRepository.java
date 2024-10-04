package br.com.gercon.gerenciador.contas.repository;

import br.com.gercon.gerenciador.contas.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
