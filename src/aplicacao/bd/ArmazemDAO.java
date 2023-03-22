package aplicacao.bd;

import Models.Armazem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class ArmazemDAO implements InterfaceDAO<Armazem> {

    @Override
    public void adiciona(Armazem armazem) {
        try {
            String query = "INSERT INTO armazem VALUES (null, '" + armazem.getNome() + "', '" + armazem.getEndereco() + "', '" + armazem.getEstoque() + "' )";
            ConexaoSQlite.alterarBD(query);
        }catch(SQLException e){
            System.err.println("Não foi possível adicionar o armazém no Banco de dados");
        }
    }

    @Override
    public void remove(Armazem armazem) {
        try{
            String query = "DELETE FROM armazem WHERE id = " + armazem.getArmazemID();
            ConexaoSQlite.alterarBD(query);
        }catch (SQLException e){
            System.err.println("Não foi possível remover o armazém do Banco de dados");
        }
    }

    @Override
    public void atualiza(Armazem armazem) {
        try {
            String query = "UPDATE armazem SET nome = '" + armazem.getNome() + "', endereco = '" + armazem.getEndereco() + "', estoque = '" + armazem.getEstoque() + "' WHERE armazem.ArmazemID = " + armazem.armazemID;
            ConexaoSQlite.alterarBD(query);
        }catch (SQLException e){
            System.out.println("Não foi possível atualizar o armazém especificado");
        }
    }

    @Override
    public List<Armazem> busca() {
        try {
            Connection bd = ConexaoSQlite.getConexao();
            Statement stm = bd.createStatement();
            String query = "SELECT * FROM armazem";
            try(ResultSet rs = stm.executeQuery(query)){
                List<Armazem> armazems = new ArrayList<Armazem>();
                while (rs.next()){
                    Armazem armazem = new Armazem(rs.getInt("ArmazemID"), rs.getString("Nome"), rs.getString("Endereco"), rs.getInt("Estoque"));
                    armazems.add(armazem);
                }
                return armazems;
            }catch (SQLException e1){
                System.err.println("Falha ao tentar encontrar a tupla especificada");
            }
        }catch (SQLException e2){
            System.err.println("Não foi possível buscar os dados do banco");
        }
        return null;
    }
}


