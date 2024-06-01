/*
Crie uma aplicação de gerenciamento bancário que possibilite ao usuário informar seu nome, sobrenome e CPF. 
Além disso, a aplicação deverá possibilitar ao usuário consultar saldo, realizar depositos e saques.
Esses procedimentos devem se repetir até que o usuário escolha encerrar o uso da aplicação.
 */
package com.mycompany.gerenciabanco;

import java.util.Scanner; // biblioteca para ler dados

public class GerenciaBanco {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //

        //definindo variáveis
        String nome;
        String sobrenome;
        Long cpf;
        int opcao = 0;
        double saldo = 0;
        double valor = 0;

        //mensagm em tela para o usuário digitar os dados pessoais
        System.out.println("Digite seu primeiro nome: ");
        nome = scanner.nextLine();

        System.out.println("Digite seu sobrenome: ");
        sobrenome = scanner.nextLine();

        System.out.println("Digite seu cpf: ");
        cpf = scanner.nextLong();

        //saudação ao usuário
        System.out.println("Olá, " + nome + " " + sobrenome + "! Escolha o que deseja fazer agora!");

        ContaBancaria conta = new ContaBancaria(nome, sobrenome, cpf);

        //Funções do menu
        do {
            exibeMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    conta.consultarSaldo();
                    break;

                case 2:
                    System.out.println("\n Digite o valor que deseja depositar: R$ ");
                    double valorDeposito = scanner.nextDouble();
                    conta.realizarDeposito(valorDeposito);
                    break;

                case 3:
                    System.out.println("\n Informe o valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    conta.realizarSaque(valorSaque);
                    break;

                case 4:
                    System.out.println("\n Sua sessão foi encerrada!");
                    break;

                default:
                    System.out.println("\n Opção Inválida");
                    break;
            }
        } while (opcao != 4);
    }

    private static void exibeMenu() {
        System.out.println("\n**********************************************");
        System.out.println("1: Consultar Saldo");
        System.out.println("2: Realizar Depósito");
        System.out.println("3: Realizar Saque");
        System.out.println("4: Sair");
        System.out.println("**********************************************");
        System.out.println("\n Digite o número da operação que deseja realizar: ");
    }

    public class ContaBancaria {

        private String nome;
        private String sobrenome;
        private Long cpf;
        private double saldo;

        public ContaBancaria() {
        }

        public void ContaBancaria(String nome, String sobrenome, Long cpf, double saldo) {
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.cpf = cpf;
            this.saldo = saldo;
        }

        public void consultarSaldo() {
            System.out.println("Saldo atual: R$" + String.format("%.2f", saldo));
        }

        public void realizarDeposito(double valor) {
            saldo += valor;
            System.out.println("Depósito de R$" + String.format("%.2f", valor) + " realizado. Novosaldo:R$" + String.format("%.2f", saldo));
        }

        public void realizarSaque(double valor) {
            if (valor > saldo) {
                System.out.println("Saldo insciente.");
            } else {
                saldo -= valor;
                System.out.println("Saque de R$" + String.format("%.2f", valor) + " realizado.Novosaldo:R$" + String.format("%.2f", saldo));
            }
        }
    }
}
