import java.util.ArrayList;
import java.util.List;

public class Combo extends Produto{
    private final List<Produto> produtos = new ArrayList<>();
    private double desconto = calcularDesconto();

    public Combo(int codigo, String descricao, double preco) {
        super(codigo, descricao, preco);
    }
    public Combo(){

    }

    public double calcularDesconto(){
        if(produtos.size() == 2){
            return 0.05;
        }else if(produtos.size() == 3){
            return 0.1;
        }else{
            return 0.15;
        }
    }

    public double calcularPreco(){
        double soma = 0;
        for(Produto produto : produtos){
            soma += produto.getPreco();
        }
        return soma * (1 - this.desconto);
    }

    @Override
    public double calcularPreco(double desconto) {
        return 0;
    }

    @Override
    public String exibirDetalhes() {
        return super.toString() + "\nProdutos: "+ produtos + "\n" +
                "Desconto: "+desconto;
    }

    public void adicionarItem(Produto produto){
        produtos.add(produto);
    }
    public void removerItem(Produto produto){
        produtos.remove(produto);
    }
}
