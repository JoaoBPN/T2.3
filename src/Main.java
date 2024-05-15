import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // A principio, a unica consideração é que o usuário escrvera corretamente o sistema de busca de pontos e circulos ou seja.
        // Atributo = valor, eg: nome = P1 ou X = 1 ou Y = 2.5 ou Raio = 3.14, letras maiusculas ou minusculas não importam para o parametro mas importam para o valor

        Scanner scanner = new Scanner(System.in);

        List<Circulo> circulos = new ArrayList<>();
        List<Ponto> pontos = new ArrayList<>();
        List<Circulo> buscaCirculos = new ArrayList<>();
        List<Ponto> buscaPontos = new ArrayList<>();

        int opcao = -1;

        while(opcao!= 0){
            System.out.println(""" 
                    Selecione uma opção:
                    1 - Operar com Pontos
                    2 - Operar com Circulos
                    3 - Exibir todos os pontos e Circulos
                    0 - Sair""");

            opcao = scanner.nextInt();
            scanner.nextLine(); // para limpar o buffer

            switch(opcao){
                case 0:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    int opcaoInterna = -1;
                    while(opcaoInterna != 0) {

                        System.out.println("""
                                Selecione uma opção:
                                1 - Adicionar Ponto
                                2 - Remover Ponto
                                3 - Buscar Ponto
                                4 - Exibir todos os Pontos
                                0 - Voltar ao menu principal""");

                        opcaoInterna = scanner.nextInt();
                        scanner.nextLine(); // para limpar o buffer

                        switch(opcaoInterna){
                            case 0:
                                System.out.println("Voltando...");
                                break;
                            case 1:

                            default:
                                System.out.println("Opção inválida");
                                break;
                        }
                    }
                default:
                    System.out.println("Opção inválida");
                    break;
            }


        }
    }
}