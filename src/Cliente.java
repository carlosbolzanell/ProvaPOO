import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa{
    private final List<Pedido> pedidos = new ArrayList<>();

    public Cliente(String nome, String endereco, String telefone) {
        super(nome, endereco, telefone);
    }
    public Cliente(){

    }
    public Pedido procurarPedido(int codigo){
        for(Pedido pedido : pedidos){
            if(pedido.getNumeroPedido() == codigo){
                return pedido;
            }
        }
        return null;
    }

    public void fazerPedido(Pedido pedido){
        pedido.setNumeroPedido(pedidos.size());
        pedidos.add(pedido);
    }
    public void cancelarPedido(Pedido pedido){
        pedido.setStatus("Cancelado");
    }
    public String viualizarPedido(){
        String vizualizarPedidos = "";
        for(Pedido pedido : pedidos){
            vizualizarPedidos += "Cliente: " + pedido.getCliente().getNome() + "\n" +
                    "Pedido: " + pedido.getItem().getNome() + "\n" +
                    "Status: " + pedido.getStatus();
        }
        return vizualizarPedidos;

    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
