import Modelos.Forma;

import java.util.Scanner;

public class Busca{
    public static void buscaForma(Forma[] formas){

        String metodos = identificaMetodos(pegaMetodos());

        if(metodos.isEmpty()){
            return;
        }

        String[] partes = metodos.split("\n");

    }

    private static String pegaMetodos(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite os parametros");
        return scanner.nextLine();

    }

    private static String identificaMetodos(String metodos){

        metodos = metodos.trim().toLowerCase().replaceAll("="," ").replaceAll(" +"," ");

        String[] partes = metodos.split(" ");

        String[] metodosEmLinhas = new String[4];

        int cont = 0;

        for(int i = 0;i < partes.length;i+=2){
            if(partes[i] != null && partes[i+1] != null ) {
                metodosEmLinhas[cont] = partes[i] + "=" + partes[i + 1];
            }
            cont++;
        }

        if(validaOperacoes(metodosEmLinhas)){

            StringBuilder metodosBuilder = new StringBuilder();

            cont = 0;
            for (String metodosEmLinha : metodosEmLinhas) {
                if(metodosEmLinha != null) {
                    if (cont > 0) {
                        metodosBuilder.append("\n").append(metodosEmLinha);
                    }
                    if (cont == 0) {
                        metodosBuilder.append(metodosEmLinha);
                    }
                    cont++;
                }
            }

            metodos = metodosBuilder.toString();

            return metodos;
        }

        return "";

    }

    private static boolean validaOperacoes(String[] metodosEmLinhas){

        if(!metodosUnicos(metodosEmLinhas)){
            System.out.println("Metodos repetidos, encerrando operação");
            return false;
        }

        if(!metodosValidos(metodosEmLinhas)){
            System.out.println("Metodos invalidos, encerrando operação");
            return false;
        }

        if(!valoresValidos(metodosEmLinhas)){
            System.out.println("Valores invalidos, encerrando operação");
            return false;
        }

        return true;

    }

    private static boolean metodosUnicos(String[] metodosEmLinhas){
        for (int i = 0; i < metodosEmLinhas.length; i++) {
            for (int j = i+1; j < metodosEmLinhas.length; j++) {
                if(!(metodosEmLinhas[i] == null || metodosEmLinhas[j] == null)){
                    if(metodosEmLinhas[i].split("=")[0].equals(metodosEmLinhas[j].split("=")[0])){
                        return false;
                    }
                }
            }

        }
        return true;
    }

    private static boolean metodosValidos(String[] metodosEmLinhas){
        for(String m:metodosEmLinhas){
            if(m != null){
                String metodo = m.split("=")[0];
                if(!(metodo.equals("nome")||metodo.equals("x")||metodo.equals("y")||metodo.equals("raio"))){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean valoresValidos(String[] metodosEmLinhas){
        for(String m: metodosEmLinhas){
            if(m != null){
                if(!m.split("=")[0].equals("nome")){
                    try{
                        String o = m.split("=")[1];
                        Double.parseDouble(o);

                    }catch (NumberFormatException E){
                        return false;
                    }
                }
            }

        }
        return true;
    }
}

