package Utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SuperScanner {

    static Scanner scanner = new Scanner(System.in);

    public static int getInteger(){
        while(true) {
            try {
                int iVar = scanner.nextInt();
                scanner.nextLine();
                return iVar;
            } catch (InputMismatchException e) {
                System.out.println("Tipo não atendido, tente novamente");
                scanner.nextLine();
            }
        }
    }

    public static double getDouble(){
        while(true) {
            try {
                double dVar = scanner.nextDouble();
                scanner.nextLine();
                return dVar;
            } catch (InputMismatchException e) {
                System.out.println("Tipo não atendido, tente novamente");
                scanner.nextLine();
            }
        }
    }

    public static String getString(){
        String str = null;
        while(str == null){
            str = scanner.nextLine();
            if(str == null){
                System.out.println("Insira uma string não nula");
            }
        }
        return str;
    }

}
