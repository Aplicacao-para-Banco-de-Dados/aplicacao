package Models;
/**
 *Classe que representa uma Estoque
 * @author David Lucas Flayban
 */
public class Estoque {
    public long estoqueID;
    public Produto produto;
    public Armazem armazem;
    public int quantidade, codigo;

    /**
     * Construtor vazio.
     */
    public Estoque(int estoqueID, int produto, int armazem, int quantidade, int codigo){}

    /**
     * Construtor sem ID
     * @param produto o Produto
     * @param armazem o Armazém
     * @param codigo o Codígo
     * @param quantidade a Quantidade
     */
    public Estoque(Produto produto, Armazem armazem, int quantidade, int codigo){
        this.produto = produto;
        this.armazem = armazem;
        this.quantidade = quantidade;
        this.codigo = codigo;
    }

    /**
     * Construtor com ID
     * @param estoqueID o EstoqueID
     * @param produto o Produto
     * @param armazem o Armazém
     * @param codigo o Codígo
     * @param quantidade a Quantidade
     */
    public Estoque(long estoqueID, Produto produto, Armazem armazem, int quantidade, int codigo){
        this.estoqueID = estoqueID;
        this.produto = produto;
        this.armazem = armazem;
        this.quantidade = quantidade;
        this.codigo = codigo;
    }
    /**
     * Metodo getEstoqueID
     * @return estoqueID do Estoque desejado
     */
    public long getEstoqueID() {
        return estoqueID;
    }
    /**
     * Metodo setEstoqueID
     * @param estoqueID atribui um valor a vareavel estoqueID
     */
    public void setEstoqueID(long estoqueID) {
        this.estoqueID = estoqueID;
    }
    /**
     * Metodo getProduto
     * @return produto do Estoque desejado
     */
    public Produto getProduto() {
        return produto;
    }
    /**
     * Metodo setProduto
     * @param produto atribui um valor a vareavel produto
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    /**
     * Metodo getArmazem
     * @return armazem do Estoque desejado
     */
    public Armazem getArmazem() {
        return armazem;
    }
    /**
     * Metodo setArmazem
     * @param armazem atribui um valor a vareavel armazem
     */
    public void setArmazem(Armazem armazem) {
        this.armazem = armazem;
    }
    /**
     * Metodo getQuantidade
     * @return quantidade do Estoque desejado
     */
    public int getQuantidade() {
        return quantidade;
    }
    /**
     * Metodo setQuantidade
     * @param quantidade atribui um valor a vareavel quantidade
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    /**
     * Metodo getCodigo
     * @return codigo do Estoque desejado
     */
    public int getCodigo() {
        return codigo;
    }
    /**
     * Metodo setCodigo
     * @param codigo atribui um valor a vareavel codigo
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
