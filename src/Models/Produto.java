package Models;

import java.util.Date;

/**
 *Classe que representa uma Produto
 * @author David Lucas Flayban
 */
public class Produto {
    public long produtoID;
    public Categoria categoria = new Categoria();
    public Fornecedor fornecedor = new Fornecedor();
    public String descricao, nome; //elementos multivalorados
    public Date dataDeGarantia;
    public float precoMinimoDeVenda;
    public String statusDoPedido;

    /**
     * Construtor vazio.
     */
    public Produto(){}

    /**
     * Construtor sem ID
     * @param nome o Nome
     * @param descricao a Descrição
     * @param dataDeGarantia a DataDeGarantia
     * @param precoMinimoDeVenda o PreçoMinimoDeVenda
     * @param statusDoPedido o StatusDoPedido
     */
    public Produto(String nome, String descricao, Date dataDeGarantia, float precoMinimoDeVenda, String statusDoPedido){
        this.nome = nome;
        this.descricao = descricao;
        this.dataDeGarantia = dataDeGarantia;
        this.precoMinimoDeVenda = precoMinimoDeVenda;
        this.statusDoPedido = statusDoPedido;
    }
    /**
     * Construtor com ID
     * @param produtoID o ID do Produto
     * @param categoriaID o ID da Categoria
     * @param fornecedorID o ID do Fornecedor
     * @param nome o Nome
     * @param descricao a Descrição
     * @param dataDeGarantia a DataDeGarantia
     * @param precoMinimoDeVenda o PreçoMinimoDeVenda
     * @param statusDoPedido o StatusDoPedido
     */
    public Produto(long produtoID, long categoriaID, long fornecedorID, String nome, String descricao, Date dataDeGarantia, float precoMinimoDeVenda, String statusDoPedido){
        this.produtoID = produtoID;
        this.fornecedor.setFornecedorID(fornecedorID);
        this.categoria.setCategoriaID(categoriaID);
        this.nome = nome;
        this.descricao = descricao;
        this.dataDeGarantia = dataDeGarantia;
        this.precoMinimoDeVenda = precoMinimoDeVenda;
        this.statusDoPedido = statusDoPedido;
    }
    /**
     * Metodo getProdutoID
     * @return produtoID do produto desejado
     */
    public long getProdutoID() {
        return produtoID;
    }
    /**
     * Metodo setProdutoID
     * @param produtoID atribui um valor a vareavel produtoID
     */
    public void setProdutoID(long produtoID) {
        this.produtoID = produtoID;
    }
    /**
     * Metodo getCategoria
     * @return categoria do protudo desejado
     */
    public Categoria getCategoria() {
        return categoria;
    }
    /**
     * Metodo setCategoria
     * @param categoria atribui um valor a vareavel categoria
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    /**
     * Metodo getFornecedor
     * @return fornecedor do protudo desejado
     */
    public Fornecedor getFornecedor() {
        return fornecedor;
    }
    /**
     * Metodo setFornecedor
     * @param fornecedor atribui um valor a vareavel fornecedor
     */
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    /**
     * Metodo getNome
     * @return nome do protudo desejado
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
     * Metodo getDescricao
     * @return descricao do protudo desejado
     */
    public String getDescricao() {
        return descricao;
    }
    /**
     * Metodo setDescricao
     * @param descricao atribui um valor a vareavel descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    /**
     * Metodo getDataDegarantia
     * @return dataDeGarantia do protudo desejado
     */
    public Date getDataDeGarantia() {
        return dataDeGarantia;
    }
    /**
     * Metodo setDataDeGarantia
     * @param dataDeGarantia atribui um valor a vareavel dataDeGarantia
     */
    public void setDataDeGarantia(Date dataDeGarantia) {
        this.dataDeGarantia = dataDeGarantia;
    }
    /**
     * Metodo getPrecoMinimoDeVenda
     * @return precoMinimoDeVenda do protudo desejado
     */
    public float getPrecoMinimoDeVenda() {
        return precoMinimoDeVenda;
    }
    /**
     * Metodo setPrecoMinimoDeVenda
     * @param precoMinimoDeVenda atribui um valor a vareavel precoMinimoDeVenda
     */
    public void setPrecoMinimoDeVenda(float precoMinimoDeVenda) {
        this.precoMinimoDeVenda = precoMinimoDeVenda;
    }
    /**
     * Metodo getStatusDoPedido
     * @return statusDoPedido do protudo desejado
     */
    public String getStatusDoPedido() {
        return statusDoPedido;
    }
    /**
     * Metodo setStatusDoPedido
     * @param statusDoPedido atribui um valor a vareavel statusDoPedido
     */
    public void setStatusDoPedido(String statusDoPedido) {
        this.statusDoPedido = statusDoPedido;
    }
}
