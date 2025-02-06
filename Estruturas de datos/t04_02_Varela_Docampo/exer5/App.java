package exer5;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class App{
    public static ArrayList<String> nomes = new ArrayList<>();
    public static ArrayList<LocalDateTime> citas = new ArrayList<>();
    public static void main(String[] Args){
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatoEngadirCita = DateTimeFormatter.ofPattern("HH:mm d/M/yyyy");
        DateTimeFormatter formatoEliminarCita = DateTimeFormatter.ofPattern("d/M/yyyy HH:mm");
        DateTimeFormatter formatoSeleccionarCita = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDateTime cita = LocalDateTime.parse("12:30 10/2/2025", formatoEngadirCita);
        for(int i = 0; i<4; i++){
            nomes.add("Nome"+i);
            cita = cita.plus(1, ChronoUnit.DAYS);
            citas.add(cita);
        }
        while(true){
            System.out.println("Qué desexa facer?\n\ta) Engadir cita\n\tb) Eliminar cita\n\tc) Seleccionar data");
            String[] opcList = {"a", "A", "b", "B", "c", "C"};
            String opc = scanner.nextLine();
            
            break;
        }
        scanner.close();
    }

    public static String mostrarCitas(){
        String citasString = "";
        for(int i = 0; i<nomes.size();i++){
            citasString = citasString + nomes.get(i) + ": " + citas.get(i) + "\n";
        }
        return citasString;
    }
}