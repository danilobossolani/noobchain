import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class NoobChain {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static int difficulty = 5;

    public static void main(String[] args) {
        // adiciona os blocos na ArrayList e minera cada um
        blockchain.add(new Block("Olá, eu sou o primeiro bloco", "0"));
        System.out.println("Tentando minerar o bloco 1... ");
        blockchain.get(0).mineBlock(difficulty);

        blockchain.add(new Block("Oi, eu sou o segundo bloco", blockchain.get(blockchain.size() - 1).hash));
        System.out.println("Tentando minerar o bloco 2... ");
        blockchain.get(1).mineBlock(difficulty);

        blockchain.add(new Block("E eu sou o terceiro bloco", blockchain.get(blockchain.size() - 1).hash));
        System.out.println("Tentando minerar o bloco 3... ");
        blockchain.get(2).mineBlock(difficulty);

        System.out.println("\nBlockchain é válida: " + isChainValid());

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("\nA blockchain: ");
        System.out.println(blockchainJson);
    }

    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = "0".repeat(difficulty);

        // percorre a blockchain conferindo os hashes
        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);
            // compara o hash guardado com o hash recalculado
            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("Os hashes atuais não são iguais");
                return false;
            }
            // compara o hash do bloco anterior com o previousHash guardado
            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("Os hashes anteriores não são iguais");
                return false;
            }
            // confere se o hash foi resolvido (minerado)
            if (!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
                System.out.println("Este bloco não foi minerado");
                return false;
            }
        }
        return true;
    }
}
