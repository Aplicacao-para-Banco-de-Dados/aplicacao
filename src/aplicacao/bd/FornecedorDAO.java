package aplicacao.bd;

import Models.Fornecedor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class FornecedorDAO implements InterfaceDAO<Fornecedor>{

    @Override
    public void adiciona(Fornecedor fornecedor) {
        try {
            String query = "INSERT INTO fornecedor VALUES (null, '" + fornecedor.getNome() + "', '" + fornecedor.getCpfCnpj() + "', '" + fornecedor.getTipoDeFornecedor()+ "', '" + fornecedor.getLocalidade() + "' )";
            ConexaoSQlite.alterarBD(query);
        }catch(SQLException e){
            System.err.println("Não foi possível adicionar o fornecedor no Banco de dados");
        }
    }

    @Override
    public void remove(Fornecedor fornecedor) {
        try{
            String query = "DELETE FROM fornecedor WHERE id = " + fornecedor.getFornecedorID();
            ConexaoSQlite.alterarBD(query);
        }catch (SQLException e){
            System.err.println("Não foi possível remover o fornecedor do Banco de dados");
        }
    }

    @Override
    public void atualiza(Fornecedor fornecedor) {
        try {
            String query = "UPDATE fornecedor SET nome = '" + fornecedor.getNome() + "', CpfCnpj = '" + fornecedor.getCpfCnpj() + "', TipoDeFornecedor = '" + fornecedor.getTipoDeFornecedor() + "', Localidade = '" + fornecedor.getLocalidade() + "' WHERE fornecedor.FornecedorID = " + fornecedor.getFornecedorID();
            ConexaoSQlite.alterarBD(query);
        }catch (SQLException e){
            System.out.println("Não foi possível atualizar o fornecedor especificado");
        }
    }

    @Override
    public List<Fornecedor> busca() {
        try {
            Connection bd = ConexaoSQlite.getConexao();
            Statement stm = bd.createStatement();
            String query = "SELECT * FROM fornecedor";
            try(ResultSet rs = stm.executeQuery(query)){
                List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
                while (rs.next()){
                    Fornecedor fornecedor = new Fornecedor(rs.getInt("FornecedorID"), rs.getString("Nome"), rs.getString("CpfCnpj"), rs.getString("TipoDeFornecedor"), rs.getString("Localidade"));
                    fornecedores.add(fornecedor);
                }
                return fornecedores;
            }catch (SQLException e1){
                System.err.println("Falha ao tentar encontrar a tupla especificada");
            }
        }catch (SQLException e2){
            System.err.println("Não foi possível buscar os dados do banco");
        }
        return null;
    }








}
