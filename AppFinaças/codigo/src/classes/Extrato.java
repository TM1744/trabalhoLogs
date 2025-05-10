package classes;

import java.util.ArrayList;

public class Extrato {
    ArrayList<Movimentacao> movimentacoes;
    Float saldo;

    public Extrato (){
        this.movimentacoes = new ArrayList<>();
        this.saldo = 0.0f;
    }

    public ArrayList<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }
    public Movimentacao getMovimentacao(int index){
        return this.movimentacoes.get(index);
    }
    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    private Float calcularSaldo(){
        Float valorTotal = 0.0f;
        for(Movimentacao valor : this.getMovimentacoes()){
            valorTotal += valor.getValor();
        }
        return valorTotal;
    }

    public void atualizarSaldo(){
        this.setSaldo(this.calcularSaldo());
    }

    public void adicionarMovimentacao(Movimentacao movimentacao){
        this.getMovimentacoes().add(movimentacao);
    }

    public void apresentarMovimentacao(){
        for(int count = 0; count != this.getMovimentacoes().size(); count++){
            System.out.println((count + 1) + "- " + (this.getMovimentacoes().get(count).getDescricao()) + " = " + (this.getMovimentacoes().get(count).getValor()));
        }
    }

    public void retirarMovimentacao(int number){
        this.getMovimentacoes().remove(number);
    }
}

