package br.com.gercon.gerenciador.contas;

import br.com.gercon.gerenciador.contas.model.Endereco;
import br.com.gercon.gerenciador.contas.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Sistema iniciado com sucesso!");
	}

}
