package aplicacao.bd;

import Models.Categoria;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class CategoriaDAO implements InterfaceDAO<Categoria>{

    @Override
    public void adiciona(Categoria categoria) {
        try {
            String query = "INSERT INTO categoria VALUES (null, '" + categoria.getNome() + "', '" + categoria.getDescricao() + "' )";
            ConexaoSQlite.alterarBD(query);
        }catch(SQLException e){
            System.err.println("Não foi possível adicionar a categoria no Banco de dados");
        }
    }

    @Override
    public void remove(Categoria categoria) {
        try{
            String query = "DELETE FROM categoria WHERE id = " + categoria.getCategoriaID();
            ConexaoSQlite.alterarBD(query);
        }catch (SQLException e){
            System.err.println("Não foi possível remover a categoria do Banco de dados");
        }
    }

    @Override
    public void atualiza(Categoria categoria) {
        try {
            String query = "UPDATE categoria SET nome = '" + categoria.getNome() + "', descricao = '" + categoria.getDescricao() + "' WHERE categoria.CategoriaID = " + categoria.getCategoriaID();
            ConexaoSQlite.alterarBD(query);
        }catch (SQLException e){
            System.out.println("Não foi possível atualizar a categoria especificado");
        }
    }

    @Override
    public List<Categoria> busca() {
        try {
            Connection bd = ConexaoSQlite.getConexao();
            Statement stm = bd.createStatement();
            String query = "SELECT * FROM categoria";
            try(ResultSet rs = stm.executeQuery(query)){
                List<Categoria> categorias = new ArrayList<Categoria>();
                while (rs.next()){
                    Categoria categoria = new Categoria(rs.getInt("CategoriaID"), rs.getString("Nome"), rs.getString("Descricao"));
                    categorias.add(categoria);
                }
                return categorias;
            }catch (SQLException e1){
                System.err.println("Falha ao tentar encontrar a tabela Categoria");
            }
        }catch (SQLException e2){
            System.err.println("Não foi possível buscar os dados do banco");
        }
        return null;
    }
}

