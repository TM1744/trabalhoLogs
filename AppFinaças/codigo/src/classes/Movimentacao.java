package classes;

public class Movimentacao {
    String descricao;
    Float valor;

    public Movimentacao(String descricao, Float valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public Movimentacao(Movimentacao movimentacao) {
        this.descricao = movimentacao.getDescricao();
        this.valor = movimentacao.getValor();
    }

    public String getDescricao() {
        return descricao;
    }

    public Float getValor() {
        return valor;
    }

}
