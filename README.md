# noobchain

Uma blockchain simples em Java, feita para estudo. Cada bloco guarda o hash SHA-256 do bloco anterior, a cadeia pode ser validada e novos blocos só entram depois de minerados com Proof of Work (prova de trabalho).

Não é para uso em produção.

## Origem

Fiz acompanhando a parte 1 do tutorial [Creating Your First Blockchain with Java](https://medium.com/programmers-blockchain/create-simple-blockchain-java-tutorial-from-scratch-6eeed3cb03fa), de Kass (Programmers Blockchain, 2017). A estrutura, a ordem dos passos e o nome `noobchain` são dele.

O que mudei: usei IntelliJ em vez de Eclipse, adicionei o Gson pelo Maven (`com.google.code.gson:gson:2.11.0`, em Project Structure > Libraries > From Maven) em vez de baixar o jar na mão, e deixei mensagens e comentários em português. Precisa de Java 11 ou mais novo por causa do `String.repeat()`.

## Rodando

```bash
git clone https://github.com/danilobossolani/noobchain.git
```

Abra a pasta no IntelliJ, deixe ele baixar o Gson se pedir e rode o `main` de `src/NoobChain.java`.

Com `difficulty = 5` a mineração dos três blocos levou uns 8 segundos no meu PC. Diminua o valor se quiser testar mais rápido.

## Arquivos

```
src/
├── Block.java       # dados do bloco, cálculo do hash e mineração
├── StringUtil.java  # aplica SHA-256 numa string
└── NoobChain.java   # cria e minera os blocos, valida a cadeia e imprime em JSON
```

## Como funciona

O hash de cada bloco é calculado a partir de `previousHash`, `timeStamp`, `nonce` e `data`. O primeiro bloco usa `"0"` como `previousHash`.

`isChainValid()` recalcula o hash de cada bloco e compara com o que está guardado, confere se o `previousHash` bate com o hash do bloco anterior e se o hash começa com os zeros exigidos. Se alguém mexer em um bloco, a cadeia fica inválida dali para frente.

`mineBlock(difficulty)` vai aumentando o `nonce` até o hash começar com `difficulty` zeros. É isso que deixa caro refazer blocos antigos: cada um teria que ser minerado de novo.

## Saída

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

Os hashes mudam a cada execução porque o `timeStamp` muda.

## Anotações

Ver a cadeia inteira em JSON no terminal ajudou a enxergar cada `previousHash` apontando para o bloco de trás.

Esqueci de colocar o `nonce` no `calculateHash()`. O `nonce` subia, o hash não mudava e a mineração nunca ia terminar. O hash só muda quando o que entra nele muda.

Coloquei o `isChainValid()` dentro do `main` na primeira tentativa. Em Java método não fica dentro de método; ele vai na classe.

O terceiro bloco precisou de mais de 3 milhões de tentativas para achar um hash com cinco zeros.

## Próximo

Parte 2 do tutorial: transações, assinaturas e carteiras.
