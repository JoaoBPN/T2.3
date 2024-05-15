import java.util.ArrayList;

public class Busca {
    public static void buscaPonto(String entrada,ArrayList<Ponto> pontos, ArrayList<Ponto> buscaPontos){
        String[] partes = entrada.split("=");

        String atributo = partes[0].trim().toLowerCase();
        String valor = partes[1].trim();

        switch(atributo){
            case "nome":
                for(Ponto ponto : pontos){
                    if(ponto.getNome().equals(valor)){
                        buscaPontos.add(ponto);
                    }
                }
                break;
            case "x":
                double x = Double.parseDouble(valor);
                for(Ponto ponto : pontos){
                    if(ponto.getX() == x){
                        buscaPontos.add(ponto);
                    }
                }
                break;
            case "y":
                double y = Double.parseDouble(valor);
                for(Ponto ponto : pontos){
                    if(ponto.getY() == y){
                        buscaPontos.add(ponto);
                    }
                }
                break;
            default:
                System.out.println("Não foi possível buscar usando: "+atributo);
                break;

        }
    }
    public static void buscaCirculo(String entrada,ArrayList<Circulo> circulos, ArrayList<Circulo> buscaCirculos){

        String[] partes = entrada.split("=");

        String atributo = partes[0].trim().toLowerCase();
        String valor = partes[1].trim();

        switch (atributo) {
            case "nome":
                for (Circulo circulo : circulos) {
                    if (circulo.getNome().equals(valor)) {
                        buscaCirculos.add(circulo);
                    }
                }
                break;
            case "x":
                double x = Double.parseDouble(valor);
                for (Circulo circulo : circulos) {
                    if (circulo.getX() == x) {
                        buscaCirculos.add(circulo);
                    }
                }
                break;
            case "y":
                double y = Double.parseDouble(valor);
                for (Circulo circulo : circulos) {
                    if (circulo.getY() == y) {
                        buscaCirculos.add(circulo);
                    }
                }
                break;
            case "raio":
                double raio = Double.parseDouble(valor);
                for (Circulo circulo : circulos) {
                    if (circulo.getRaio() == raio) {
                        buscaCirculos.add(circulo);
                    }
                }
                break;
            default:
                System.out.println("Não foi possível buscar usando: " + atributo);
                break;
        }
    }



}