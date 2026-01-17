# GestRest – Gestão de Restaurantes  
Tech Challenge – Fase 01 (FIAP / Pós Tech)

O GestRest é uma API REST desenvolvida em Spring Boot para gestão de usuários de um sistema compartilhado entre restaurantes. O sistema permite o cadastro e gerenciamento de clientes e donos de restaurante, conforme os requisitos do Tech Challenge da Fase 01.

A aplicação segue boas práticas de arquitetura MVC, princípios SOLID, versionamento de API e está totalmente dockerizada, utilizando Docker Compose e PostgreSQL como banco de dados relacional.

---

## Objetivo

Desenvolver um backend que permita:

- Gerenciamento completo de usuários
- Validação de login
- Troca de senha em endpoint exclusivo
- Atualização de dados do usuário em endpoint distinto
- Persistência em banco de dados relacional
- Execução padronizada via Docker

---

## Arquitetura

A aplicação segue o padrão MVC, organizada nas seguintes camadas:

- Controller: exposição dos endpoints REST
- Service: regras de negócio
- Repository: persistência de dados com Spring Data JPA
- DTOs: contratos da API
- Mappers: conversão entre entidades e DTOs
- Exceptions: tratamento centralizado de erros utilizando ProblemDetail (RFC 7807)

Além do cadastro de usuários, o sistema possui um **CRUD específico para Tipos de Usuário**, permitindo o cadastro, consulta e exclusão de tipos como Cliente e Dono de Restaurante.

---

## Tipos de Usuário

O sistema contempla obrigatoriamente:

- Dono de restaurante
- Cliente

## Usuário

Campos obrigatórios do usuário:

- Nome  
- E-mail (único)  
- Login  
- Senha  
- Endereço  
- Data da última alteração  

---

## Funcionalidades Implementadas

- Cadastro, atualização e exclusão de usuários
- Busca de usuários por nome
- Garantia de unicidade do e-mail
- Validação de login e senha
- Troca de senha em endpoint exclusivo
- Atualização de dados cadastrais em endpoint distinto do de senha
- Registro da data da última alteração
- Versionamento da API (`/api/v1`)
- Tratamento de erros padronizado com ProblemDetail (RFC 7807)

---

## Stack

- Java 21  
- Spring Boot 3.3.x  
- Spring Data JPA  
- Spring Validation  
- PostgreSQL  
- Springdoc OpenAPI (Swagger)  
- Docker e Docker Compose  

---

## Documentação da API

A API está documentada com OpenAPI/Swagger, contendo exemplos de requisições, respostas de sucesso e respostas de erro.

Swagger UI disponível em:

http://localhost:8080/swagger-ui/index.html

---


## Testes com Postman

O projeto inclui uma coleção de testes do Postman para validar os fluxos de negócio e garantir a integridade das regras estabelecidas no sistema GestRest. Os testes automatizados verificam desde a persistência correta dos dados até o tratamento de exceções.

Cenários Implementados
-  Cadastro de usuário válido: Criação de novo usuário com sucesso.
-  Tentativa de cadastro com e-mail duplicado: Bloqueio de criação e retorno de erro para e-mails já existentes na base.
-  Tentativa de cadastro com campos obrigatórios faltando: Validação de integridade dos dados de entrada.
-  Alteração de senha com sucesso: Atualização de credenciais através de endpoint exclusivo de segurança.
-  Alteração de senha com erro: Validação de falha ao tentar atualizar senha com parâmetros inválidos.
-  Atualização de dados do usuário com sucesso: Modificação de informações cadastrais via endpoint distinto.
-  Atualização de dados com erro: Tratamento de falhas na edição de perfil.
-  Busca de usuários pelo nome: Localização de registros utilizando pelo nome.
-  Validação de login: Autenticação para acesso ao sistema.

    
Arquivo da coleção:

https://drive.google.com/file/d/1RJXkXlAgOLRTDR5Q_nZR3Q0lwSqHmLpL/view?usp=sharing

---

## Execução com Docker

Pré-requisitos:

- Docker  
- Docker Compose  

### Subindo a aplicação

Na raiz do projeto, execute:

```bash
docker compose up --build
```

Após a inicialização:

API disponível em: http://localhost:8080

Swagger UI: http://localhost:8080/swagger-ui/index.html

O banco de dados PostgreSQL é iniciado automaticamente em um container Docker separado, conforme configuração do docker-compose.yml.

### Banco de Dados

- PostgreSQL

- Banco relacional executado via Docker

- Persistência de dados garantida através de volumes Docker

### Observações Finais

A aplicação segue os princípios SOLID e boas práticas do Spring Boot

Código organizado, modular e preparado para evolução

Estrutura adequada para inclusão futura de autenticação com Spring Security e JWT

### Autor

Projeto desenvolvido como parte do Tech Challenge – Fase 01
Curso de Pós-Graduação – FIAP