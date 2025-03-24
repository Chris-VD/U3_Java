package exer1;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class App{
    public static ArrayList<Restaurante> restaurantes = new ArrayList<>();
    @SuppressWarnings("resource")
    public static void main(String[] Args) throws IOException{
        insertarDatos();
        boolean programa = true;
        while (programa){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Que desexa facer?\n\ta) Engadir restaurante\n\tb) Facer reserva\n\tc) Ver número de reservas do día\n\td) Ver primeiro día sen reservas");
            char opc = scanner.nextLine().charAt(0);
            switch (opc){
                case 'a' ->{
                    System.out.println("Introduza a cidade do restaurante:");
                    String cidade = scanner.nextLine();
                    System.out.println("Introduza o teléfono do restaurante:");
                    String telefono = scanner.nextLine();
                    Restaurante novoRestaurante = new Restaurante(cidade, telefono);
                    restaurantes.add(novoRestaurante);
                }
                case 'b' ->{
                    int opcRest = seleccionarRestaurantes();
                    System.out.println("Nome do reservador?");
                    String newNome = scanner.nextLine();
                    System.out.println("Escriba a fecha da reserva (dd/MM/yyyy)");
                    String newFecha = scanner.nextLine();
                    System.out.println("Intrpduza o número de persoas da reserva:");
                    int newNumero = scanner.nextInt();
                    boolean checkReserva = restaurantes.get(opcRest).addReserva(newNome, newFecha, newNumero);
                    if (checkReserva) System.out.println("Reserva engadida correctamente.");
                    else System.out.println("Non se puido engadir a reserva.");
                }
                case 'c' ->{
                    int opcRest = seleccionarRestaurantes();
                    Restaurante restauranteSelec = restaurantes.get(opcRest);
                    int reservas = restauranteSelec.getReservasMismoDia(LocalDate.now()).size();
                    System.out.printf("O restaurante de %s con teléfono %s ten %d reservas o día de hoxe", restauranteSelec.getCidade(), restauranteSelec.getTelefono(), reservas);
                }
                case 'd' ->{
                    int opcRest = seleccionarRestaurantes();
                    Optional<LocalDate> diaLibre = restaurantes.get(opcRest).buscarDiaLibre();
                    if (diaLibre.isPresent()) System.out.println("O primeiro día sen seservas do que queda de mes é o "+diaLibre.get()  );
                    else System.out.println("Non hai días libres no que queda de mes!");
                }
                default ->{
                    System.out.println("Opción inválida, tente de novo");
                }
            }
            System.out.println();
        }
    }

    @SuppressWarnings("resource")
    public static int seleccionarRestaurantes(){
        while (true){
            Scanner scanner = new Scanner(System.in);
            int i = 1;
            for (Restaurante restaurante : restaurantes){
                System.out.printf("%d) Cidade %s, Teléfono %s\n", i++, restaurante.getCidade(), restaurante.getTelefono());
            }
            System.out.println("Qué restaurante desexa seleccionar?");
            int opc = scanner.nextInt();
            if (opc > 0 && opc <= restaurantes.size()) return opc-1;
            System.out.println("Opción inválida, tente de novo.");
        }
    }

    public static void insertarDatos(){
        String dataB = "/03/2025";
        int dataA = 01;
        for (int i = 0; i < 5; i++) {
            Restaurante novoRestaurante = new Restaurante("Cidade "+i, "t"+i*100);
            restaurantes.add(novoRestaurante);
            dataA += 1;
            for (int j = 0; j < 10; j++){
                String data = dataA + dataB;
                novoRestaurante.addReserva("nome "+j, data, j);
            }
        }
    }
}