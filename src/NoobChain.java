import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class NoobChain {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();

    public static void main(String[] args) {
        // adiciona os blocos na ArrayList
        blockchain.add(new Block("Olá, eu sou o primeiro bloco", "0"));
        blockchain.add(new Block("Oi, eu sou o segundo bloco", blockchain.get(blockchain.size() - 1).hash));
        blockchain.add(new Block("E eu sou o terceiro bloco", blockchain.get(blockchain.size() - 1).hash));

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);
    }
}