package Avancado.Desafio5;

public class ContaPoupanca extends ContaBancaria {

    @Override
    public double depositar(double valor) {
        double taxaAdm = valor * 0.01;
        saldo = saldo + (valor - taxaAdm);
        return saldo;
    }

    public ContaPoupanca(double saldo) {
        super(saldo);
    }

    public ContaPoupanca(double saldo, TipoConta tipoConta) {
        super(saldo, tipoConta);
    }

}
