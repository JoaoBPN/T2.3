package Utilidades;

import Modelos.Forma;
import java.util.Arrays;

public class ArraysUtils {

    public static void compactaArray(Forma[] formas){

        Forma[] transfere = new Forma[formas.length];

        int j = 0;
        for (Forma forma : formas) {
            if (forma != null) {
                transfere[j] = forma;
                j++;

            }

        }

        Arrays.fill(formas,null);
        System.arraycopy(transfere,0,formas,0,formas.length);

    }

    public static void imprimeArray(Object[] objs){
        for(Object o:objs){
            if(o != null){
                System.out.println(o);
            }
        }
    }

    public static boolean arrayIsFull(Object[] objs){
        int cont = 0;
        for(Object o:objs){
            if(o != null){
                cont++;
            }
        }

        return objs.length == cont;

    }

}
