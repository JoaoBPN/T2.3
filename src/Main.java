import java.util.Scanner;
public class Main{

    private static final Scanner scanner = new Scanner(System.in);
    private static final int maxPointsSize = 10;
    // (por enquanto não esta sendo usado) private static final int maxCirclesSize = 2;

    private static final Point[] points = new Point[maxPointsSize];


    public static void main(String[] args){
        mainSwitch();
    }

    private static void mainSwitch(){
        int option = -1;

        while(option != 3){
            option = mainMenu();

            switch(option){
                case 1:
                    pointSwitch();
                    break;
                case 2:
                    circleSwitch();
                    break;
                case 3:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Operação invalida");
                    break;

            }
        }
    }

    private static int mainMenu(){
        System.out.println("""
                Escolha uma operação:
                1 - Operações com pontos
                2 - Operações com circulos
                3 - Encerrar o programa
                """);
        int option = scanner.nextInt();
        scanner.nextLine(); // limpa o buffer;
        return option;
    }


    private static void pointSwitch(){
        int option = -1;

        while(option != 5){
            option = pointMenu();

            switch(option){
                case 1:
                    createPoint();
                    break;
                case 2:
                    removePoint();
                    break;
                case 3:
                    showPoints();
                    break;
                case 4:
                    distanceBetweenPoints();
                    break;
                case 5:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Operação invalida");
                    break;
            }
        }
    }

    private static int pointMenu(){
        System.out.println("""
                Escolha uma operação:
                1 - Criar ponto
                2 - Remover ponto
                3 - Listar pontos
                4 - Calcular distancia entre pontos
                5 - Voltar ao menu principal
                """);

        int option = scanner.nextInt();
        scanner.nextLine(); //limpa o buffer;
        return option;
    }

    private static Point createInstaceOfPoint(){
        System.out.println("Informe o nome do ponto: ");
        String name = scanner.nextLine();
        System.out.println("Informe a coordenada x do ponto");
        double x = scanner.nextDouble();
        System.out.println("Informe a coordenada y do ponto");
        double y = scanner.nextDouble();
        return new Point(name,x,y);
    }

    private static void createPoint(){
        Point point = createInstaceOfPoint();
        ArrayUtility.addIn(point,points);
    }

    private static void removePoint(){
        int position = Finder.findPoint(points);
        ArrayUtility.removeObject(position,points);
    }

    private static void showPoints(){
        for(Point point:points){
            if(point != null) {
                System.out.println(point);
            }
        }
    }

    private static void distanceBetweenPoints(){
        int position = Finder.findPoint(points);
        int position2 = Finder.findPoint(points);
        double distance = points[position].calculateDistanceBeetweenPoints(points[position2]);
        System.out.println("Distancia = "+distance);
    }

    private static void circleSwitch(){
        int option = -1;

        while(option != 8){

            option = circleMenu();

            switch(option){
                case 1:
                    System.out.println("Operação de criar circulo");
                    break;
                case 2:
                    System.out.println("Operação de remover circulo");
                    break;
                case 3:
                    System.out.println("Operação de listar circulos");
                    break;
                case 4:
                    System.out.println("Operação de calcular diametro");
                    break;
                case 5:
                    System.out.println("Operação de calcular circunferencia");
                    break;
                case 6:
                    System.out.println("Operação de calcular area");
                    break;
                case 7:
                    System.out.println("Operação que informa se um circulo intercepta outro");
                    break;
                case 8:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Operação invalida");
                    break;
            }
        }
    }

    private static int circleMenu(){
        System.out.println("""
                Escolha uma operação:
                1 - Criar circulos
                2 - Remover circulo
                3 - Listar circulos
                4 - Calcular diametro
                5 - Calcular circunferencia
                6 - Calcular area
                7 - Saber se um circulo intercepta outro
                8 - Voltar ao menu principal
                """);
        int option = scanner.nextInt();
        scanner.nextLine(); //limpa o buffer;
        return option;
    }

}