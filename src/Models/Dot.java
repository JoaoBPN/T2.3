package Models;

import static java.lang.Math.*;

public class Dot implements Findable {

    private String name;
    private double x;
    private double y;

    public Dot(String name, double x, double y){
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

    public double distanceBeetweenDots(Dot dot){
        return sqrt(pow(getX()- dot.getX(),2) + pow(getY()- dot.getY(),2));
    }

    @Override
    public String toString(){
        return getName()+" = "+"["+getX()+";"+getY()+"]";
    }

    @Override
    public String[] ownMethods(String[] parts){
        int maxParameterAmmout = 3;
        String[] methods = new String[maxParameterAmmout];
        for(int i = 0;i < parts.length;i+=2){
            switch (parts[i].toLowerCase()) {
                case "nome" -> methods[0] = parts[i] + " " + parts[i + 1];
                case "x" -> methods[1] = parts[i] + " " + parts[i + 1];
                case "y" -> methods[2] = parts[i] + " " + parts[i + 1];
                default -> {
                    return null;
                }
            }
        }
        return methods;
    }

    @Override
    public boolean hasSameParameter(String parameter, String value){
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
