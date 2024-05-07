public class Outro extends Produto{
    private String tamanho;

    public Outro(int codigo, String descricao, double preco) {
        super(codigo, descricao, preco);
    }

    @Override
    public double calcularPreco(double desconto) {
        return this.getPreco() - desconto;
    }

    @Override
    public String exibirDetalhes() {
        return super.toString() + "\nTamanho: "+ tamanho;
    }
}
