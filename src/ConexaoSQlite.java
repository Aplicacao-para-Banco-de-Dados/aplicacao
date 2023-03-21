import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSQlite {

    //função para conectar ao banco de dados (ou criar se ele não existir)
    public static Connection conectar() {
        Connection conexao = null;
        try {
            String url = "jdbc:sqlite:C:/DB/Projeto_BD.db";
            conexao = DriverManager.getConnection(url);
            System.out.println("Conexão com SQLite estabelecida.");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return conexao;
    }

}
