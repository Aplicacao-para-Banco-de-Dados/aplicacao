package aplicacao.bd;

import Models.Estoque;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class EstoqueDAO implements InterfaceDAO<Estoque> {

    @Override
    public void adiciona(Estoque estoque) {
        try {
            String query = "INSERT INTO estoque VALUES (null, '" + estoque.getProduto() + "', '" + estoque.getArmazem() + "', '" + estoque.getQuantidade() + "', '" + estoque.getCodigo() + "' )";
            ConexaoSQlite.alterarBD(query);
        }catch(SQLException e){
            System.err.println("Não foi possível adicionar o estoque no Banco de dados");
        }
    }

    @Override
    public void remove(Estoque estoque) {
        try{
            String query = "DELETE FROM estoque WHERE id = " + estoque.getEstoqueID();
            ConexaoSQlite.alterarBD(query);
        }catch (SQLException e){
            System.err.println("Não foi possível remover o estoque do Banco de dados");
        }
    }

    @Override
    public void atualiza(Estoque estoque) {
        try {
            String query = "UPDATE estoque SET produto = '" + estoque.getProduto() + "', armazem = '" + estoque.getArmazem() + "', quantidade = '" + estoque.getQuantidade() + "', codigo = '" + estoque.getCodigo() + "' WHERE estoque.EstoqueID = " + estoque.getEstoqueID();
            ConexaoSQlite.alterarBD(query);
        }catch (SQLException e){
            System.out.println("Não foi possível atualizar o estoque especificado");
        }
    }

    @Override
    public List<Estoque> busca() {
        try {
            Connection bd = ConexaoSQlite.getConexao();
            Statement stm = bd.createStatement();
            String query = "SELECT * FROM estoque";
            try(ResultSet rs = stm.executeQuery(query)){
                List<Estoque> estoques = new ArrayList<Estoque>();
                while (rs.next()){
                    Estoque estoque = new Estoque(rs.getInt("EstoqueID"), rs.getInt("Produto"), rs.getInt("Armazem"), rs.getInt("Quantidade"), rs.getInt("Codigo"));
                    estoques.add(estoque);
                }
                return estoques;
            }catch (SQLException e1){
                System.err.println("Falha ao tentar encontrar a tabela Estoque");
            }
        }catch (SQLException e2){
            System.err.println("Não foi possível buscar os dados do banco");
        }
        return null;
    }



}
