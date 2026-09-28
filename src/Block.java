import java.util.Date;

public class Block {

    public String hash;
    public String previousHash;
    private final String data; // os dados serão uma msg simples
    private final long timeStamp; // milissegundos desde 1/1/1970
    private int nonce;

                //construtor do bloco
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash(); // precisar vir apos a definicao dos outros valores
    }

    public String calculateHash() {
        String calculateHash = StringUtil.applySha256(
                previousHash +
                      Long.toString(timeStamp) +
                        Integer.toString(nonce) +
                      data
        );
        return calculateHash;
    }

    public void mineBlock(int difficulty) {
        String target = "0".repeat(difficulty); // uma string com "difficulty" zeros, ex.: "00000"
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Bloco minerado!!! : " + hash);
    }

}
