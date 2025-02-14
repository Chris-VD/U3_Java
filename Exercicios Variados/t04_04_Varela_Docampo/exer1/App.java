package exer1;

// import java.util.ArrayList;
import java.util.Scanner;

public class App{

    // Cuestionario onde se gardan as preguntas
    public static Cuestionario cuestionario = new Cuestionario();
    public static void main(String[] Args){
        // Chamamos ó método para engadir os datos do programa
        engadirDatos();
        // boolean para comprobrar que o programa se execute
        boolean programa = true;

        while(programa){

            // Inicializamos o scanner
            Scanner scanner = new Scanner(System.in);
            System.out.println("Seleccione a opción:\n\ta) Engadir pregunta\n\tb) Responder cuestionario\n\tc) Mostrar resultados\n\td) Sair");
            char opc = scanner.nextLine().charAt(0);

            // Switch principal
            switch (opc) {

                // Introducir unha nova pregunta
                case 'a' ->{

                    // Creamos a nova pregunta
                    System.out.println("Introduza a pregunta:");
                    Pregunta novaPregunta = new Pregunta(scanner.nextLine());

                    // Engadimos mínimo 2 respostas
                    while(novaPregunta.getRespostas().size() < 2){
                        System.out.println("Posible resposta:");
                        Resposta novaResposta = new Resposta(scanner.nextLine());
                        novaPregunta.addResposta(novaResposta);
                    }

                    // Comprobamos se o ususario desexa engadir máis respostas
                    while(true){
                        System.out.println("Desexa engadir máis respostas? (y/n)");
                        char opc1 = scanner.nextLine().charAt(0);
                        if(opc1 != 'y'){
                            // Se non, facemos un break
                            break;
                        }
                        System.out.println("Introduza a nova resposta:");
                        Resposta novaResposta = new Resposta(scanner.nextLine());
                        novaPregunta.addResposta(novaResposta);
                    }

                    // Engadimos a pregutna ó cuestionario
                    cuestionario.add(novaPregunta);
                    System.out.println("Pregunta engadida cas súas respectivas respostas.");
                }

                // Responder ó cuestionario
                case 'b' ->{

                    // Imos pregunta por pregunta
                    for(Pregunta pregunta:cuestionario.getCuestionario()){
                        while(true){
                            int i = 0;
                            // Mostramos a pregunta
                            System.out.println(pregunta.getPregunta());
                            // Mostramos todas as respostas co seu índice
                            for(Resposta resposta:pregunta.getRespostas()){
                                System.out.println("\t"+(i+1)+") "+resposta.getResposta());
                                i++;
                            }
                            System.out.println("Resposta:");
                            int selec = scanner.nextInt();
                            // Comprobamos que a selección estea no rango de respostas
                            if(selec>pregunta.getRespostas().size() || selec<=0) System.out.println("Resposta inválida");
                            else{
                                pregunta.selecResposta(selec-1);
                                break;
                            }
                        }
                    }
                    System.out.println("Cuestionario rematado.");
                }

                // Mostrar porentaxes das respostas
                case 'c' ->{

                    // Imos pregunta por pregunta
                    for(Pregunta pregunta:cuestionario.getCuestionario()){
                        int i = 0;
                        System.out.println(pregunta.getPregunta());
                        // Listamos as respostas cos seus respectivos porcentaxes
                        for(Resposta resposta:pregunta.getRespostas()){
                            System.out.println("\t"+(i+1)+") "+resposta.getResposta()+" - "+resposta.getPorcentaxeSeleccion()+"%");
                            i++;
                        }
                    }
                }

                // Sair do programa
                case 'd' ->{
                    programa = false;
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    break;
                }

                // Se a opc non está dentro do switch
                default ->{
                    System.out.println("Opción inválida, tente de novo.");
                }
            }
        }
    }

    /**
     * Método que engade os datos do programa, ignoralo
     */
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