package exer1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class App{
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] Args){
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatoHoras = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println("Introduza a hora de comenzo do programa (hh:mm): ");
        String hora_comenzo = scanner.nextLine();
        LocalDateTime horaComenzo = LocalDateTime.parse(hora_comenzo, formatoHoras);
        System.out.println("Introduza a duración en minutos do programa: ");
        int duracion = scanner.nextInt();
        LocalDateTime horaFinal = horaComenzo.plus(duracion, ChronoUnit.MINUTES);
        System.out.println("A hora de finalización do programa será ás "+horaFinal);
        scanner.close();
    }
}