import Models.Circle;
import Models.Dot;
import Utils.ArrayUtility;
import Utils.Finder;
import Utils.SuperScanner;

public class Main{

    private static final int maxDotsSize = 10;
    private static final int maxCirclesSize = 2;

    private static final Dot[] dots = new Dot[maxDotsSize];
    private static final Circle[] circles = new Circle[maxCirclesSize];

    public static void main(String[] args){
        mainSwitch();
    }

    private static void mainSwitch(){
        int option = -1;

        while(option != 3){
            option = mainMenu();

            switch(option){
                case 1:
                    dotSwitch();
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
        return SuperScanner.getInteger();
    }

    private static int dotMenu(){
        System.out.println("""
                Escolha uma operação:
                1 - Criar ponto
                2 - Remover ponto
                3 - Listar pontos
                4 - Calcular distancia entre pontos
                5 - Voltar ao menu principal
                """);
        return SuperScanner.getInteger();
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
        return SuperScanner.getInteger();
    }

    private static void dotSwitch(){
        int option = -1;

        while(option != 5){
            option = dotMenu();

            switch(option){
                case 1:
                    createDot();
                    break;
                case 2:
                    removeDot();
                    break;
                case 3:
                    showDots();
                    break;
                case 4:
                    distanceBetweenDots();
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

    private static void createDot(){
        Dot dot = createInstanceOfDots();
        ArrayUtility.addObject(dot, dots);
    }

    private static void removeDot(){
        int position = Finder.find(dots);
        ArrayUtility.removeObject(position, dots);
    }

    private static void showDots(){
        for(Dot dot : dots){
            if(dot != null) {
                System.out.println(dot);
            }
        }
    }

    private static void distanceBetweenDots(){
        int position = Finder.find(dots);
        int position2 = Finder.find(dots);
        if(ArrayUtility.isAInvalidPosition(position, dots) || ArrayUtility.isAInvalidPosition(position2, dots)){
            System.out.println("Posição invalida encontrada,não foi possível calcular");
            return;
        }
        double distance = dots[position].distanceBeetweenDots(dots[position2]);
        System.out.println("Distancia = "+distance);
    }

    private static Dot createInstanceOfDots(){
        System.out.println("Informe o nome do ponto: ");
        String name = SuperScanner.getString();
        System.out.println("Informe a coordenada x do ponto");
        double x = SuperScanner.getDouble();
        System.out.println("Informe a coordenada y do ponto");
        double y = SuperScanner.getDouble();
        return new Dot(name.trim(),x,y);
    }

    private static void circleSwitch(){
        int option = -1;

        while(option != 8){

            option = circleMenu();

            switch(option){
                case 1:
                    createCircle();
                    break;
                case 2:
                    removeCircle();
                    break;
                case 3:
                    showCircles();
                    break;
                case 4:
                    circleDiameter();
                    break;
                case 5:
                    circleCircumference();
                    break;
                case 6:
                    circleArea();
                    break;
                case 7:
                    circleInterceptation();
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

    private static void createCircle(){
        Circle circle = createInstanceOfCircle();
        ArrayUtility.addObject(circle,circles);
    }

    private static void removeCircle(){
        int position = Finder.find(circles);
        ArrayUtility.removeObject(position,circles);
    }

    private static void showCircles(){
        for(Circle circle:circles){
            if(circle != null){
                System.out.println(circle);
            }
        }
    }

    private static void circleDiameter(){
        int position = Finder.find(circles);
        if(ArrayUtility.isAInvalidPosition(position, circles)){
            System.out.println("Posição invalida encontrada,não foi possível calcular");
            return;
        }
        double diameter = circles[position].getDiameter();
        System.out.println("Diametro = "+diameter);
    }

    private static void circleCircumference(){
        int position = Finder.find(circles);
        if(ArrayUtility.isAInvalidPosition(position, circles)){
            System.out.println("Posição invalida encontrada,não foi possível calcular");
            return;
        }
        double circumference = circles[position].getCircumference();
        System.out.println("Circumferencia = "+circumference);
    }

    private static void circleArea(){
        int position = Finder.find(circles);
        if(ArrayUtility.isAInvalidPosition(position, circles)){
            System.out.println("Posição invalida encontrada,não foi possível calcular");
            return;
        }
        double area = circles[position].getArea();
        System.out.println("Area ="+area);
    }

    private static void circleInterceptation(){
        int position = Finder.find(circles);
        int position2 = Finder.find(circles);
        if(ArrayUtility.isAInvalidPosition(position, circles) || ArrayUtility.isAInvalidPosition(position2, circles)){
            return;
        }
        boolean itDoes = circles[position].shareDots(circles[position2]);
        if(itDoes){
            System.out.println("Interceptam");
            return;
        }
        System.out.println("Não interceptam");
    }

    private static Circle createInstanceOfCircle(){
        System.out.println("Informe o nome do circulo: ");
        String name = SuperScanner.getString();
        System.out.println("Informe o ponto central: ");
        int position = Finder.find(dots);
        Dot centralDot = dots[position];
        System.out.println("Informe o raio do circulo: ");
        double radius = SuperScanner.getDouble();
        return new Circle(name.trim(), centralDot,radius);
    }

}