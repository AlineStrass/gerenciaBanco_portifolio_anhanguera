/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.gerenciabanco;
import java.util.Scanner;

/**
 *
 * @author Aline
 */
public class GerenciaBanco {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Definindo variáveis
        String nome;
        String sobrenome;
        long cpf; 
        int opcao = 0;

        // Mensagem em tela para o usuário digitar os dados pessoais
        System.out.println("Digite seu primeiro nome: ");
        nome = scanner.nextLine();

        System.out.println("Digite seu sobrenome: ");
        sobrenome = scanner.nextLine();

        System.out.println("Digite seu cpf: ");
        cpf = scanner.nextLong();

        // Saudação ao usuário
        System.out.println("Olá, " + nome + " " + sobrenome + "! Escolha o que deseja fazer agora!");

        ContaBancaria conta = new ContaBancaria(nome, sobrenome, cpf);

        // Funções do menu
        do {
            exibeMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    conta.consultarSaldo();
                    break;

                case 2:
                    System.out.println("\nDigite o valor que deseja depositar: R$ ");
                    double valorDeposito = scanner.nextDouble();
                    conta.realizarDeposito(valorDeposito);
                    break;

                case 3:
                    System.out.println("\nInforme o valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    conta.realizarSaque(valorSaque);
                    break;

                case 4:
                    System.out.println("\nSua sessão foi encerrada!");
                    break;

                default:
                    System.out.println("\nOpção Inválida");
                    break;
            }

            // Consumir a nova linha pendente
            scanner.nextLine();

        } while (opcao != 4);

        scanner.close();
    }

    private static void exibeMenu() {
        System.out.println("\n**********************************************");
        System.out.println("1: Consultar Saldo");
        System.out.println("2: Realizar Depósito");
        System.out.println("3: Realizar Saque");
        System.out.println("4: Sair");
        System.out.println("**********************************************");
        System.out.println("\nDigite o número da operação que deseja realizar: ");
    }
}

class ContaBancaria {

    private String nome;
    private String sobrenome;
    private long cpf;
    private double saldo;

    public ContaBancaria(String nome, String sobrenome, long cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.saldo = 0; // Inicializar saldo como zero
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual: R$ " + String.format("%.2f", saldo));
    }

    public void realizarDeposito(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$ " + String.format("%.2f", valor) + " realizado. Novo saldo: R$ "
                + String.format("%.2f", saldo));
    }

    public void realizarSaque(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
        } else {
            saldo -= valor;
            System.out.println("Saque de R$ " + String.format("%.2f", valor) + " realizado. Novo saldo: R$ "
                    + String.format("%.2f", saldo));
        }
    }
}
