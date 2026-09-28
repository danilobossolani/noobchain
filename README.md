# noobchain

Blockchain simples em Java, construída do zero para entender na prática como funcionam o encadeamento de blocos por hash, a validação da cadeia e a mineração com Proof of Work (prova de trabalho).

> Projeto de estudo, não é para produção.

## Status

Parte 1 concluída.

- [x] Estrutura do bloco (`Block`) com hash SHA-256
- [x] Primeiro teste: genesis block (bloco gênese) e blocos encadeados
- [x] Blockchain em `ArrayList` exibida em JSON com Gson
- [x] Validação da cadeia (`isChainValid()`)
- [x] Mining (mineração) com Proof of Work: `nonce` e `difficulty`

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

Com `difficulty = 5`, a mineração dos três blocos leva alguns segundos. Para testar mais rápido, diminua o valor em `NoobChain`.

## Estrutura

```
src/
├── Block.java       # o bloco: dados, timestamp, nonce, hash e previousHash; calcula o hash e minera
├── StringUtil.java  # método auxiliar que aplica SHA-256
└── NoobChain.java   # main: cria e minera os blocos, valida a cadeia e exibe em JSON
```

## Como funciona

- **Hash (SHA-256):** a digital fingerprint (impressão digital) do bloco, calculada a partir de `previousHash`, `timeStamp`, `nonce` e `data`.
- **Encadeamento:** cada bloco guarda o hash do anterior (`previousHash`). O genesis block usa `"0"`.
- **Validação:** `isChainValid()` recalcula o hash de cada bloco e confere se ele bate com o guardado, se o `previousHash` bate com o hash do bloco anterior e se o bloco foi minerado. Qualquer alteração em um bloco faz a cadeia ficar inválida.
- **Proof of Work:** `mineBlock(difficulty)` incrementa o `nonce` até o hash começar com `difficulty` zeros. Isso torna caro reescrever blocos antigos, porque cada um teria que ser minerado de novo.

## Exemplo de saída

```
Tentando minerar o bloco 1...
Bloco minerado!!! : 000000b09cf8ca965bea364372f4457a3a10e098dc0cdf5ad794e7370abe546c
Tentando minerar o bloco 2...
Bloco minerado!!! : 00000ac832eb4e40798d25876ebe18230c68ad96194eb75597a503c9eae2c31c
Tentando minerar o bloco 3...
Bloco minerado!!! : 0000050f7c56a025a3ea5862e6d760e040244b7df501b3daee41dd26165ae299

Blockchain é válida: true

A blockchain:
[
  {
    "hash": "000000b09cf8ca965bea364372f4457a3a10e098dc0cdf5ad794e7370abe546c",
    "previousHash": "0",
    "data": "Olá, eu sou o primeiro bloco",
    "timeStamp": 1790619234421,
    "nonce": 1101977
  },
  ...
]
```

Os hashes mudam a cada execução, porque o `timeStamp` é diferente.

## Aprendizados

- Ver a cadeia inteira em JSON no terminal deixou claro como cada `previousHash` aponta para o hash do bloco anterior.
- Esquecer o `nonce` no `calculateHash()` deixa a mineração num loop infinito: o `nonce` muda, mas o hash não. Foi um bom jeito de entender que o hash só muda quando o conteúdo que entra nele muda.
- Em Java, um método não pode ser declarado dentro de outro: o `isChainValid()` vai dentro da classe, fora do `main`.

<!-- Adicionar aqui outras impressões pessoais -->

## Próximos passos

- Parte 2 do tutorial: transactions (transações), digital signatures (assinaturas digitais) e wallets (carteiras).
