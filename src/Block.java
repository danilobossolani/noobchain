import java.util.Date;

public class Block {

    public String hash;
    public String previousHash;
    private final String data; // os dados serão uma msg simples
    private final long timeStamp; // milissegundos desde 1/1/1970

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
                      data
        );
        return calculateHash;
    }

}
