package Modelos;

public class Circulo extends Forma {

    public static final double pI = 3.14159;

    private Ponto pontoCentral;
    private double raio;


    public Circulo(String nome,Ponto pontoCentral,double raio){
        setRaio(raio);
        setPontoCentral(pontoCentral);
        setNome(nome);
    }

    public Ponto getPontoCentral() {
        return pontoCentral;
    }

    public void setPontoCentral(Ponto pontoCentral) {
        this.pontoCentral = pontoCentral;
    }

    public void setRaio(double raio){
        this.raio = raio;
    }

    public double getRaio(){
        return this.raio;
    }

    public double calculaDiametro(){
        return this.raio * 2;
    }

    public double calculaArea(){
        return this.raio * this.raio * pI;
    }

    public double calculaCircunferencia(){
        return this.raio * pI * 2;
    }

    public boolean compartilhamPontos(Circulo circulo){

        return this.raio + circulo.raio >= pontoCentral.distanciaEntrePontos(circulo.getPontoCentral());

    }

    @Override
    public String toString(){
        return getNome()+" = "+"["+ pontoCentral.getX() +";"+pontoCentral.getY()+"]" + " Raio = "+getRaio();
    }




}