package exer5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class App{
    public static ArrayList<String> nomes = new ArrayList<>();
    public static ArrayList<LocalDateTime> citas = new ArrayList<>();
    public static final DateTimeFormatter formatoEngadirCita = DateTimeFormatter.ofPattern("HH:mm d/M/yyyy");
    public static final DateTimeFormatter formatoEliminarCita = DateTimeFormatter.ofPattern("d/M/yyyy HH:mm");
    public static final DateTimeFormatter formatoSeleccionarCita = DateTimeFormatter.ofPattern("d-M-yyyy");
    @SuppressWarnings({ "ConvertToTryWithResources" })
    public static void main(String[] Args){
        LocalDateTime cita = LocalDateTime.parse("12:30 10/2/2025", formatoEngadirCita);
        boolean programa = true;
        for(int i = 0; i<4; i++){
            nomes.add("Nome"+i);
            cita = cita.plus(1, ChronoUnit.DAYS);
            citas.add(cita);
        }
        while(programa == true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Qué desexa facer?\n\ta) Engadir cita\n\tb) Eliminar cita\n\tc) Seleccionar data\n\td) Sair");
            String opc = scanner.nextLine();
            switch (opc) {
                case "a" -> {
                    System.out.println("Introduza o nome do paciente: ");
                    String new_nome = scanner.nextLine();
                    System.out.println("Introduza a fecha da cita (HH:mm d/M/yyyy):");
                    String new_cita_raw = scanner.nextLine();
                    LocalDateTime new_cita = LocalDateTime.parse(new_cita_raw, formatoEngadirCita);
                    Boolean cita_invalida = false;
                    if(new_cita.getDayOfWeek() == DayOfWeek.SUNDAY || new_cita.getDayOfWeek() == DayOfWeek.SATURDAY){
                        System.out.println("A cita non pode ser un sábado ou domingo.");
                        cita_invalida = true;
                    }
                    for(LocalDateTime citaCheck:citas){
                        if(citaCheck.getYear() == new_cita.getYear() || citaCheck.getMonth() == new_cita.getMonth() ||
                                citaCheck.getDayOfMonth() == new_cita.getDayOfMonth()){
                            if((cita.isBefore(new_cita.plus(30, ChronoUnit.MINUTES)) && cita.isAfter(new_cita))
                             ||(cita.isAfter(new_cita.minus(30, ChronoUnit.MINUTES)) && cita.isBefore(new_cita))){
                                System.out.println("Xa hai citas a esa hora.");
                                cita_invalida = true;
                                break;
                            }
                        }
                    }
                    if(cita_invalida == true) continue;
                    nomes.add(new_nome);
                    citas.add(new_cita);
                    System.out.println("Cita engadida.");
                }
                case "b" -> {
                    System.out.println(mostrarCitas(nomes, citas, formatoEliminarCita));
                    System.out.println("Seleccione a cita a eliminar");
                    int selec = scanner.nextInt();
                    if(selec <= 0 || selec > citas.size()){
                        System.out.println("Índice de cita non existente.");
                        continue;
                    }
                    nomes.remove(selec-1);
                    citas.remove(selec-1);
                    System.out.println("Cita eliminada.");
                    break;
                }
                case "c" -> {
                    ArrayList<String> nomesC = new ArrayList<>();
                    ArrayList<LocalDateTime> citasC = new ArrayList<>();
                    System.out.println("Introduza a data (dd-MM-yyyy)");
                    String data_raw = scanner.nextLine();
                    LocalDate data = LocalDate.parse(data_raw, formatoSeleccionarCita);
                    for(LocalDateTime citaCheck:citas){
                        if(data.getYear() == citaCheck.getYear() && data.getMonth() == citaCheck.getMonth() &&
                        data.getDayOfMonth() == citaCheck.getDayOfMonth()){
                            citasC.add(citaCheck);
                            nomesC.add(nomes.get(citas.indexOf(citaCheck)));
                        }
                    }
                    System.out.println(mostrarCitas(nomesC, citasC, formatoSeleccionarCita));
                }
                case "d" -> {
                    System.out.println("Saindo do programa...");
                    programa = false;
                    scanner.close();
                    break;
                }
                default -> {
                    System.out.println("Opción inválida");
                    continue;
                }
            }
        }
    }

    public static String mostrarCitas(ArrayList<String> nomes, ArrayList<LocalDateTime> citas, DateTimeFormatter formato){
        String citasString = "";
        for(int i = 0; i < nomes.size(); i++){
            citasString += ""+(i+1)+") " + nomes.get(i) + ": " + citas.get(i).format(formato) + "\n";
        }
        return citasString;
    }
}