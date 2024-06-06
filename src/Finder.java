import java.util.Scanner;

public class Finder {

    static Scanner scanner = new Scanner(System.in);

    public static int findPoint(Point[] points){

        String[] methods = getFinalString();

        int methodsAmmount = 0;
        int fulfilledMethods;

        for(String method:methods){
            if(method != null){
                methodsAmmount++;
            }
        }

        String[] parameters = new String[methods.length];
        String[] values = new String[methods.length];

        for(int i = 0;i < methods.length;i++){
            if(methods[i] != null){
                String[] parts = methods[i].split(" ");
                parameters[i] = parts[0];
                values[i] = parts[1];
            }
        }

        int counter;

        for(int i = 0;i < points.length;i++) {

            fulfilledMethods = 0;
            counter = 0;
            if(parameters[counter] != null) {
                if (parameters[counter].equals("nome") && points[i].getName().equals(values[counter])) {
                    fulfilledMethods++;
                }
            }
            counter++;
            if(parameters[counter] != null) {
                if (parameters[counter].equals("x") && (points[i].getX() == Double.parseDouble(values[counter]))) {
                    fulfilledMethods++;
                }
            }
            counter++;
            if(parameters[counter] != null) {
                if (parameters[counter].equals("y") && (points[i].getY() == Double.parseDouble(values[counter]))) {
                    fulfilledMethods++;
                }
            }

            if (fulfilledMethods == methodsAmmount) {
                return i;
            }

        }

        return -1;

    }


    public static String[] getFinalString(){
        System.out.println("Informe os parametros");
        String parameters = scanner.nextLine();
        parameters = parameters.toLowerCase().replaceAll("="," ").replaceAll(" +"," ");
        String[] parts = parameters.split(" ");
        String[] methods = new String[3];
        for(int i = 0;i < parts.length;i+=2){
            switch (parts[i]) {
                case "nome" -> methods[0] = parts[i] + " " + parts[i + 1];
                case "x" -> methods[1] = parts[i] + " " + parts[i + 1];
                case "y" -> methods[2] = parts[i] + " " + parts[i + 1];
            }
        }

        return methods;
    }

}
