# 🖥️ API Gerenciador de Contas Residenciais - GerCon

## 📖 Descrição

O intuito do projeto é criar uma API de gerenciamento de contas residenciais,
onde o usuário poderá cadastrar contas de água, luz, telefone, internet, entre outras,
e visualizar um resumo das contas cadastradas.


## Tecnologias Utilizadas
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![YAML](https://img.shields.io/badge/yaml-%23ffffff.svg?style=for-the-badge&logo=yaml&logoColor=151515)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)

![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Insomnia](https://img.shields.io/badge/Insomnia-black?style=for-the-badge&logo=insomnia&logoColor=5849BE)


## 🚀 Funcionalidades

- [x] Cadastro de Conta
- [x] Listar todas as contas
- [x] Buscar conta por ID
- [x] Deletar conta por ID
- [x] Atualizar conta

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


## Open API - Swagger

- Link uso Local: http://localhost:8080/swagger-ui/index.html#/

![Imagem do Swagger](api-gercon/docs/Captura%20de%20tela%202024-10-12%20175456.png)
