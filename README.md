# GestRest - Gestão de Restaurantes – Tech Challenge (Fase 1)

API REST em **Spring Boot** para gestão de restaurantes (**clientes** e **donos de restaurante**), com:
- **Versionamento de API (v1)**
- **Validação de login** (sem obrigatoriedade de Spring Security)
- **Troca de senha** em endpoint exclusivo e **atualização de dados** em endpoint distinto
- **E-mail único**, **busca por nome**, **data da última alteração**
- Respostas de erro padronizadas com **ProblemDetail (RFC 7807)**
- Documentação **OpenAPI/Swagger**
- Execução via **Docker Compose** com **PostgreSQL**

---

## Stack

- **Java** 21 (LTS)  
- **Spring Boot** 3.3.x  
- **Spring Data JPA**, **Validation**  
- **PostgreSQL**  
- **Springdoc OpenAPI** (Swagger UI)  
- **Docker / Docker Compose**

> Configuração central em `src/main/resources/application.yml`.

---

## Requisitos atendidos (resumo)

- CRUD de usuários (cliente e dono de restaurante)
- Buscar usuários por **nome**
- Garantir **unicidade de e-mail**
- **Validação de login** (login + senha) em serviço/endpoint dedicados
- **Troca de senha** em endpoint **exclusivo**
- **Atualização de dados** do usuário em endpoint **distinto** do de senha
- **Data da última alteração** registrada
- **Versionamento de API** (ex.: `/api/v1/...`)
- **Swagger/OpenAPI** com exemplos de sucesso e erro (ProblemDetail)
- **Docker Compose** com banco relacional (PostgreSQL)

---

## Como rodar localmente

### Pré-requisitos
- JDK 21 (ou JDK 17)
- Maven 3.9+

### 1) Rodando apenas a API (sem Docker / sem PostgreSQL)
Em desenvolvimento
A execução local (sem Docker) utiliza temporariamente H2 em memória até a integração definitiva com PostgreSQL.
A API já está acessível e o Swagger pode ser aberto em:

http://localhost:8080/swagger-ui/index.html

   
 