package aplicacao.bd;

import Models.Pedido;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class PedidoDAO implements InterfaceDAO<Pedido>{

    @Override
    public void adiciona(Pedido pedido) {
        try {
            String query = "INSERT INTO pedido VALUES (null, '" + pedido.getProduto() + "', '" + pedido.getCliente() + "', '" + pedido.getDataDoPedido()+ "', '" + pedido.getDataDePrazoDaEntrega()+ "', '" + pedido.getModoDeEncomenda() + "', '" + pedido.getStatusDoPedido() + "' )";
            ConexaoSQlite.alterarBD(query);
        }catch(SQLException e){
            System.err.println("Não foi possível adicionar o pedido no Banco de dados");
        }
    }

    @Override
    public void remove(Pedido pedido) {
        try{
            String query = "DELETE FROM pedido WHERE id = " + pedido.getPedidoID();
            ConexaoSQlite.alterarBD(query);
        }catch (SQLException e){
            System.err.println("Não foi possível remover o pedido do Banco de dados");
        }
    }

    @Override
    public void atualiza(Pedido pedido) {
        try {
            String query = "UPDATE pedido SET produto = '" + pedido.getProduto() + "', cliente = '" + pedido.getCliente() + "', DataDoPedido = '" + pedido.getDataDoPedido() + "', DataDePrazoDaEntrega = '" + pedido.getDataDePrazoDaEntrega() + "', ModoDeEncomenda = '" + pedido.getModoDeEncomenda() + "', StatusDoPedido = '" + pedido.getStatusDoPedido() + "' WHERE pedido.PedidoID = " + pedido.getPedidoID();
            ConexaoSQlite.alterarBD(query);
        }catch (SQLException e){
            System.out.println("Não foi possível atualizar a pedido especificado");
        }
    }

    @Override
    public List<Pedido> busca() {
        try {
            Connection bd = ConexaoSQlite.getConexao();
            Statement stm = bd.createStatement();
            String query = "SELECT * FROM pedido";
            try(ResultSet rs = stm.executeQuery(query)){
                List<Pedido> pedidos = new ArrayList<Pedido>();
                while (rs.next()){
                    Pedido pedido = new Pedido(rs.getInt("PedidoID"), rs.getInt("Produto"), rs.getInt("Cliente"), rs.getDate("DataDoPedido"), rs.getDate("DataDePrazoDaEntrega"), rs.getString("ModoDeEncomenda"), rs.getString("StatusDoPedido"));
                    pedidos.add(pedido);
                }
                return pedidos;
            }catch (SQLException e1){
                System.err.println("Falha ao tentar encontrar a tupla especificada");
            }
        }catch (SQLException e2){
            System.err.println("Não foi possível buscar os dados do banco");
        }
        return null;
    }







}
