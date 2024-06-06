import java.util.Arrays;

public class ArrayUtility {

    public static void addIn(Object it, Object[] them){

        if(thisArrayIsFull(them)){
            System.out.println("O array esta cheio, não é possível adicionar");
        }

        for (int i = 0; i < them.length; i++) {
            if(them[i]==null){
                them[i] = it;
                return;
            }
        }
    }

    public static void removeObject(int position,Object[] objects){
        objects[position] = null;
        adjustArray(objects);
    }

    public static void adjustArray(Object[] objects){
        Object[] adjuster = new Object[objects.length];

        for(Object object:objects){
            if(object != null){
                addIn(object,adjuster);
            }
        }

        Arrays.fill(objects,null);

        for(Object object: adjuster){
            if(object != null){
                addIn(object,objects);
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

}
