package Models;
/**
 *Classe que representa uma Armazem
 * @author David Lucas Flayban
 */
public class Armazem {
    public long armazemID;
    public Estoque estoque;
    public String endereco, nome;

    /**
     * Construtor vazio.
     */
    public Armazem(){}

    /**
     * Construtor sem ID
     * @param endereco o Endereço
     * @param estoque o Estoque
     * @param nome  o Nome
     */
    public Armazem(Estoque estoque, String endereco, String nome){
        this.estoque = estoque;
        this.endereco = endereco;
        this.nome = nome;
    }
    /**
     * Construtor com ID
     * @param armazemID o ArmazémID
     * @param endereco o Endereço
     * @param estoque o Estoque
     * @param nome  o Nome
     */
    public Armazem(long armazemID, Estoque estoque, String endereco, String nome){
        this.armazemID = armazemID;
        this.estoque = estoque;
        this.endereco = endereco;
        this.nome = nome;
    }
    /**
     * Metodo getArmazemID
     * @return armazemID do Armazem desejado
     */
    public long getArmazemID() {
        return armazemID;
    }
    /**
     * Metodo setArmazemID
     * @param armazemID atribui um valor a vareavel armazemID
     */
    public void setArmazemID(long armazemID) {
        this.armazemID = armazemID;
    }
    /**
     * Metodo getEstoque
     * @return estoque do Armazem desejado
     */
    public Estoque getEstoque() {
        return estoque;
    }
    /**
     * Metodo setEstoque
     * @param estoque atribui um valor a vareavel estoque
     */
    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
    /**
     * Metodo getNome
     * @return nome do Armazem desejado
     */
    public String getNome() {
        return nome;
    }
    /**
     * Metodo setNome
     * @param nome atribui um valor a vareavel nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * Metodo getEndereco
     * @return endereco do Armazem desejado
     */
    public String getEndereco() {
        return endereco;
    }
    /**
     * Metodo setEndereco
     * @param endereco atribui um valor a vareavel endereco
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
