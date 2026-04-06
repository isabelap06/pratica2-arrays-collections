import java.util.ArrayList;

public class Fatura {
    private ArrayList<Item> itens;

    public Fatura() {
        itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void removerItem(int codigoProduto) {
        itens.removeIf(item -> item.getProduto().getCodigo() == codigoProduto);
    }

    public Item buscarItem(int codigoProduto) {
        for (Item item : itens) {
            if (item.getProduto().getCodigo() == codigoProduto) {
                return item;
            }
        }
        return null;
    }

    public double calcularTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getValorTotal();
        }
        return total;
    }

    public void mostrarFatura() {
        if (itens.isEmpty()) {
            System.out.println("Fatura vazia.");
            return;
        }

        for (Item item : itens) {
            System.out.println("Produto: " + item.getProduto().getNome());
            System.out.println("Quantidade: " + item.getQuantidade());
            System.out.println("Total: " + item.getValorTotal());
            System.out.println("----------------------");
        }

        System.out.println("TOTAL DA FATURA: " + calcularTotal());
    }
}
