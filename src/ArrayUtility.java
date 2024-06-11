import java.util.Arrays;

public class ArrayUtility {

    public static void addObject(Object object, Object[] objects){

        if(thisArrayIsFull(objects)){
            System.out.println("O array esta cheio, não é possível adicionar");
            return;
        }

        for (int i = 0; i < objects.length; i++) {
            if(objects[i]==null){
                objects[i] = object;
                return;
            }
        }
    }

    public static void removeObject(int position,Object[] objects){
        objects[position] = null;
        agroupObjects(objects);
    }

    public static void agroupObjects(Object[] objects){
        Object[] adjuster = new Object[objects.length];

        for(Object object:objects){
            if(object != null){
                addObject(object,adjuster);
            }
        }

        Arrays.fill(objects,null);

        for(Object object: adjuster){
            if(object != null){
                addObject(object,objects);
            }
        }

    }

    public static boolean thisArrayIsFull(Object[] array){
        for(Object element:array){
            if(element == null) {
                return false;
            }
        }
        return true;
    }

    public static int nonNullObjects(Object[] array){
        int cont = 0;
        for(Object element:array){
            if(element != null){
                cont++;
            }
        }
        return cont;
    }
}
