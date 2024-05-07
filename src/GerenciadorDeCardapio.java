import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeCardapio {
    private static final List<Produto> cardapio = new ArrayList<>();

    public static Produto procurarProduto(int codigo){
        for(Produto produto : cardapio){
            if(produto.getCodigo() == codigo){
                return produto;
            }
        }
        return null;
    }
    public static void adicionarProduto(Produto produto){
        cardapio.add(produto);
    }
    public static List<Produto> getCardapio(){
        return cardapio;
    }
    public static void removerProduto(int codigo){
        Produto produto = procurarProduto(codigo);
        cardapio.remove(produto);
    }
    public static void editarProduto(int codigo, Produto novoProduto){
        Produto produto = GerenciadorDeCardapio.procurarProduto(codigo);
        cardapio.set(cardapio.indexOf(produto), novoProduto);

    }
    public static String listarProdutos(){
        StringBuilder produtosListados = new StringBuilder();
        for(Produto produto : cardapio){
            produtosListados.append(produto.getNome()).append("\n");
        }
        return produtosListados.toString();
    }
}
