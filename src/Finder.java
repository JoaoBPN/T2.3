import java.util.Scanner;

public class Finder {

    static Scanner scanner = new Scanner(System.in);

    public static int find(Findable[] findables){

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

        for (int i = 0; i < findables.length; i++) {
            fulfilledMethods = 0;
            for (int j = 0; j < parameters.length; j++) {
                if(parameters[j] != null) {
                    if (findables[i].isSimilar(parameters[j], values[j])) {
                        fulfilledMethods++;
                    }
                }
            }
            if(fulfilledMethods == methodsAmmount){
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
        String[] methods = new String[4];
        for(int i = 0;i < parts.length;i+=2){
            switch (parts[i]) {
                case "nome" -> methods[0] = parts[i] + " " + parts[i + 1];
                case "x" -> methods[1] = parts[i] + " " + parts[i + 1];
                case "y" -> methods[2] = parts[i] + " " + parts[i + 1];
                case "raio" -> methods[3] = parts[i] + " " +parts[i + 1];
            }
        }
        return methods;
    }

}
