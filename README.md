# 🖥️ API Gerenciador de Contas Residenciais - GerCon

## 📖 Descrição

O intuito do projeto é criar uma API de gerenciamento de contas residenciais,
onde o usuário poderá cadastrar contas de água, luz, telefone, internet, entre outras,
e visualizar um resumo das contas cadastradas.

| Tecnologias | Versão |
| ----------- | ------ |
| JAVA        | 17     |
| Spring Boot | 3.3.4  |
| Maven       | 3.8.4  |
| MySQL       | 8.0.27 |
| JUnit       | 5.8.2  |
| Swagger     | 3.0.0  |

## 🚀 Funcionalidades

- [x] Cadastro de Conta
- [x] Listar todas as contas
- [x] Buscar conta por ID
- [x] Deletar conta por ID
- [x] Atualizar conta
- [ ] Relatorio de Contas Pagas
- [ ] Relatorio de Contas Pendentes
- [ ] Relatorio de Contas Vencidas
- [ ] Relatorio de Contas a Pagar
- [ ] Alerta de Contas Vencidas
- [ ] Alerta de Contas a Vencer

## Testes dos Endpoints

## Diagrama de Classes

```mermaid
classDiagram
    class Conta {
        +String tipoConta
        +String descricaco
        +float valorConta
        +String dataVencimento
        +String dataPagamento
        +String statusConta
    }

    class Pessoa {
        +String nome
        +String telefone
        +String email
    }

    class Endereco {
        +String logradouro
        +String numero
        +String complemento
        +String bairro
        +String cidade
        +String estado
        +String cep
    }

    Pessoa "1" *-- "1" Endereco : tem
    Pessoa "1" *-- "N" Conta : possui

```

### ✅ Cadastro de Conta (POST)

**Endpoint:** /conta

```json
{
  "conta": {
    "tipoConta": "Boleto",
    "descricaco": "Telefone Celular",
    "valorConta": 64.9,
    "dataVencimento": "20241015",
    "dataPagamento": "",
    "statusConta": "PENDENTE"
  },
  "pessoa": {
    "nome": "Michele Cintra",
    "telefone": "16991810004",
    "email": "rogerio@gmail.com",
    "endereco": {
      "logradouro": "Rua José Carrara",
      "numero": "2050",
      "complemento": "Ap 51",
      "bairro": "Estação",
      "cidade": "São Joaquim da Barra",
      "estado": "SP",
      "cep": "14600-000"
    }
  }
}
```

**Teste Realizado no Insominia**

![Teste Realizado no Insomnia](docs/img/ep_cadastroConta.png)

### ✅ Listar todas as contas (GET)

**Endpoint:** /conta/listarcontas

**Teste Realizado no Insominia**

![Teste Realizado no Insomnia](docs/img/ep_listarContas.png)

### ✅ Buscar conta por ID (GET)

**Endpoint:** /conta/buscarconta/{id}

**Teste Realizado no Insominia**

![Teste Realizado no Insomnia](docs/img/ep_buscarConta.png)

### ✅ Deletar conta por ID (DELETE)

**Endpoint:** /conta/deletarconta/{id}

**Teste Realizado no Insominia**

![Teste Realizado no Insomnia](docs/img/ep_deletarConta.png)

### ❌ Atualizar conta (PUT) - Em Desenvolvimento

## 🎲 Modelagem do Banco de Dados

**Diagrama Entidade Relacionamento**

![Diagrama Entidade Relacionamento](docs/ModelagemConceitual.png)

**Modelo Lógico**

![Modelo Lógico](docs/ModelagemLogica.png)

**Script de Criação do Banco de Dados**

```sql

CREATE TABLE CONTA (
    id_conta int PRIMARY KEY,
    tipoConta varchar(50),
    descricao varchar(50),
    valorConta double(7,2),
    statusConta varchar(20),
    dataVencimento date,
    qtdParcela int,
    valorParcela double(7,2),
    FK_id_pessoa int,
    dataPagamento date
);

CREATE TABLE Pessoa (
    email varchar(50),
    id_pessoa int PRIMARY KEY,
    logradouro varchar(50),
    numero int,
    bairro varchar(50),
    cidade varchar(50),
    estado varchar(50),
    cep varchar(10),
    telefone varchar(20),
    nome varchar(50)
);

ALTER TABLE CONTA ADD CONSTRAINT FK_CONTA_2
    FOREIGN KEY (FK_id_pessoa)
    REFERENCES Pessoa (id_pessoa)
    ON DELETE CASCADE;

```
