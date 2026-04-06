import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Produtos fixos (como o enunciado pede)
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Arroz", 1, 20.0));
        produtos.add(new Produto("Feijão", 2, 10.0));
        produtos.add(new Produto("Macarrão", 3, 5.0));

        Fatura fatura = new Fatura();

        int opcao;

        do {
            System.out.println("\n1 - Comprar");
            System.out.println("2 - Ver Fatura");
            System.out.println("3 - Excluir Item");
            System.out.println("4 - Alterar Item");
            System.out.println("5 - Finalizar");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("\nProdutos disponíveis:");
                    for (Produto p : produtos) {
                        System.out.println(p.getCodigo() + " - " + p.getNome() + " - R$" + p.getPreco());
                    }

                    System.out.print("Digite o código: ");
                    int codigo = sc.nextInt();

                    System.out.print("Quantidade: ");
                    int quantidade = sc.nextInt();

                    Produto escolhido = null;

                    for (Produto p : produtos) {
                        if (p.getCodigo() == codigo) {
                            escolhido = p;
                        }
                    }

                    if (escolhido != null) {
                        fatura.adicionarItem(new Item(escolhido, quantidade));
                        System.out.println("Item adicionado!");
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;

                case 2:
                    fatura.mostrarFatura();
                    break;

                case 3:
                    System.out.print("Código do produto para remover: ");
                    int codRemover = sc.nextInt();
                    fatura.removerItem(codRemover);
                    break;

                case 4:
                    System.out.print("Código do produto para alterar: ");
                    int codAlterar = sc.nextInt();

                    Item item = fatura.buscarItem(codAlterar);

                    if (item != null) {
                        System.out.print("Nova quantidade: ");
                        int novaQtd = sc.nextInt();
                        item.setQuantidade(novaQtd);
                    } else {
                        System.out.println("Item não encontrado!");
                    }
                    break;

                case 5:
                    System.out.println("Finalizando...");
                    fatura.mostrarFatura();
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 5);

        sc.close();
    }
}
