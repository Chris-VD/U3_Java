package exer2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class App {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDate dataActual = LocalDate.now();
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("d-M-yyy");
        System.out.println("Introduza súa data de nacemento (dd-mm-yyyy)");
        String data_raw = scanner.nextLine();
        LocalDate data = LocalDate.parse(data_raw, formatoData);
        int anoActual = dataActual.getYear();
        LocalDate cumpleanos = LocalDate.of(anoActual, data.getMonth(), data.getDayOfMonth());
        Period ataCumple;
        if(dataActual.isBefore(cumpleanos)){
            ataCumple = Period.between(dataActual, cumpleanos);
            DayOfWeek diaSemana = cumpleanos.getDayOfWeek();
            System.out.println("Faltan "+ataCumple.getMonths()+" meses e "+ataCumple.getDays()+" días para teu cumpleanos!\nO teu cumpleanos será un "+diaSemana);
        }
        else if(dataActual.isAfter(cumpleanos)){
            ataCumple = Period.between(cumpleanos, dataActual);
            cumpleanos.plus(1, ChronoUnit.YEARS);
            DayOfWeek diaSemana = cumpleanos.getDayOfWeek();
            System.out.println("Teu cumpleanos foi fai "+ataCumple.getMonths()+" meses e "+ataCumple.getDays()+" días!\nO teu seguinte cumpleanos será un "+diaSemana);
        }
        else{
            cumpleanos.plus(1, ChronoUnit.YEARS);
            DayOfWeek diaSemana = cumpleanos.getDayOfWeek();
            System.out.println("Hoxe é teu cumpleanos!\nO teu seguinte cumpleanos será un "+diaSemana);
        }

        scanner.close();
    }
}
