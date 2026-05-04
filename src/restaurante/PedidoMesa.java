package restaurante;

public class PedidoMesa extends Pedido implements Pagamento {
    public PedidoMesa(String cliente, double valor) {
        super(cliente, valor);
    }

    @Override
    public double calcularTotal() {
        return valor * 1.10;
    }

    @Override
    public void realizarPagamento() {
        System.out.println("restaurante.Pagamento da mesa de R$" + calcularTotal() + " processado.");
    }
}