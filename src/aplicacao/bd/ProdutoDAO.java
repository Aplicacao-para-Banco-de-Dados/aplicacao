package aplicacao.bd;

import Models.Produto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class ProdutoDAO implements InterfaceDAO<Produto> {

    @Override
    public void adiciona(Produto produto) {
        try {
            String query = "INSERT INTO produto VALUES (null, '" + produto.getCategoria() + "', '" + produto.getFornecedor() + "', '" + produto.getDescricao()+ "', '" + produto.getNome()+ "', '" + produto.getDataDeGarantia() + "', '" + produto.getPrecoMinimoDeVenda() + "', '" + produto.getStatusDoPedido() + "' )";
            ConexaoSQlite.alterarBD(query);
        }catch(SQLException e){
            System.err.println("Não foi possível adicionar o produto no Banco de dados");
        }
    }

    @Override
    public void remove(Produto produto) {
        try{
            String query = "DELETE FROM produto WHERE id = " + produto.getProdutoID();
            ConexaoSQlite.alterarBD(query);
        }catch (SQLException e){
            System.err.println("Não foi possível remover o produto do Banco de dados");
        }
    }

    @Override
    public void atualiza(Produto produto) {
        try {
            String query = "UPDATE produto SET categoria = '" + produto.getCategoria() + "', Fornecedor = '" + produto.getFornecedor() + "', Descricao = '" + produto.getDescricao() + "', Nome = '" + produto.getNome() + "', DataDeGarantia = '" + produto.getDataDeGarantia() + "', PrecoMinimoDeVenda = '" + produto.getPrecoMinimoDeVenda() + "', StatusDoPedido = '" + produto.getStatusDoPedido() + "' WHERE produto.ProdutoID = " + produto.getProdutoID();
            ConexaoSQlite.alterarBD(query);
        }catch (SQLException e){
            System.out.println("Não foi possível atualizar a produto especificado");
        }
    }

    @Override
    public List<Produto> busca() {
        try {
            Connection bd = ConexaoSQlite.getConexao();
            Statement stm = bd.createStatement();
            String query = "SELECT * FROM produto";
            try(ResultSet rs = stm.executeQuery(query)){
                List<Produto> produtos = new ArrayList<Produto>();
                while (rs.next()){
                    Produto produto = new Produto(rs.getInt("ProdutoID"), rs.getInt("Categoria"), rs.getInt("Fornecedor"), rs.getString("Descricao"), rs.getString("Nome"), rs.getDate("DataDeGarantia"), rs.getFloat("PrecoMinimoDeVenda"), rs.getString("StatusDoPedido"));
                    produtos.add(produto);
                }
                return produtos;
            }catch (SQLException e1){
                System.err.println("Falha ao tentar encontrar a tupla especificada");
            }
        }catch (SQLException e2){
            System.err.println("Não foi possível buscar os dados do banco");
        }
        return null;
    }


}
