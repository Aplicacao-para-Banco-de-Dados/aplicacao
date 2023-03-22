package aplicacao.bd;

import Models.Cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class ClienteDAO implements InterfaceDAO<Cliente> {

    @Override
    public void adiciona(Cliente cliente) {
        try {
            String query = "INSERT INTO cliente VALUES (null, '" + cliente.getNome() + "', '" + cliente.getDataDeNascimento() + "', '" + cliente.getPais()+ "', '" + cliente.getEstado()+ "', '" + cliente.getCidade() + "', '" + cliente.getEmail() + "', '" + cliente.getTelefone() + "', '" + cliente.getLimiteDeCredito() + "' )";
            ConexaoSQlite.alterarBD(query);
        }catch(SQLException e){
            System.err.println("Não foi possível adicionar o cliente no Banco de dados");
        }
    }

    @Override
    public void remove(Cliente cliente) {
        try{
            String query = "DELETE FROM cliente WHERE id = " + cliente.getClienteID();
            ConexaoSQlite.alterarBD(query);
        }catch (SQLException e){
            System.err.println("Não foi possível remover o cliente do Banco de dados");
        }
    }

    @Override
    public void atualiza(Cliente cliente) {
        try {
            String query = "UPDATE cliente SET nome = '" + cliente.getNome() + "', DataDeNascimento = '" + cliente.getDataDeNascimento() + "', Pais = '" + cliente.getPais() + "', Estado = '" + cliente.getEstado() + "', Cidade = '" + cliente.getCidade() + "', Email = '" + cliente.getEmail() + "', Telefone = '" + cliente.getTelefone() + "', LimiteDeCredito = '" + cliente.getLimiteDeCredito() + "' WHERE cliente.ClienteID = " + cliente.getClienteID();
            ConexaoSQlite.alterarBD(query);
        }catch (SQLException e){
            System.out.println("Não foi possível atualizar a cliente especificado");
        }
    }

    @Override
    public List<Cliente> busca() {
        try {
            Connection bd = ConexaoSQlite.getConexao();
            Statement stm = bd.createStatement();
            String query = "SELECT * FROM cliente";
            try(ResultSet rs = stm.executeQuery(query)){
                List<Cliente> clientes = new ArrayList<Cliente>();
                while (rs.next()){
                    Cliente cliente = new Cliente(rs.getInt("ClienteID"), rs.getString("Nome"), rs.getDate("DataDeNascimento"), rs.getString("Pais"), rs.getString("Estado"), rs.getString("Cidade"), rs.getString("Email"), rs.getString("Telefone"), rs.getFloat("LimiteDeCredito"));
                    clientes.add(cliente);
                }
                return clientes;
            }catch (SQLException e1){
                System.err.println("Falha ao tentar encontrar a tupla especificada");
            }
        }catch (SQLException e2){
            System.err.println("Não foi possível buscar os dados do banco");
        }
        return null;
    }

}
