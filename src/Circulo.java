public class Circulo{

    public static final double pI = 3.14159;

    private String nome;
    private double raio;
    private Ponto pontoCentral;

    Circulo(String nome,double raio,Ponto pontoCentral){
        this(raio,pontoCentral);
        setNome(nome);
    }
    Circulo(double raio,Ponto pontoCentral){
        setRaio(raio);
        setPontoCentral(pontoCentral);
        setNome("");
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setRaio(double raio){
        this.raio = raio;
    }

    public double getRaio(){
        return this.raio;
    }

    public void setPontoCentral(Ponto pontoCentral){
        this.pontoCentral = pontoCentral;
    }

    public Ponto getPontoCentral(){
        return this.pontoCentral;
    }

    public double getX(){
        return this.pontoCentral.getX();
    }
    public double getY(){
        return this.pontoCentral.getY();
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
        if( this.raio + circulo.raio < pontoCentral.distanciaEntrePontos(circulo.getPontoCentral())){
            return false;
        }

        return true;
    }

    @Override
    public String toString(){
        return getNome()+" = "+"["+ getX() +";"+getY()+"]" + " Raio = "+getRaio();
    }




}