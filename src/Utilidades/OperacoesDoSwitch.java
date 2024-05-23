package Utilidades;

import Modelos.Circulo;
import Modelos.Ponto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OperacoesDoSwitch {

    public static int menuPrincipal(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                Escolha uma opção:
                1 - Operações com pontos
                2 - Operações com circulos
                0 - Encerrar o programa
                """);

        int opcao;
        try {
            opcao = scanner.nextInt();
            scanner.nextLine();  // limpa o buffer
        }catch (InputMismatchException e){
            opcao = -1;
            scanner.nextLine();
        }

        return opcao;
    }

    public static int menuPontos(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                            Escoha uma opção:
                            1 - Criar ponto
                            2 - Remover ponto
                            3 - Listar pontos
                            4 - Distância entre pontos
                            0 - voltar
                            """);

        int opcao;
        try {
            opcao = scanner.nextInt();
            scanner.nextLine(); //limpa o buffer
        }catch (InputMismatchException e){
            opcao = -1;
            scanner.nextLine();
        }


        return opcao;
    }

    public static int menuCirculos(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                            Escolha uma opção:
                            1 - Criar circulo
                            2 - Remover circulo
                            3 - Listar circulos
                            4 - Calcular diâmetro
                            5 - Calcular circunferência
                            6 - Calcular área
                            7 - Saber se um circulo intercepta outro
                            """);

        int opcao;
        try {
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa o buffer
        }catch(InputMismatchException e){
            opcao = -1;
            scanner.nextLine();
        }

        return opcao;
    }

    public static Ponto criaPonto(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do ponto ou precione enter para pular");
        String nome = scanner.nextLine();
        System.out.println("Digite a coordenada x do ponto");
        double x = scanner.nextDouble();
        System.out.println("Digite a coordenada y do ponto");
        double y = scanner.nextDouble();
        return new Ponto(nome,x,y);

    }

    public static Circulo criaCirculo(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do circulo ou precione enter para pular");
        String nome = scanner.nextLine();
        System.out.println("Digite a coordenada x do ponto central");
        double x = scanner.nextDouble();
        System.out.println("Digite a coordenada y do ponto central");
        double y = scanner.nextDouble();
        System.out.println("Digite o raio");
        double raio = scanner.nextDouble();

        return new Circulo(nome,new Ponto(x,y),raio);
    }
}
