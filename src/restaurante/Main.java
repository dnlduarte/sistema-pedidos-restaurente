package restaurante;

public class Main {
    public static void main(String[] args) {
        PedidoDelivery delivery = new PedidoDelivery("Ana", 50.0);
        PedidoRetirada retirada = new PedidoRetirada("Bruno", 30.0);
        PedidoMesa mesa = new PedidoMesa("Carlos", 80.0);

        System.out.println("=== Delivery ===");
        delivery.exibirPedido();
        delivery.realizarPagamento();

        System.out.println("\n=== Retirada ===");
        retirada.exibirPedido();

        System.out.println("\n=== Mesa ===");
        mesa.exibirPedido();
        mesa.realizarPagamento();
    }
}
