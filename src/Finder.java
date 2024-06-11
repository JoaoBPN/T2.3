import java.util.Scanner;
public class Finder {
    public static final int ammoutOfDiferentMethods = 4;
    static Scanner scanner = new Scanner(System.in);

    public static int find(Findable[] findables){

        String[] methods = getFinalString();

        int methodsAmmount = ArrayUtility.nonNullObjects(methods);
        int fulfilledMethods;

        String[] parameters = new String[methods.length/2];
        String[] values = new String[methods.length/2];

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
                    if (findables[i].sameParameter(parameters[j], values[j])) {
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

    private static String[] getFinalString(){
        System.out.println("Informe os parametros");
        String parameters = scanner.nextLine();
        parameters = parameters.toLowerCase().replaceAll("="," ").replaceAll(" +"," ");
        String[] parts = parameters.split(" ");
        String[] methods = new String[ammoutOfDiferentMethods];
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
