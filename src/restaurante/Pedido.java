package restaurante;

public abstract class Pedido {
    protected String cliente;
    protected double valor;

    public Pedido(String cliente, double valor) {
        this.cliente = cliente;
        this.valor = valor;
    }

    public void exibirPedido() {
        System.out.println("Cliente: " + cliente);
        System.out.println("Valor base: R$" + valor);
        System.out.println("Total: R$" + calcularTotal());
    }

    public abstract double calcularTotal();
}