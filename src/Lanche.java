public class Lanche extends Produto{
    private double peso;

    public Lanche(int codigo, String descricao, double preco) {
        super(codigo, descricao, preco);
    }

    @Override
    public double calcularPreco(double desconto) {
        return this.getPreco() - desconto;
    }

    @Override
    public String exibirDetalhes() {
        return super.toString() + "\nPeso: "+ peso;
    }
}
