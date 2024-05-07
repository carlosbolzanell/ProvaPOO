public class Garcom extends Pessoa{
    private double pagamento;

    public Garcom(String nome, String endereco, String telefone) {
        super(nome, endereco, telefone);
    }

    public Garcom() {
    }

    public void cadastrarPedido(Cliente cliente, Produto produto){
        Pedido pedido = new Pedido(cliente, produto, "Em andamento");
        cliente.fazerPedido(pedido);
    }
    public String exibirMenu(){
        return GerenciadorDeCardapio.listarProdutos();
    }
    public void adicionarItemAoPedido(Pedido pedido, Produto item){
        pedido.adicionarItem(item);
    }
    public void removerItemDoPedido(Pedido pedido, int codigo){
        pedido.removerItem(codigo);
    }
    public void confirmarPedido(Pedido pedido){
        pedido.confirmarPedido();
    }
    public double calcularPagamento(Pedido pedido){
        double pagamento = pedido.calcularTotal() * 0.05;
        this.pagamento += pagamento;
        return pagamento;
    }
}
