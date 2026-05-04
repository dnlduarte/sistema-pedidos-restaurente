package restaurante;

public class PedidoRetirada extends Pedido {
    public PedidoRetirada(String cliente, double valor) {
        super(cliente, valor);
    }

    @Override
    public double calcularTotal() {
        return valor;
    }
}