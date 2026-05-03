
Este projeto é um sistema de gerenciamento de consultas desenvolvido com Java e Spring Boot, focado em simplicidade e clareza de código.
  Tecnologias Utilizadas

    Java 17/21

    Spring Boot (Spring Data JPA, Spring Web)

    PostgreSQL (Banco de dados relacional)

    Maven (Gerenciador de dependências)

  Funcionalidades

    Agendamento: Criar novas consultas vinculadas a pacientes e médicos.

    Listagem: Visualizar todas as consultas agendadas.

    Atualização: Alterar informações de consultas existentes.

    Cancelamento: Remover registros do sistema.

  Como Executar

    Clonar o repositório:
    Bash

    git clone https://github.com/seu-usuario/crud-consultas.git

    Configurar o Banco de Dados:
    Crie um banco de dados no seu PostgreSQL local e ajuste as credenciais (username e password) no arquivo src/main/resources/application.properties.

    Executar a aplicação:
    Bash

    mvn spring-boot:run

  Estrutura do Projeto

O projeto foi estruturado de forma simples e entendível:

    controller: Camada de entrada (endpoints da API).

    service: Onde reside a lógica de negócio.

    repository: Interface para operações no banco de dados.

    model: Classes que representam as tabelas do banco.
