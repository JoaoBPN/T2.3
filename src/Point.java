import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Point implements Findable{

    private String name;
    private double x;
    private double y;

    public Point(String name,double x,double y){
        setName(name);
        setX(x);
        setY(y);
    }

    public void setName(String nome){
        this.name = nome;
    }

    public String getName(){
        return name;
    }

    public void setX(double x){
        this.x = x;
    }

    public double getX(){
        return x;
    }

    public void setY(double y){
        this.y = y;
    }

    public double getY(){
        return y;
    }

    public double calculateDistanceBeetweenPoints(Point point){
        return sqrt(pow(getX()-point.getX(),2) + pow(getY()- point.getY(),2));
    }

    @Override
    public String toString(){
        return getName()+" = "+"["+getX()+";"+getY()+"]";

    }

    @Override
    public boolean isSimilar(String parameter,String value){

        if(parameter.equals("nome")){
            if(getName().equals(value)){
                return true;
            }
        }
        if(parameter.equals("x")){
            if(getX() == Double.parseDouble(value)){
                return true;
            }
        }
        if(parameter.equals("y")){
            if(getY() == Double.parseDouble(value)){
                return true;
            }
        }
        return false;
    }

}
