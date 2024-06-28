package Utils;

import java.util.Arrays;

public class ArrayUtility {

    public static void addObject(Object object, Object[] objects){
        if(isThisArrayIsFull(objects)){
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
        if(isAInvalidPosition(position, objects)){
            System.out.println("Posição invalida,não foi possível remover");
            return;
        }
        objects[position] = null;
        sortObjects(objects);
    }

    public static void sortObjects(Object[] objects){
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

    public static boolean isThisArrayIsFull(Object[] array){
        for(Object element:array){
            if(element == null) {
                return false;
            }
        }
        return true;
    }

    public static int ammountOfNotNullObjects(Object[] array){
        int count = 0;
        for(Object element:array){
            if(element != null){
                count++;
            }
        }
        return count;
    }

    public static int getAny(Object[] array){
        int count = 0;
        for(Object element:array){
            if(element != null){
                return count;
            }
            count++;
        }
        return -1;
    }

    public static boolean isAInvalidPosition(int position, Object[] array){
        return position < 0 || position >= array.length;
    }

}
