import java.util.Scanner;

public class Main {
    private static String tituloLivro = "";
    private static String autorLivro = "";
    private static double  precoLivro = 0;
    private static int qtdLivro = 0;
    private static double valorTotal = 0;


    public static void main(String[]args) {
        Scanner leitura = new Scanner(System.in);

        int opcaoMenu;
        System.out.println("Seja Bem-Vindo");
        System.out.println("==========================");
        do {
            System.out.println("""
                    
                    ********** Menu **********
                    Adicione um Livro:  (DIGITE ---> [1])
                    Definir quantidade para compra:  (DIGITE ---> [2])
                    Exibir informações do Livro:  (DIGITE ---> [3])
                    Calcular Valor total da compra:  (DIGITE ---> [4])
                    Altere ou remova o livro:  (DIGITE ---> [5])
                    Sair do menu:  (DIGITE ---> [6])
                                        
                    """);

             opcaoMenu = leitura.nextInt();

             if (opcaoMenu == 1) {
              adicionarLivro();
             }
             else if (opcaoMenu == 2) {
                 definirQnt();

             }
             else if (opcaoMenu == 3) {
                 infoLivro();

             }
             else if (opcaoMenu == 4) {
                 calcularTotal();

             }
             else if (opcaoMenu == 5) {
                 alterarRemover();

             }
             else if (opcaoMenu == 6) {
                 System.out.println("Encerrando Amigão!!!");

             }else {
                 System.out.println("Opção errada Sacana!");
             }
        }while(opcaoMenu != 6);

}


    private static void adicionarLivro() {
        Scanner leitura = new Scanner(System.in);
        System.out.print("Titulo do Livro: ");
        tituloLivro = leitura.nextLine();
        System.out.print("Autor do Livro: ");
        autorLivro = leitura.nextLine();
        System.out.print("Preço do Livro: ");
        precoLivro = leitura.nextDouble();
        validaPreco();

    }

    private static void validaPreco() {
        Scanner leitura = new Scanner(System.in);
        if (precoLivro <= 0) {
            do {
                System.out.print("Preço menor ou Igual a zero inserido, por favor inserir um valor válido: ");
                precoLivro = leitura.nextDouble();
            } while (precoLivro <= 0);
        }
    }

    private static void definirQnt() {
        Scanner leitura = new Scanner(System.in);
        if (precoLivro == 0) {
            System.out.println("Livro não cadastrado!");
        } else {
            System.out.print("Quantidade de exemplares: ");
            qtdLivro = leitura.nextInt();
            validaQtd();
        }
    }

    private static void validaQtd() {
        Scanner leitura = new Scanner(System.in);
        if (qtdLivro <= 0) {
            do {
                System.out.print("Quantidade menor ou igual a zero, por favor inserir um valor válida: ");
                qtdLivro = leitura.nextInt();
            } while (qtdLivro <= 0);
        }
    }

    private static void infoLivro() {
        if (precoLivro == 0) {
            System.out.println("Livro não cadastrado!");
        } else {
            System.out.println("Titulo do Livro: " + tituloLivro);
            System.out.println("Autor do Livro: " + autorLivro);
            System.out.println("Preço do Livro: " + precoLivro);
            System.out.println("Quantidade de exemplares: " + qtdLivro);
        }
    }



    private static void calcularTotal() {
        if (precoLivro == 0) {
            System.out.println("Livro não cadastrado!");
        } else {
            valorTotal = qtdLivro * precoLivro;
            System.out.println("Valor total da compra: " + qtdLivro + " X R$" + precoLivro + " = R$" + valorTotal);
        }
    }

    private static void alterarRemover() {
        Scanner leitura = new Scanner(System.in);
        int opcaoMenu;
        if (precoLivro == 0) {
            System.out.println("Livro não cadastrado!");
        } else {
            System.out.println("""
                        Alterar Informações do Livro:  (DIGITE ---> [1])
                        Excluir Livro:  (DIGITE ---> [2])
                    """);
            opcaoMenu = leitura.nextInt();
            if (opcaoMenu == 1) {
                adicionarLivro();
            } else if (opcaoMenu == 2) {
                tituloLivro = "";
                autorLivro = "";
                precoLivro = 0;
                qtdLivro = 0;
                valorTotal = 0;
                System.out.println("Cadastro removido!");
            }
        }
    }
}