import aplicacao.bd.*;
import Models.*;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ConexaoSQlite conexao = new ConexaoSQlite();
        InterfaceDAO dao;
        ConexaoSQlite.conectar();
        int opcao = 99;
        while(opcao != 0 ){
            System.out.println("" +
                    "|Selecione a opção desejada|\n" +
                    "----------------------------\n" +
                    "|1 - Cliente               |\n" +
                    "|2 - Produto               |\n" +
                    "|3 - Fornecedor            |\n" +
                    "|4 - Categoria             |\n" +
                    "|5 - Estoque               |\n" +
                    "|6 - Armazem               |\n" +
                    "|7 - Pedido                |\n" +
                    "|0 - Exit                  |");
            opcao = sc.nextInt();
            int opcao2 = 0;
            switch (opcao){
                case 1: // Cliente
                    System.out.println("" +
                            "|    Cliente    |\n" +
                            "-----------------\n" +
                            "|1 - Criar      |\n" +
                            "|2 - Editar     |\n" +
                            "|3 - Remover    |");
                    opcao2 = sc.nextInt();
                    switch (opcao2) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Opção invalida");
                            break;
                    }
                    break;

                case 2: // Produto
                    System.out.println("" +
                            "|    Produto    |\n" +
                            "-----------------\n" +
                            "|1 - Criar      |\n" +
                            "|2 - Editar     |\n" +
                            "|3 - Remover    |");
                    opcao2 = sc.nextInt();
                    switch (opcao2) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Opção invalida");
                            break;
                    }
                    break;

                case 3: // Fornecedor
                    System.out.println("" +
                            "|  Fornecedor   |\n" +
                            "-----------------\n" +
                            "|1 - Criar      |\n" +
                            "|2 - Editar     |\n" +
                            "|3 - Remover    |");
                    opcao2 = sc.nextInt();
                    switch (opcao2) {
                        case 1:
                            String nome, cpfCnpj, tipoFornecedor, localidade;
                            System.out.println("Informe os dados do fornecedor para criar:\n" +
                                    "Nome:\n");
                            nome = sc.next();
                            System.out.println("CPF/CNPJ:\n");
                            cpfCnpj = sc.next();
                            System.out.println("Tipo de Fornecedor:\n");
                            tipoFornecedor = sc.next();
                            System.out.println("Localidade:\n");
                            localidade = sc.next();
                            Fornecedor f = new Fornecedor(nome,cpfCnpj, tipoFornecedor, localidade);
                            dao = new FornecedorDAO() {
                                @Override
                                public void adiciona(Fornecedor fornecedor) {
                                    super.adiciona(fornecedor);
                                }
                            };
                            dao.adiciona(f);
                            break;
                        case 2:
                            String nome2, cpfCnpj2, tipoFornecedor2, localidade2;
                            long id;
                            dao = new FornecedorDAO() {
                                @Override
                                public void atualiza(Fornecedor fornecedor) {
                                    super.atualiza(fornecedor);
                                }
                            };

                            dao.busca();
                            System.out.println("Informe o ID do fornecedor a qual deseja editar:\n");
                            id = sc.nextLong();
                            System.out.println("Informe os dados do fornecedor:\n" +
                                    "Nome:\n");
                            nome2 = sc.next();
                            System.out.println("CPF/CNPJ:\n");
                            cpfCnpj2 = sc.next();
                            System.out.println("Tipo de Fornecedor:\n");
                            tipoFornecedor2 = sc.next();
                            System.out.println("Localidade:\n");
                            localidade2 = sc.next();
                            Fornecedor f2 = new Fornecedor(id, nome2, cpfCnpj2, tipoFornecedor2, localidade2);
                            dao.atualiza(f2);
                            break;
                        case 3:
                            System.out.println("Informe o ID do fornecedor a qual deseja editar:\n");
                            id = sc.nextLong();
                            Fornecedor f3 = new Fornecedor(id, "","","","");
                            dao = new FornecedorDAO() {
                                @Override
                                public void remove(Fornecedor fornecedor) {
                                    super.remove(fornecedor);
                                }
                            };
                            dao.remove(f3);
                            break;
                        default:
                            System.out.println("Opção invalida");
                            break;

                    }
                    break;

                case 4: //Categoria
                    System.out.println("" +
                            "|   Categoria   |\n" +
                            "-----------------\n" +
                            "|1 - Criar      |\n" +
                            "|2 - Editar     |\n" +
                            "|3 - Remover    |");
                    opcao2 = sc.nextInt();
                    switch (opcao2) {
                        case 1:
                            String nome, descricao;
                            System.out.println("Informe os dados da Categoria:\n" +
                                    "Nome:\n");
                            nome = sc.next();
                            System.out.println("Descrição:\n");
                            descricao = sc.next();
                            break;
                        case 2:
                            System.out.println("Informe o ID da categoria que deseja editar:\n");
                            long idFornecedor = sc.nextLong();
                            String nome2, descricao2;
                            System.out.println("Informe os dados da Categoria:\n" +
                                    "Nome:\n");
                            nome2 = sc.next();
                            System.out.println("Descrição:\n");
                            descricao2 = sc.next();
                            break;
                        case 3:
                            System.out.println("Informe o ID da categoria que deseja excluir:\n");
                            long idFornecedor2 = sc.nextLong();
                            break;
                        default:
                            System.out.println("Opção invalida");
                            break;
                    }
                    break;

                case 5: // Estoque
                    System.out.println("" +
                            "|    Estoque    |\n" +
                            "-----------------\n" +
                            "|1 - Criar      |\n" +
                            "|2 - Editar     |\n" +
                            "|3 - Remover    |");
                    opcao2 = sc.nextInt();
                    switch (opcao2){
                        case 1:
                            System.out.println("Informe os dados do Estoque que deseja criar:\n" +
                                    "ID do produto desejado:\n");
                            long idProduto = sc.nextLong();
                            System.out.println("ID do armazem do Estoque:\n");
                            long idArmazem = sc.nextLong();
                            System.out.println("Quantidade de produtos:\n");
                            int quantidade = sc.nextInt();
                            System.out.println("Codigo do Estoque:\n");
                            int codigo = sc.nextInt();

                            break;
                        case 2:
                            System.out.println("Informe o ID do estoque que deseja editar:\n");
                            long idEstoque = sc.nextLong();
                            System.out.println("ID do produto desejado:\n");
                            long idProduto2 = sc.nextLong();
                            System.out.println("ID do armazem do Estoque:\n");
                            long idArmazem2 = sc.nextLong();
                            System.out.println("Quantidade de produtos:\n");
                            int quantidade2 = sc.nextInt();
                            System.out.println("Codigo do Estoque:\n");
                            int codigo2 = sc.nextInt();
                            break;
                        case 3:
                            System.out.println("Informe o ID do estoque que deseja editar:\n");
                            long idEstoque2 = sc.nextLong();
                            break;
                        default:
                            System.out.println("Opção invalida");
                            break;
                    }
                    break;

                case 6: //Armazem
                    System.out.println("" +
                            "|    Armazem    |\n" +
                            "-----------------\n" +
                            "|1 - Criar      |\n" +
                            "|2 - Editar     |\n" +
                            "|3 - Remover    |");
                    opcao2 = sc.nextInt();
                    switch (opcao2){
                        case 1:
                            System.out.println("Informe os dados do Armazem que deseja criar:\n" +
                                    "ID do estoque:\n");
                            long idEstoque = sc.nextLong();
                            System.out.println("Nome:\n");
                            String nome = sc.next();
                            System.out.println("Esdereço:\n");
                            String esdereco = sc.next();
                            break;
                        case 2:
                            System.out.println("Informe o ID do Armazem que deseja editar:\n");
                            long idArmazem = sc.nextLong();
                            System.out.println("Informe os novos dados do Armazem:\n" +
                                    "ID do estoque:\n");
                            long idEstoque2 = sc.nextLong();
                            System.out.println("Nome:\n");
                            String nome2 = sc.next();
                            System.out.println("Esdereço:\n");
                            String esdereco2 = sc.next();
                            break;
                        case 3:
                            System.out.println("Informe o ID do Armazem que deseja editar:\n");
                            long idArmazem2 = sc.nextLong();
                            break;
                        default:
                            System.out.println("Opção invalida");
                            break;
                    }
                    break;

                case 7: // Pedido
                    System.out.println("" +
                            "|    Pedidio    |\n" +
                            "-----------------\n" +
                            "|1 - Criar      |\n" +
                            "|2 - Editar     |\n" +
                            "|3 - Remover    |");
                    opcao2 = sc.nextInt();
                    switch (opcao2){
                        case 1:
                            System.out.println("Informe os dados para ser criado o pedido:\n");
                            System.out.println("ID do Produto:\n");
                            long idProduto = sc.nextLong();
                            System.out.println("ID do Cliente:\n");
                            long idCliente = sc.nextLong();
                            System.out.println("Data do pedido:\n");
                            Date dataDoPedido = new Date(sc.next());
                            System.out.println("Data do prazo de entrega:\n");
                            Date dataDePrazoDaEntrega = new Date(sc.next());
                            System.out.println("Modo de Encomenda:\n");
                            String modoDeEncomenda = sc.next();
                            System.out.println("Status do Pedido:\n");
                            String statusDoPedido = sc.next();
                            break;
                        case 2:
                            System.out.println("Informe o ID do Pedido que deseja editar:\n");
                            long idPedido = sc.nextLong();
                            System.out.println("Informe os dados para ser criado o pedido:\n");
                            System.out.println("ID do Produto:\n");
                            long idProduto2 = sc.nextLong();
                            System.out.println("ID do Cliente:\n");
                            long idCliente2 = sc.nextLong();
                            System.out.println("Data do pedido:\n");
                            Date dataDoPedido2 = new Date(sc.next());
                            System.out.println("Data do prazo de entrega:\n");
                            Date dataDePrazoDaEntrega2 = new Date(sc.next());
                            System.out.println("Modo de Encomenda:\n");
                            String modoDeEncomenda2 = sc.next();
                            System.out.println("Status do Pedido:\n");
                            String statusDoPedido2 = sc.next();
                            break;
                        case 3:
                            System.out.println("Informe o ID do Pedido que deseja editar:\n");
                            long idPedido2 = sc.nextLong();
                            break;
                        default:
                            System.out.println("Opção invalida");
                            break;
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        }

        ConexaoSQlite.desconectar();
    }
}
