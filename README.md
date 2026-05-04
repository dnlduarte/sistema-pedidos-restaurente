# 🍽️ Sistema de Pedidos de Restaurante

Projeto Java que simula um sistema de pedidos de restaurante, aplicando os conceitos de **herança**, **abstração** e **interfaces**.

---

## 🗺️ Visão Geral

```
Pedido (abstrata)
├── PedidoRetirada → sem taxa
├── PedidoDelivery → +R$10  → implementa Pagamento
└── PedidoMesa     → +10%   → implementa Pagamento
```

---

## 📁 Estrutura do Projeto

```
src/
└── restaurante/
    ├── Main.java
    ├── Pedido.java
    ├── Pagamento.java
    ├── PedidoDelivery.java
    ├── PedidoRetirada.java
    └── PedidoMesa.java
```

---

## 📄 Explicação de Cada Arquivo

### `Pedido.java` — A base de tudo

```java
public abstract class Pedido {
    protected String cliente;
    protected double valor;
```

- `abstract` → classe **incompleta**, serve apenas como molde. Não pode ser instanciada diretamente
- `protected` → os atributos são acessíveis pelas classes filhas

```java
    public Pedido(String cliente, double valor) {
        this.cliente = cliente;
        this.valor = valor;
    }
```

- **Construtor**: chamado ao criar um pedido. Recebe o nome do cliente e o valor e salva nos atributos

```java
    public void exibirPedido() {
        System.out.println("Cliente: " + cliente);
        System.out.println("Total: R$" + calcularTotal());
    }

    public abstract double calcularTotal();
}
```

- `exibirPedido()` → método **concreto**, já tem implementação
- `calcularTotal()` → método **abstrato**, cada classe filha é obrigada a criar sua própria versão

---

### `Pagamento.java` — Um contrato

```java
public interface Pagamento {
    void realizarPagamento();
}
```

- Uma **interface** funciona como um contrato: quem a implementar é obrigado a ter o método `realizarPagamento()`
- `PedidoRetirada` **não** implementa essa interface, pois retirada não tem pagamento online

---

### `PedidoRetirada.java`

```java
public class PedidoRetirada extends Pedido {

    public PedidoRetirada(String cliente, double valor) {
        super(cliente, valor);
    }

    @Override
    public double calcularTotal() {
        return valor; // sem taxa
    }
}
```

- `extends Pedido` → herda tudo de `Pedido`
- Sem taxa adicional — retorna o valor original

---

### `PedidoDelivery.java`

```java
public class PedidoDelivery extends Pedido implements Pagamento {

    @Override
    public double calcularTotal() {
        return valor + 10; // taxa fixa de R$10
    }

    @Override
    public void realizarPagamento() {
        System.out.println("Pagamento do delivery de R$" + calcularTotal() + " processado.");
    }
}
```

- Herda `Pedido` **e** assina o contrato `Pagamento`
- Taxa fixa de **+R$10**

---

### `PedidoMesa.java`

```java
public class PedidoMesa extends Pedido implements Pagamento {

    @Override
    public double calcularTotal() {
        return valor * 1.10; // +10% de taxa
    }

    @Override
    public void realizarPagamento() {
        System.out.println("Pagamento da mesa de R$" + calcularTotal() + " processado.");
    }
}
```

- Taxa de **+10%** sobre o valor
- Também implementa `Pagamento`

---

### `Main.java` — Onde tudo acontece

```java
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
```

- Cria um objeto de cada tipo, passando nome e valor
- Chama `exibirPedido()` em todos e `realizarPagamento()` nos que implementam `Pagamento`

---

## 🖥️ Saída Esperada

```
=== Delivery ===
Cliente: Ana
Valor base: R$50.0
Total: R$60.0
Pagamento do delivery de R$60.0 processado.

=== Retirada ===
Cliente: Bruno
Valor base: R$30.0
Total: R$30.0

=== Mesa ===
Cliente: Carlos
Valor base: R$80.0
Total: R$88.0
Pagamento da mesa de R$88.0 processado.
```

---

## 💡 Conceitos Utilizados

| Conceito | O que faz |
|---|---|
| **Herança** | Classes filhas reutilizam o código do pai (`Pedido`) |
| **Abstração** | Força as filhas a implementarem `calcularTotal()` |
| **Interface** | Força `Delivery` e `Mesa` a terem `realizarPagamento()` |
| **Pacote** | `package restaurante` organiza todas as classes no mesmo módulo |
