package Avancado.Desafio5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        System.out.println("Vamos iniciar seu banco, primeiro digite o saldo contido na conta corrente:");
        ContaCorrente saldoContaCorrente = new ContaCorrente(scanner.nextDouble(), TipoConta.CORRENTE);

        System.out.println("Agora digite o saldo contido na conta poupanca:");
        ContaPoupanca saldoContaPoupanca = new ContaPoupanca(scanner.nextDouble(), TipoConta.POUPANCA);

        do {
            System.out.println("--------------Menu--------------");
            System.out.println("1. Mostrar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Transferencia entre contas");
            System.out.println("4. Sair");
            System.out.println("---------------------------------");

            opcao = scanner.nextInt();
            scanner.nextLine();


            switch (opcao) {
                case 1:
                    System.out.println("Mostar saldo da conta: \n" +
                            "1. Conta Corrente\n" +
                            "2. Conta Poupanca");
                    int tipoContaConsulta = scanner.nextInt();

                    if (tipoContaConsulta == 1) {
                        System.out.println("Seu saldo e de: R$" + saldoContaCorrente.consultarSaldo());
                    } else if (tipoContaConsulta == 2) {
                        System.out.println("Seu saldo e de: R$" + saldoContaPoupanca.consultarSaldo());
                    } else {
                        System.out.println("Conta indisponivel");
                    }
                    break;
                case 2:
                    System.out.println("Qual valor deseja depositar?");
                    double valorDeposito = scanner.nextDouble();

                    System.out.println("Em qual conta deseja fazer o deposito de R$" + valorDeposito + " reais?\n" +
                            "1. Conta Corrente\n" +
                            "2. Conta Poupanca");
                    int tipoContaDeposito = scanner.nextInt();

                    if (tipoContaDeposito == 1) {
                        saldoContaCorrente.depositar(valorDeposito);
                        System.out.println("Deposito realizado com sucesso!");

                    } else if (tipoContaDeposito == 2) {
                        saldoContaPoupanca.depositar(valorDeposito);
                        System.out.println("Deposito realizado com sucesso!");

                    }
                    break;
                case 3:
                    System.out.println("Qual valor deseja depositar?");
                    double valorTransferencia = scanner.nextDouble();

                    System.out.println("O valor R$" + valorTransferencia + " sera transferido de qual conta?\n" +
                            "1. Conta Corrente\n" +
                            "2. Conta Poupanca");
                    int tipoContaTransferencia = scanner.nextInt();

                    if(tipoContaTransferencia == 1){
                        if(saldoContaCorrente.saldo < valorTransferencia){
                            System.out.println("Saldo insuficiente");
                        } else{
                            saldoContaCorrente.saldo = saldoContaCorrente.saldo - valorTransferencia;
                            saldoContaPoupanca.saldo = saldoContaPoupanca.saldo + valorTransferencia;
                            System.out.println("Transferencia para conta poupanca realizda com sucesso!");
                        }
                        break;
                    } else if (tipoContaTransferencia == 2) {
                        if(valorTransferencia > saldoContaPoupanca.saldo){
                            System.out.println("Saldo insuficiente");
                        } else{
                            saldoContaPoupanca.saldo = saldoContaPoupanca.saldo - valorTransferencia;
                            saldoContaCorrente.saldo = saldoContaCorrente.saldo + valorTransferencia;
                            System.out.println("Transferencia para conta corrente realizda com sucesso!");
                        }
                        break;
                    } else{
                        System.out.println("Conta indisponivel");
                        break;
                    }
                case 4:
                    System.out.println("Fechando sistema...");
                    break;
                default:
                    System.out.println("Opcao incorreta, tente novamente");
                    break;
            }
        } while (opcao != 4);

    }

}
