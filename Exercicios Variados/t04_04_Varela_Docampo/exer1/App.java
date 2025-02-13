package exer1;

// import java.util.ArrayList;
import java.util.Scanner;

public class App{
    public static Cuestionario cuestionario = new Cuestionario();
    public static void main(String[] Args){
        engadirDatos();
        boolean programa = true;
        while(programa){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Seleccione a opción:\n\ta) Engadir pregunta\n\tb) Responder cuestionario\n\tc) Mostrar resultados\n\td) Sair");
            char opc = scanner.nextLine().charAt(0);
            switch (opc) {
                case 'a' ->{
                    System.out.println("Introduza a pregunta:");
                    Pregunta novaPregunta = new Pregunta(scanner.nextLine());
                    while(novaPregunta.getNumRespostas() < 2){
                        System.out.println("Posible resposta:");
                        Resposta novaResposta = new Resposta(scanner.nextLine());
                        novaPregunta.addResposta(novaResposta);
                    }
                    while(true){
                        System.out.println("Desexa engadir máis respostas? (y/n)");
                        char opc1 = scanner.nextLine().charAt(0);
                        if(opc1 != 'y'){
                            break;
                        }
                        System.out.println("Introduza a nova resposta:");
                        Resposta novaResposta = new Resposta(scanner.nextLine());
                        novaPregunta.addResposta(novaResposta);
                    }
                    cuestionario.add(novaPregunta);
                    System.out.println("Pregunta engadida cas súas respectivas respostas.");
                }

                case 'b' ->{
                    for(Pregunta pregunta:cuestionario.getCuestionario()){
                        while(true){
                            int i = 0;
                            System.out.println(pregunta.getPregunta());
                            for(Resposta resposta:pregunta.getRespostas()){
                                System.out.println("\t"+(i+1)+") "+resposta.getResposta());
                                i++;
                            }
                            System.out.println("Resposta:");
                            int selec = scanner.nextInt();
                            if(selec>pregunta.getNumRespostas() || selec<=0) System.out.println("Resposta inválida");
                            else{
                                pregunta.selecResposta(selec-1);
                                break;
                            }
                        }
                    }
                    System.out.println("Cuestionario rematado.");
                }

                case 'c' ->{
                    for(Pregunta pregunta:cuestionario.getCuestionario()){
                        int i = 0;
                        System.out.println(pregunta.getPregunta());
                        for(Resposta resposta:pregunta.getRespostas()){
                            System.out.println("\t"+(i+1)+") "+resposta.getResposta()+" - "+resposta.getPorcentaxeSeleccion()+"%");
                            i++;
                        }
                    }
                }

                case 'd' ->{
                    programa = false;
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    break;
                }

                default ->{
                    System.out.println("Opción inválida, tente de novo.");
                }
            }
        }
    }

    public static void engadirDatos(){
        for(int j = 0; j<3; j++){
            Pregunta novaPregunta = new Pregunta("Pregunta "+(j+1));
            for(int i = 0; i<4; i++){
                Resposta novaResposta = new Resposta("Resposa "+(i+1));
                novaPregunta.addResposta(novaResposta);
            }
            cuestionario.add(novaPregunta);
        }
    }
}