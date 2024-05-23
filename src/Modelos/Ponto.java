package Modelos;

import static java.lang.Math.sqrt;

public class Ponto extends Forma {

    private double x;
    private double y;

    public Ponto(String nome,double x,double y){

        this(x,y);
        setNome(nome);

    }

    public Ponto(double x,double y){
        setX(x);
        setY(y);
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double distanciaEntrePontos(Ponto ponto){

        double cat1 = getX() - ponto.getX();
        double cat2 = getY() - ponto.getY();
        double hip = cat1*cat1 + cat2*cat2;

        return sqrt(hip);

    }

    public static Ponto criaPonto(double x,double y){
        return new Ponto(x,y);
    }

    @Override
    public String toString(){
        return getNome()+" = "+"["+getX()+";"+getY()+"]";

    }

}