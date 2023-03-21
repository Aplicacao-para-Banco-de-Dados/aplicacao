package aplicacao.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoSQlite {
    private static Connection conexao;

    //função para conectar ao banco de dados (ou criar se ele não existir)
    public static void conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:BD/Projeto_BD.db";
            conexao = DriverManager.getConnection(url);
            System.out.println("Conexão com o banco SQLite estabelecida.");
        } catch (SQLException e1) {
            System.err.println(e1.getMessage());
        } catch (ClassNotFoundException e2){
            System.err.println("Falha ao utilizar o driver");
        }
    }

    public static void desconectar() {
        if (conexao == null)
            return;
        try{
            if (!conexao.isClosed()) {
                conexao.close();
                System.out.println("O banco SQLite foi desconectado!");
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public static Connection getConexao() {
        try{
            if (conexao == null)
                conectar();
            if (conexao.isClosed())
                conectar();
        }catch (SQLException e){
            System.err.println("Não foi possível conectar com o banco de dados");
        }
        return conexao;
    }
}
