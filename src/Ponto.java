import static java.lang.Math.sqrt;

public class Ponto{

    private String nome;
    private double x;
    private double y;

    Ponto(double x,double y){
        setX(x);
        setY(y);
        setNome("");
    }
    Ponto(String nome,double x,double y){
        this(x,y);
        setNome(nome);
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setX(double x){
        this.x = x;
    }

    public double getX(){
        return this.x;
    }

    public void setY(double y){
        this.y = y;
    }

    public double getY(){
        return this.y;
    }

    public double distanciaEntrePontos(Ponto ponto){

        double cat1 = getX() - ponto.getX();
        double cat2 = getY() - ponto.getY();
        double hip = cat1*cat1 + cat2*cat2;

        return sqrt(hip);

    }

    @Override
    public String toString(){
        return getNome()+" = "+"["+getX()+";"+getY()+"]";

    }



}