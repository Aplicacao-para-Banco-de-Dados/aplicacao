import aplicacao.bd.*;

public class Main {

    public static void main(String[] args){

        ConexaoSQlite conexao = new ConexaoSQlite();
        ConexaoSQlite.conectar();
        ConexaoSQlite.desconectar();
    }
}
