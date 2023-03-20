package Models;
/**
 *Classe que representa uma ProdutoPedido
 * @author David Lucas Flayban
 */
public class ProdutoPedido {
    public Produto produto;
    public Pedido pedido;
    public float precoDeVenda;
    public int quantidade;

    /**
     * Construtor vazio.
     */
    public ProdutoPedido(){}

    /**
     * Construtor
     * @param produto o Produto
     * @param pedido o Pedido
     * @param precoDeVenda o PreçoDeVenda
     * @param quantidade a Quantidade
     */
    public ProdutoPedido(Produto produto, Pedido pedido, float precoDeVenda, int quantidade){
        this.pedido = pedido;
        this.produto = produto;
        this.precoDeVenda = precoDeVenda;
        this.quantidade = quantidade;
    }
    /**
     * Metodo getProduto
     * @return produto do ProdutoPedido desejado
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
     * Metodo getPedido
     * @return pedido do ProdutoPedido desejado
     */
    public Pedido getPedido() {
        return pedido;
    }
    /**
     * Metodo setPedido
     * @param pedido atribui um valor a vareavel pedido
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    /**
     * Metodo getQuantidade
     * @return quantidade do ProdutoPedido desejado
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
     * Metodo getPrecoDeVenda
     * @return precoDeVenda do ProdutoPedido desejado
     */
    public float getPrecoDeVenda() {
        return precoDeVenda;
    }
    /**
     * Metodo setPrecoDeVenda
     * @param precoDeVenda atribui um valor a vareavel precoDeVenda
     */
    public void setPrecoDeVenda(float precoDeVenda) {
        this.precoDeVenda = precoDeVenda;
    }
}
