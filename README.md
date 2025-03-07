# 📚 Sistema de Gerenciamento de Faculdade

![Badge Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow)
![Badge Java](https://img.shields.io/badge/Java-17-blue)
![Badge SpringBoot](https://img.shields.io/badge/Spring%20Boot-3.1.0-brightgreen)
![Badge PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue)

## 📖 Sobre o Projeto

Este é um sistema backend para gerenciamento de uma faculdade, permitindo o cadastro, listagem, atualização e exclusão de alunos, professores e disciplinas. O projeto é desenvolvido com **Java + Spring Boot** e utiliza **PostgreSQL** como banco de dados.

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA**
- **PostgreSQL** (com Docker)
- **Flyway** (controle de versões do banco de dados)
- **JUnit e Mockito** (testes unitários)
- **Swagger (Springdoc OpenAPI)** (Ainda não foi implementado)

## 📌 Funcionalidades

✔ Cadastro, listagem, atualização e remoção de:
  - Alunos
  - Professores
  - Disciplinas

✔ Utilização de **DTOs** para segurança e desacoplamento entre camadas
✔ Testes unitários para garantir a integridade do sistema

## 🛠️ Como Executar o Projeto

### 🔧 Pré-requisitos

Antes de começar, certifique-se de ter instalado:
- **Java 21**
- **Docker** (para o banco PostgreSQL)
- **Maven** (para gerenciar dependências)

### 📂 Clonar o repositório
```bash
git clone https://github.com/rods-desenvolvedor/sistema-gerenciamento-faculdade.git
```

### 🐘 Subir o Banco de Dados (PostgreSQL com Docker)
```bash
docker-compose up -d
```

### ▶️ Rodar a aplicação
```bash
mvn spring-boot:run
```

A API estará disponível em: **http://localhost:8080**

### 📜 Documentação da API (Swagger)
Após rodar o projeto, acesse:
- **Swagger UI:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- **OpenAPI JSON:** [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

## 🧪 Testes
Para rodar os testes unitários:
```bash
mvn test
```

## 📬 Contato
🔗 [LinkedIn](https://www.linkedin.com/in/rods-desenvolvedor/)  
📧 rods.desenvolvedor@gmail.com

---

💡 **Fique à vontade para contribuir com melhorias!** 🚀


