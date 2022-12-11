package Contato;
public class Contato {
    private int valordarecarga;
    private int saldoatual;
    private String nome;
    private int cpf;
    private double recarga;

    public double getRecarga() {
        return recarga;
    }

    public void setRecarga(double recarga) {
        this.recarga = recarga;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

  

    public int getSaldoatual() {
        return saldoatual;
    }

    public void setSaldoatual(int saldoatual) {
        this.saldoatual = saldoatual;
    }
}
