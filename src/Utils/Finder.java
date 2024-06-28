package Utils;

import Models.Findable;

public class Finder {
    public static int find(Findable[] findables){

        String[] methods = getFinalString(findables);

        if(methods == null){
            return -1;
        }

        int methodsAmmount = ArrayUtility.ammountOfNotNullObjects(methods);

        if(methodsAmmount == 0){
            return -1;
        }

        int fulfilledMethods;

        String[] parameters = new String[methods.length];
        String[] values = new String[methods.length];

        for(int i = 0;i < methods.length;i++){
            if(methods[i] != null){
                String[] parts = methods[i].split(" ");
                parameters[i] = parts[0];
                values[i] = parts[1];
            }
        }

        int[] foundPosition = new int[findables.length];
        int foundObjects = 0;

        for (int i = 0; i < findables.length; i++) {
            fulfilledMethods = 0;
            for (int j = 0; j < parameters.length; j++) {
                if(parameters[j] != null && findables[i] != null) {
                    if (findables[i].hasSameParameter(parameters[j], values[j])) {
                        fulfilledMethods++;
                    }
                }
            }
            foundPosition[i] = 0;
            if(fulfilledMethods == methodsAmmount){
                foundObjects++;
                foundPosition[i] = 1;
            }
        }

        if(foundObjects == 1){
            for (int i = 0; i < foundPosition.length; i++) {
                if(foundPosition[i] == 1){
                    return i;
                }
            }
        }
        if(foundObjects > 1){
            System.out.println("Mais de um resultado encontrado");
            while(true){
                for (int i = 0; i < findables.length; i++) {
                 if(foundPosition[i] == 1){
                     System.out.println(i+1 + " ---> " +findables[i]);
                 }
                }
                System.out.println("Selecione o número correspondente");
                int option = SuperScanner.getInteger() - 1;

                if(foundPosition[option] == 1){
                    return option;
                }

                System.out.println("Algo de errado aconteceu, tente novamente");
            }
        }

        return -1;

    }

    private static String[] getFinalString(Findable[] findables){
        System.out.println("Informe os parametros");
        String parameters = SuperScanner.getString();
        parameters = parameters.replaceAll("="," ").replaceAll(" +"," ");
        String[] parts = parameters.split(" ");
        if(parts.length % 2 != 0){
            return null;
        }
        int position = ArrayUtility.getAny(findables);
        return findables[position].ownMethods(parts);
    }

}
