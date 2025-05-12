package poo;

import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException; 



public class Teste {

    public static void main(String[] args) {
       
        Config_Quarry dbOperations = new Config_Quarry(); 
        Scanner sc = new Scanner(System.in);
        int op = 0;

        do {
            System.out.println("\n===== MENU DE ESTOQUE ====="); 
            System.out.println("1. Cadastrar Produto"); 
            System.out.println("2. Consultar Produtos"); 
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                if (sc.hasNextInt()) { 
                    op = sc.nextInt();
                } else {
                    System.out.println("Opção inválida. Por favor, insira um número.");
                    op = -1;
                }
                sc.nextLine(); 

                switch (op) {
                    case 1:
                        System.out.println("--- Cadastro de Produto ---");
                        System.out.print("Informe o EAN: ");
                        String ean = sc.nextLine();
                        System.out.print("Informe a descrição do produto: ");
                        String descricao = sc.nextLine();

                        int quantidade = 0;
                        boolean quantidadeValida = false;
                        while (!quantidadeValida) {
                            System.out.print("Informe a quantidade do produto: ");
                            if (sc.hasNextInt()) {
                                quantidade = sc.nextInt();
                                if (quantidade >= 0) { 
                                    quantidadeValida = true;
                                } else {
                                    System.out.println("Quantidade não pode ser negativa.");
                                }
                            } else {
                                System.out.println("Entrada inválida para quantidade. Use números.");
                            }
                            sc.nextLine(); 
                        }

                        double valor = 0.0;
                        boolean valorValido = false;
                        while (!valorValido) {
                            System.out.print("Informe o valor do produto (ex: 10.99): ");
                            if (sc.hasNextDouble()) {
                                valor = sc.nextDouble();
                                if (valor >= 0.0) { 
                                    valorValido = true;
                                } else {
                                    System.out.println("Valor não pode ser negativo.");
                                }
                            } else {
                                System.out.println("Entrada inválida para valor. Use números (use . como separador decimal).");
                            }
                            sc.nextLine(); 
                        }

                        Estoque est = new Estoque(ean, descricao, quantidade, valor);
                        dbOperations.inserir(est); 
  
                        break;
                    case 2:
                        System.out.println("--- Produtos Cadastrados ---");
                        listarProdutos(); 
                        break;
                    case 0:
                        System.out.println("Saindo do sistema...");
                        break;
                    case -1: 
                       
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (InputMismatchException e) { 
                System.out.println("Entrada inválida. Por favor, insira o tipo de dado esperado.");
                sc.nextLine(); 
                op = -1;
            }

        } while (op != 0);
        sc.close();
        System.out.println("Sistema encerrado.");
    }

    
    private static void listarProdutos() { 
        List<Estoque> listaDeItens = Config_Quarry.listarEstoque();

        if (listaDeItens == null || listaDeItens.isEmpty()) {
            System.out.println("Nenhum produto encontrado no estoque.");
            return;
        }

        for (Estoque itemEstoque : listaDeItens) {
            System.out.println("===============================");
            System.out.printf("EAN: %s\n", itemEstoque.getEAN());
            System.out.printf("Descrição: %s\n", itemEstoque.getDESCRICAO());
            System.out.printf("Quantidade: %d\n", itemEstoque.getQUANTIDADE());
            System.out.printf("Valor: R$ %.2f\n", itemEstoque.getValor());
        }
        System.out.println("===============================");
    }
}