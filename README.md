# RPG Aventura Solo - Final ⚔️

Projeto desenvolvido para a disciplina de **Linguagens de Programação 2**, consistindo em um jogo de aventura solo que explora a aplicação prática de conceitos avançados de Java e Programação Orientada a Objetos (POO).

## 🚀 Conceitos Aplicados

O projeto implementa e demonstra os seguintes pilares de desenvolvimento:

- **Abstração e Herança**: Utilização de classes abstratas (`Inimigo`, `Item`) para a definição de modelos base.
- **Polimorfismo**: Comportamentos de ataque específicos para `Goblin` e `Esqueleto` via sobrescrita de métodos.
- **Interfaces**: Interface `Usavel` para implementar a lógica de consumo de poções.
- **Encapsulamento**: Proteção de estado do personagem e inimigos com modificadores de acesso e métodos de controle (`receberDano`, `curar`).
- **Collections Framework**: Uso de `ArrayList` para inventário e `HashMap` para gerenciamento de missões.
- **Generics**: Implementação de uma classe `Inventario<T>` genérica para suportar diferentes tipos de itens.
- **Tratamento de Exceções**: Criação de exceção personalizada `ItemNaoEncontradoException` e tratamento de entradas inválidas com `try-catch`.
- **Gerenciamento de Recursos**: Utilização de `try-with-resources` para manipulação do `Scanner`.
- **Modularização**: Organização estruturada em pacotes para separação de responsabilidades.
- **Pattern Matching**: Uso de sintaxe moderna do Java para verificação e casting de tipos.

## 🛠️ Tecnologias Utilizadas

- **Linguagem**: Java
- **IDE**: IntelliJ IDEA / VS Code

## 📁 Estrutura do Projeto

- `personagem`: Lógica principal do jogador.
- `inimigo`: Definições e comportamentos dos adversários.
- `item`: Sistema de itens, armas e poções.
- `missao`: Controle de estados e objetivos do jogo.
- `inventario`: Implementação genérica de armazenamento de itens.
- `jogoaventura`: Gerenciamento do mundo e entidades.

## 🎮 Como Executar

1. Compile o projeto:
   ```bash
   javac -d bin src/**/*.java
   ```
2. Execute a classe principal:
   ```bash
   java -cp bin Main
   ```
