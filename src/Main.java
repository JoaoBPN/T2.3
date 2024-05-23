import Modelos.Circulo;
import Utilidades.OperacoesDoSwitch;
import Modelos.Ponto;
import Utilidades.ArraysUtils;

public class Main{
    public static void main(String[] args){

        int tamanhoMaxPonto = 10;
        int tamanhoMaxCirculo = 2;

        Ponto[] pontos = new Ponto[tamanhoMaxPonto];
        Circulo[] circulos = new Circulo[tamanhoMaxCirculo];
        int opcao = 0;

        while(opcao != 0){

            opcao = OperacoesDoSwitch.menuPrincipal();

            int opcaoInterna = -1;

            switch(opcao){
                case 0:
                    System.out.println("Encerrando...");
                    break;
                case 1:

                    opcaoInterna = OperacoesDoSwitch.menuPontos();

                        switch(opcaoInterna){
                            case 0:

                                System.out.println("Voltando...");

                                break;

                            case 1:

                                if(ArraysUtils.arrayIsFull(pontos)){
                                    System.out.println("Limite de pontos atingidos, primeiramente remova um ponto para poder adicionar outro");
                                    break;
                                }

                                OperacoesDoSwitch.criaPonto().adicionaFormaEmArray(pontos);

                                break;
                            case 2:

                                // operação de remover ponto
                                break;
                            case 3:
                                ArraysUtils.imprimeArray(pontos);
                                break;
                            case 4:
                                // responder a distancia entre dois pontos selecionados

                                break;
                            default:
                                System.out.println("Operação invalida");
                                break;

                        }


                    break;

                case 2:
                    while(opcaoInterna != 0){

                        opcaoInterna = OperacoesDoSwitch.menuCirculos();


                        switch(opcaoInterna){
                            case 0:
                                System.out.println("Voltando...");
                                break;
                            case 1:
                                if(ArraysUtils.arrayIsFull(circulos)){
                                    System.out.println("Limite de circulos atingidos, primeiramente remova um circulo para poder adicionar outro");
                                    break;
                                }
                                    OperacoesDoSwitch.criaCirculo().adicionaFormaEmArray(circulos);

                                break;
                            case 2:
                                //operação de remover circulo
                                break;
                            case 3:
                                ArraysUtils.imprimeArray(circulos);
                                break;
                            case 4:
                                //retornar o diamentro de um circulo
                                break;
                            case 5:
                                //retornar a circunferencia de um circulo
                                break;
                            case 6:
                                // retornar a area de um circulo
                                break;
                            case 7:
                                //saber se um circulo intercepta outro ou não
                                break;
                            default:
                                System.out.println("Operação invalida");
                                break;
                        }

                    }
                    break;
                default:
                    System.out.println("Operação invalida");
                    break;

            }


        }
    }
}
