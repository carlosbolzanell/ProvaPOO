public class Bebida extends Produto{
    private double volume;

    public Bebida(int codigo, String descricao, double preco) {
        super(codigo, descricao, preco);
    }

    @Override
    public double calcularPreco(double desconto) {
        return this.getPreco() - desconto;
    }

    @Override
    public String exibirDetalhes() {
        return super.toString() + "\nVolume: "+ volume;
    }
}
