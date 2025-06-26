package Avancado.Desafio5;

public class ContaCorrente extends ContaBancaria {

    @Override
    public double depositar(double valor) {
        saldo += valor;
        return saldo;
    }

    public ContaCorrente(double saldo, TipoConta tipoConta) {
        super(saldo, tipoConta);
    }

}
