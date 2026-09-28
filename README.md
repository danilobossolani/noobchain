# noobchain

Blockchain simples em Java, construída do zero para entender na prática como funcionam o encadeamento de blocos por hash, a validação da cadeia e a mineração com prova de trabalho.

> Projeto de estudo, não é para produção.

## Status

Em andamento.

- [x] Estrutura do bloco (`Block`) com hash SHA-256
- [x] Primeiro teste: bloco gênese e blocos encadeados
- [x] Blockchain em `ArrayList` exibida em JSON com Gson
- [ ] Validação da cadeia (`isChainValid()`)
- [ ] Mineração com prova de trabalho (`nonce` e dificuldade)

## Créditos

Este projeto foi feito acompanhando o tutorial
[Creating Your First Blockchain with Java. Part 1](https://medium.com/programmers-blockchain/create-simple-blockchain-java-tutorial-from-scratch-6eeed3cb03fa),
de **Kass** (Programmers Blockchain, Medium, 2017). A ideia, a estrutura e a sequência de passos são do autor. O nome `noobchain` também vem do tutorial.

## O que fiz diferente do tutorial

- **IntelliJ IDEA em vez de Eclipse.** O tutorial ensina a configurar tudo no Eclipse; adaptei a criação do projeto e a importação de bibliotecas para o IntelliJ.
- **Gson pelo repositório Maven.** Em vez de baixar o `.jar` e criar uma User Library, adicionei `com.google.code.gson:gson:2.11.0` em *Project Structure > Libraries > From Maven*. A configuração da biblioteca está versionada em `.idea/libraries`, então o projeto já abre configurado.
- **Mensagens e comentários em português.**
- **Java 11+**, por usar `String.repeat()`.

## Como rodar

Pré-requisitos: JDK 11 ou mais novo e IntelliJ IDEA (Community serve).

1. Clone o repositório:
   ```bash
   git clone https://github.com/danilobossolani/noobchain.git
   ```
2. Abra a pasta no IntelliJ (*File > Open*).
3. Se o IntelliJ avisar sobre bibliotecas, deixe ele baixar o Gson.
4. Abra `src/NoobChain.java` e clique na seta verde ao lado do `main`.

## Estrutura

```
src/
├── Block.java       # o bloco: dados, timestamp, hash e hash anterior
├── StringUtil.java  # método auxiliar que aplica SHA-256
└── NoobChain.java   # main: cria e exibe a cadeia
```

## Conceitos praticados

- **Hash (SHA-256):** a "impressão digital" do bloco, calculada a partir do conteúdo dele.
- **Encadeamento:** cada bloco guarda o hash do anterior, então alterar um bloco invalida todos os seguintes.
- **Bloco gênese:** o primeiro bloco, que usa `"0"` como hash anterior.

<!-- Completar ao final: validação da cadeia, prova de trabalho, nonce, dificuldade -->

## Exemplo de saída

<!-- Colar aqui a saída final do programa (mineração + JSON) -->

## Aprendizados

<!-- 4 a 6 pontos objetivos sobre o que ficou claro, o que foi difícil e o que mudaria -->

## Próximos passos

- Parte 2 do tutorial: transações, assinaturas digitais e carteiras.
