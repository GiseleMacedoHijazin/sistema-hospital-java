# Sistema de Gestão Hospitalar em Java

## Sobre o Projeto

Este projeto foi desenvolvido em Java com o objetivo de simular um sistema simples de gestão hospitalar utilizando:

- Classes
- Métodos
- Encapsulamento
- ArrayList
- Menu interativo
- Estruturas de repetição e decisão

O sistema permite realizar o cadastro de pacientes, agendamento de consultas e gerenciamento básico das informações hospitalares.

---

# Funcionalidades Implementadas

## Cadastro de pacientes
Permite cadastrar pacientes contendo:
- Nome
- CPF
- Idade
- Telefone

---

## Agendamento de consultas
Permite agendar consultas associadas a um paciente já cadastrado.

Informações da consulta:
- Data
- Horário
- Especialidade
- Médico

---

## Listagem de consultas
O sistema permite listar todas as consultas de um paciente utilizando o CPF.

---

## Remoção de pacientes
Permite remover pacientes cadastrados no sistema.

Ao remover um paciente:
- suas consultas também são removidas automaticamente.

---

## Cancelamento de consultas
Permite cancelar consultas utilizando:
- CPF
- Data
- Horário

---

## Atualização de telefone
Permite atualizar o telefone de um paciente já cadastrado.

---

## Listagem de pacientes
Permite visualizar todos os pacientes cadastrados no sistema.

---

# Validações Implementadas

## Validação de CPF
O CPF deve:
- conter exatamente 11 números;
- não aceitar letras.

---

## Validação de nome
O nome do paciente:
- não pode conter números.

---

## Validação de telefone
O telefone:
- não pode conter letras.

---

## Validação de especialidade e médico
Os campos:
- especialidade;
- médico;

não podem conter números.

---

# Cadastros Automáticos

O sistema inicia com pacientes e consultas já cadastrados automaticamente para facilitar os testes.

---

# Menu do Sistema

```text
1 - Cadastrar paciente
2 - Agendar consulta
3 - Listar consultas
4 - Remover paciente
5 - Cancelar consulta
6 - Atualizar telefone
7 - Listar pacientes
8 - Sair
```

---

# Tecnologias Utilizadas

- Java
- Programação Orientada a Objetos (POO)
- ArrayList
- Scanner
---

# Como Executar o Projeto

## 1. Clone o repositório

```bash
git clone LINK_DO_REPOSITORIO
```

---

## 2. Abra no VS Code

Abra a pasta do projeto no Visual Studio Code.

---

## 3. Execute o arquivo Main.java

Clique em:

```text
Run Java
```

ou no botão:

```text
▶ Run
```

---

# To Do — Futuras Funcionalidades

## 1- Cadastro de endereço do paciente
Adicionar endereço completo no cadastro.

---

## 2- Histórico médico completo
Permitir visualizar todas as consultas anteriores do paciente.

---

## 3- Sistema de login
Adicionar autenticação para funcionários.

---

## 4- Relatório de consultas
Gerar relatórios com quantidade de consultas realizadas.

---

## 5- Busca por nome
Permitir buscar pacientes pelo nome.

---

## 6- Alteração de dados do paciente
Permitir editar nome e idade.

---

# Desenvolvido por

Projeto acadêmico desenvolvido para a disciplina de PARADIGMA DE LINGUAGENS DE PROGRAMAÇÃO por Gisele Hijazin.