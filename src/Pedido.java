public class Pedido {
    private Cliente cliente;
    private Produto item;
    private String status;
    private int numeroPedido;

    public Pedido(Cliente cliente,Produto item, String status) {
        this.cliente = cliente;
        this.item = item;
        this.status = status;
    }

    public Pedido() {
    }

    public void adicionarItem(Produto produto){
        if(this.item instanceof Combo combo && !(produto instanceof Combo)){
            combo.adicionarItem(produto);
        }
    }
    public void removerItem(int codigo){
        Produto produto = GerenciadorDeCardapio.procurarProduto(codigo);
        if(this.item instanceof Combo combo){
            combo.removerItem(produto);
        }
    }
    public double calcularTotal(){
        double soma = 0;
        if(this.item instanceof Combo combo){
            return combo.calcularPreco();
        }
        return item.getPreco();
    }
    public void confirmarPedido(){
        if(this.status.equals("Em Andamento")){
            this.status = "Confirmado";
        }
    }
    public void setStatus(String status){
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Produto getItem() {
        return item;
    }

    public String getStatus() {
        return status;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }
}
