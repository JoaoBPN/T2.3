package Modelos;

public abstract class Forma{

    String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void adicionaFormaEmArray(Forma[] formas){
        int cont = 0;
        for(Forma forma:formas){
            if(forma == null){
                formas[cont] = this;
                break;
            }
            cont++;
        }
    }


}
