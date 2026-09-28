import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class NoobChain {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();

    public static void main(String[] args) {

        Block genesisBlock = new Block("Olá, eu sou o primeiro bloco", "0");
        System.out.println("Hash do bloco 1 : " + genesisBlock.hash);

        Block secondBlock = new Block("Oi, eu sou o segundo bloco", genesisBlock.hash);
        System.out.println("Hash do bloco 2 : " + secondBlock.hash);

        Block thirdBlock = new Block("E eu sou o terceiro bloco", secondBlock.hash);
        System.out.println("Hash do bloco 3 : " + thirdBlock.hash);

    }
}
