package restaurante;

public class PedidoDelivery extends Pedido implements Pagamento {
    public PedidoDelivery(String cliente, double valor) {
        super(cliente, valor);
    }

    @Override
    public double calcularTotal() {
        return valor + 10;
    }

    @Override
    public void realizarPagamento() {
        System.out.println("restaurante.Pagamento do delivery de R$" + calcularTotal() + " processado.");
    }
}