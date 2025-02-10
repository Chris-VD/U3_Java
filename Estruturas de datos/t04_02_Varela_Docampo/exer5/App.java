package exer5;

// Todos os importes necesarios
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class App{
    // As ArrayList defínoas fora de main porque en principio facíanme falta pa usalas nun método, pero cambieino e como tal non
    // faría falta que estean aquí, igualmente creo que qeuda máis bonito que deixalas en main
    public static ArrayList<String> nomes = new ArrayList<>();
    public static ArrayList<LocalDateTime> citas = new ArrayList<>();

    // Os formatos si que os deixo fora de main xa que os emprego no método, que está fora de main
    public static final DateTimeFormatter formatoEngadirCita = DateTimeFormatter.ofPattern("HH:mm d/M/yyyy");
    public static final DateTimeFormatter formatoEliminarCita = DateTimeFormatter.ofPattern("d/M/yyyy HH:mm");
    public static final DateTimeFormatter formatoSeleccionarCita = DateTimeFormatter.ofPattern("d-M-yyyy");

    // Esto está aquí pq algúns dos meu plugins fan que o scanner apareza amarillo se non lle poño tries, unha pijada
    @SuppressWarnings({ "ConvertToTryWithResources" })
    public static void main(String[] Args){
        boolean programa = true;

        // Este bloque todo é so para engadir os datos ó programa cando se inicie
        LocalDateTime cita = LocalDateTime.parse("12:30 10/2/2025", formatoEngadirCita);
        for(int i = 0; i<4; i++){
            nomes.add("Nome"+i);
            cita = cita.plus(1, ChronoUnit.DAYS);
            citas.add(cita);
        }

        // O while principal
        while(programa == true){
            // Defino o scanner aquí para que se reinicie o buffer cada repetición
            Scanner scanner = new Scanner(System.in);
            System.out.println("Qué desexa facer?\n\ta) Engadir cita\n\tb) Eliminar cita\n\tc) Seleccionar data\n\td) Sair");
            char opc = scanner.nextLine().charAt(0);

            switch (opc) {

                // Ingresar unha nova cita
                case 'a' -> {
                    System.out.println("Introduza o nome do paciente: ");
                    String new_nome = scanner.nextLine();
                    System.out.println("Introduza a fecha da cita (HH:mm d/M/yyyy):");
                    String new_cita_raw = scanner.nextLine();

                    // O de definir os formatos de antemán fora de main mola moito
                    LocalDateTime new_cita = LocalDateTime.parse(new_cita_raw, formatoEngadirCita);

                    // boolean para comprobar se a cita é válida
                    boolean cita_invalida = false;

                    // Comprobamos que o día da semana non sexa sábado ou domingo
                    if(new_cita.getDayOfWeek() == DayOfWeek.SUNDAY || new_cita.getDayOfWeek() == DayOfWeek.SATURDAY){
                        System.out.println("A cita non pode ser un sábado ou domingo.");
                        cita_invalida = true;
                    }

                    // Comprobamos que a cita introducida non sexa media hora despóis doutra ou media hora antes
                    // Imos cita por cita comprobando cada unha
                    for(LocalDateTime citaCheck:citas){
                        // Primeiro comprobamos se son do mesmo ano, mes e día, nese orde
                        if(citaCheck.getYear() == new_cita.getYear() || citaCheck.getMonth() == new_cita.getMonth() ||
                                citaCheck.getDayOfMonth() == new_cita.getDayOfMonth()){

                            // A continuación comprobamos que a cita non sexa media hora despóis doutra ou media hora antes
                            if((cita.isBefore(new_cita.plus(30, ChronoUnit.MINUTES)) && cita.isAfter(new_cita))
                             ||(cita.isAfter(new_cita.minus(30, ChronoUnit.MINUTES)) && cita.isBefore(new_cita))){
                                System.out.println("Xa hai citas a esa hora.");
                                cita_invalida = true;
                                break;
                            }
                        }
                    }
                    // Se a cita é inválida mandamos o usuario ó menu
                    if(cita_invalida == true) continue;

                    // Se é válida, gardamos os valores nas ArrayLists
                    nomes.add(new_nome);
                    citas.add(new_cita);
                    System.out.println("Cita engadida.");
                }

                // Eliminar unha cita existente
                case 'b' -> {

                    // Mostramos todalas citas xunto co seu índice
                    System.out.println(mostrarCitas(nomes, citas, formatoEliminarCita));
                    System.out.println("Seleccione a cita a eliminar");
                    int selec = scanner.nextInt();

                    // Comprobamos que o índice sexa válido
                    if(selec <= 0 || selec > citas.size()){
                        System.out.println("Índice de cita non existente.");
                        continue;
                    }

                    // Se é válido eliminamos a cita seleccionada
                    nomes.remove(selec-1);
                    citas.remove(selec-1);
                    System.out.println("Cita eliminada.");
                    break;
                }

                // Mostrar citas dun día
                case 'c' -> {

                    // Creamos novas ArrayLists para as citas do día introducido
                    ArrayList<String> nomesC = new ArrayList<>();
                    ArrayList<LocalDateTime> citasC = new ArrayList<>();

                    System.out.println("Introduza a data (dd-MM-yyyy)");
                    String data_raw = scanner.nextLine();
                    LocalDate data = LocalDate.parse(data_raw, formatoSeleccionarCita);

                    // Imos cita por cita
                    for(LocalDateTime citaCheck:citas){
                        // Comprobamos se a cita que tamos comprobando está no mesmo día que a data introducida
                        if(data.getYear() == citaCheck.getYear() && data.getMonth() == citaCheck.getMonth() &&
                        data.getDayOfMonth() == citaCheck.getDayOfMonth()){
                            // Se é así, engadimos a cita ás novas ArrayList que creamos
                            citasC.add(citaCheck);
                            nomesC.add(nomes.get(citas.indexOf(citaCheck)));
                        }
                    }
                    // Mostramos as novas ArrayLists
                    System.out.println(mostrarCitas(nomesC, citasC, formatoSeleccionarCita));
                }

                // Sair do programa
                case 'd' -> {
                    System.out.println("Saindo do programa...");
                    programa = false;
                    scanner.close();
                    break;
                }

                // Se algunha das opións non é válida
                default -> {
                    System.out.println("Opción inválida");
                    continue;
                }
            }
        }
    }

    /**
     * Método para mostrar as citas, necesita dous arraylists introducidos ó chamar ó método e un formato que se introduce por defecto
     * @param nomes Lista dos nomes
     * @param citas Lista das citas
     * @param formato Formato co que queremos mostrar a información, está aquí xa que en diferentes opción queremos mostrar diferentes formatos
     * @return Un String codificada con toda a información
     */
    public static String mostrarCitas(ArrayList<String> nomes, ArrayList<LocalDateTime> citas, DateTimeFormatter formato){
        String citasString = "";
        for(int i = 0; i < nomes.size(); i++){
            citasString += ""+(i+1)+") " + nomes.get(i) + ": " + citas.get(i).format(formato) + "\n";
        }
        return citasString;
    }
}