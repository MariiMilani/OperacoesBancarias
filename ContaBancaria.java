package Avancado.Desafio5;

public abstract class ContaBancaria implements Conta {
    double saldo;

    TipoConta tipoConta;

    public ContaBancaria(double saldo) {
        this.saldo = saldo;
    }

    public ContaBancaria(double saldo, TipoConta tipoConta) {
        this(saldo);
        this.tipoConta = tipoConta;
    }

    @Override
    public double consultarSaldo() {
        return saldo;
    }

    public abstract double depositar(double valor);
}
