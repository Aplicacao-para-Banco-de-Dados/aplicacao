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
                    Cliente cliente;
                    switch (opcao2) {
                        case 1:
                            System.out.println("Informe os dados do cliente:\n");
                            System.out.println("Nome:\n");
                            String nome = sc.next();
                            System.out.println("Data de nascimento:\n");
                            Date dataDeNascimento = new Date(sc.next());
                            System.out.println("Pais:\n");
                            String pais = sc.next();
                            System.out.println("Estado:\n");
                            String estado = sc.next();
                            System.out.println("Cidade:\n");
                            String cidade = sc.next();
                            System.out.println("Email:\n");
                            String email = sc.next();
                            System.out.println("Telefone:\n");
                            String telefone = sc.next();
                            System.out.println("Limite de crédito:\n");
                            float limiteDeCredito = sc.nextInt();
                            cliente = new Cliente(nome,dataDeNascimento,pais, estado,cidade,email,telefone,limiteDeCredito);
                            dao = new ClienteDAO() {
                                @Override
                                public void adiciona(Cliente cliente) {
                                    super.adiciona(cliente);
                                }
                            };
                            dao.adiciona(cliente);
                            break;
                        case 2:
                            dao = new ClienteDAO() {
                                @Override
                                public void atualiza(Cliente cliente) {
                                    super.atualiza(cliente);
                                }
                            };
                            dao.busca();
                            System.out.println("Informe o ID do cliente que deseja editar:\n");
                            long idCliente = sc.nextLong();
                            System.out.println("Nome:\n");
                            String nome2 = sc.next();
                            System.out.println("Data de nascimento:\n");
                            Date dataDeNascimento2 = new Date(sc.next());
                            System.out.println("Pais:\n");
                            String pais2 = sc.next();
                            System.out.println("Estado:\n");
                            String estado2 = sc.next();
                            System.out.println("Cidade:\n");
                            String cidade2 = sc.next();
                            System.out.println("Email:\n");
                            String email2 = sc.next();
                            System.out.println("Telefone:\n");
                            String telefone2 = sc.next();
                            System.out.println("Limite de crédito:\n");
                            float limiteDeCredito2 = sc.nextInt();
                            cliente = new Cliente(idCliente,nome2,dataDeNascimento2,pais2, estado2,cidade2,email2,telefone2,limiteDeCredito2);
                            dao.atualiza(cliente);
                            break;
                        case 3:
                            dao = new ClienteDAO() {
                                @Override
                                public void remove(Cliente cliente) {
                                    super.remove(cliente);
                                }
                            };
                            dao.busca();
                            System.out.println("Informe o ID do cliente que deseja remover:\n");
                            long idCliente2 = sc.nextLong();
                            dao.remove(idCliente2);
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
                            System.out.println("Informe os dados do produto:\n");
                            System.out.println("ID da categoria do produto:\n");
                            long idCategoria = sc.nextLong();
                            System.out.println("ID do fornecedor do produto:\n");
                            long idFornecedor = sc.nextLong();
                            System.out.println("Nome:\n");
                            String nome = sc.next();
                            System.out.println("Descrição:\n");
                            String descricao = sc.next();
                            System.out.println("Data da garantia:\n");
                            Date dataDeGarantia = new Date(sc.next());
                            System.out.println("Preço minimo de venda:\n");
                            float precoMinimoDeVenda = sc.nextInt();
                            System.out.println("Statos do produto:\n");
                            String statusDoProduto = sc.next();
                            break;
                        case 2:
                            System.out.println("Informe o ID do produto que deseja editar:\n");
                            long idProduto = sc.nextLong();
                            System.out.println("ID da categoria do produto:\n");
                            long idCategoria2 = sc.nextLong();
                            System.out.println("ID do fornecedor do produto:\n");
                            long idFornecedor2 = sc.nextLong();
                            System.out.println("Nome:\n");
                            String nome2 = sc.next();
                            System.out.println("Descrição:\n");
                            String descricao2 = sc.next();
                            System.out.println("Data da garantia:\n");
                            Date dataDeGarantia2 = new Date(sc.next());
                            System.out.println("Preço minimo de venda:\n");
                            float precoMinimoDeVenda2 = sc.nextInt();
                            System.out.println("Statos do produto:\n");
                            String statusDoProduto2 = sc.next();
                            break;
                        case 3:
                            System.out.println("Informe o ID do produto que deseja excluir:\n");
                            long idProduto2 = sc.nextLong();
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
                    Categoria categoria;
                    switch (opcao2) {
                        case 1:
                            dao = new CategoriaDAO() {
                                @Override
                                public void adiciona(Categoria categoria) {
                                    super.adiciona(categoria);
                                }
                            };
                            String nome, descricao;
                            System.out.println("Informe os dados da Categoria:\n" +
                                    "Nome:\n");
                            nome = sc.next();
                            System.out.println("Descrição:\n");
                            descricao = sc.next();
                            categoria = new Categoria(nome, descricao);
                            dao.adiciona(categoria);
                            break;
                        case 2:
                            dao = new CategoriaDAO() {
                                @Override
                                public void atualiza(Categoria categoria) {
                                    super.atualiza(categoria);
                                }
                            };
                            dao.busca();
                            System.out.println("Informe o ID da categoria que deseja editar:\n");
                            long idFornecedor = sc.nextLong();
                            String nome2, descricao2;
                            System.out.println("Informe os dados da Categoria:\n" +
                                    "Nome:\n");
                            nome2 = sc.next();
                            System.out.println("Descrição:\n");
                            descricao2 = sc.next();
                            categoria = new Categoria(idFornecedor, nome2, descricao2);
                            dao.atualiza(categoria);
                            break;
                        case 3:
                            dao = new CategoriaDAO() {
                                @Override
                                public void remove(Categoria categoria) {
                                    super.remove(categoria);
                                }
                            };
                            dao.busca();
                            System.out.println("Informe o ID da categoria que deseja excluir:\n");
                            long idFornecedor2 = sc.nextLong();
                            dao.remove(idFornecedor2);
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
                        Estoque estoque;
                        case 1:
                            dao = new EstoqueDAO() {
                                @Override
                                public void adiciona(Estoque estoque) {
                                    super.adiciona(estoque);
                                }
                            };
                            System.out.println("Informe os dados do Estoque que deseja criar:\n" +
                                    "ID do produto desejado:\n");
                            long idProduto = sc.nextLong();
                            System.out.println("ID do armazem do Estoque:\n");
                            long idArmazem = sc.nextLong();
                            System.out.println("Quantidade de produtos:\n");
                            int quantidade = sc.nextInt();
                            System.out.println("Codigo do Estoque:\n");
                            int codigo = sc.nextInt();
                            estoque = new Estoque();
                            dao.adiciona(estoque);
                            break;
                        case 2:
                            dao = new EstoqueDAO() {
                                @Override
                                public void atualiza(Estoque estoque) {
                                    super.atualiza(estoque);
                                }
                            };
                            dao.busca();
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
                            estoque = new Estoque();
                            dao.atualiza(estoque);
                            break;
                        case 3:
                            dao = new EstoqueDAO() {
                                @Override
                                public void remove(Estoque estoque) {
                                    super.remove(estoque);
                                }
                            };
                            dao.busca();
                            System.out.println("Informe o ID do estoque que deseja editar:\n");
                            long idEstoque2 = sc.nextLong();
                            dao.remove(idEstoque2);
                            break;
                        default:
                            System.out.println("Opção invalida");
                            break;
                    }
                    break;

                case 6: //Armazem
                    Armazem armazem;
                    System.out.println("" +
                            "|    Armazem    |\n" +
                            "-----------------\n" +
                            "|1 - Criar      |\n" +
                            "|2 - Editar     |\n" +
                            "|3 - Remover    |");
                    opcao2 = sc.nextInt();
                    switch (opcao2){
                        case 1:
                            dao = new ArmazemDAO() {
                                @Override
                                public void adiciona(Armazem armazem) {
                                    super.adiciona(armazem);
                                }
                            };
                            System.out.println("Informe os dados do Armazem que deseja criar:\n" +
                                    "ID do estoque:\n");
                            long idEstoque = sc.nextLong();
                            System.out.println("Nome:\n");
                            String nome = sc.next();
                            System.out.println("Esdereço:\n");
                            String esdereco = sc.next();
                            armazem = new Armazem();
                            dao.adiciona(armazem);
                            break;
                        case 2:
                            dao = new ArmazemDAO() {
                                @Override
                                public void atualiza(Armazem armazem) {
                                    super.atualiza(armazem);
                                }
                            };
                            dao.busca();
                            System.out.println("Informe o ID do Armazem que deseja editar:\n");
                            long idArmazem = sc.nextLong();
                            System.out.println("Informe os novos dados do Armazem:\n" +
                                    "ID do estoque:\n");
                            long idEstoque2 = sc.nextLong();
                            System.out.println("Nome:\n");
                            String nome2 = sc.next();
                            System.out.println("Esdereço:\n");
                            String esdereco2 = sc.next();
                            armazem = new Armazem();
                            dao.atualiza(armazem);
                            break;
                        case 3:
                            dao = new ArmazemDAO() {
                                @Override
                                public void remove(Armazem armazem) {
                                    super.remove(armazem);
                                }
                            };
                            dao.busca();
                            System.out.println("Informe o ID do Armazem que deseja editar:\n");
                            long idArmazem2 = sc.nextLong();
                            dao.remove(idArmazem2);
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
                    Pedido pedido;
                    switch (opcao2){
                        case 1:
                            dao = new PedidoDAO() {
                                @Override
                                public void adiciona(Pedido pedido) {
                                    super.adiciona(pedido);
                                }
                            };
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
                            pedido = new Pedido();
                            dao.adiciona(pedido);
                            break;
                        case 2:
                            dao = new PedidoDAO() {
                                @Override
                                public void atualiza(Pedido pedido) {
                                    super.atualiza(pedido);
                                }
                            };
                            dao.busca();
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
                            pedido =new Pedido();
                            dao.atualiza(pedido);
                            break;
                        case 3:
                            dao= new PedidoDAO() {
                                @Override
                                public void remove(Pedido pedido) {
                                    super.remove(pedido);
                                }
                            };
                            dao.busca();
                            System.out.println("Informe o ID do Pedido que deseja editar:\n");
                            long idPedido2 = sc.nextLong();
                            dao.remove(idPedido2);
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
