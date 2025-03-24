import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class App {
    public static ArrayList<Hotel> hoteles = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        boolean menuActivo = true;
        while(menuActivo) {
            System.out.println("Que desexa facer?");
            System.out.println("a) Dar de alta un hotel");
            System.out.println("b) Dar de alta unha habitación nun hotel");
            System.out.println("c) Buscador de habitacións libres nun hotel");
            System.out.println("d) Reservar unha habitación nun hotel");
            System.out.println("e) Ver porcentaxe de ocupación dun determinado día nun hotel");
            System.out.println("s) Sair");

            String opcion = sc.nextLine();

            switch (opcion) {

                //a) Dar de alta un hotel
                case "a" -> {
                    // Pedimos o nome do hotel
                    System.out.println("Que nome ten o hotel que desexa engadir?");
                    String nome = sc.nextLine();
                    // Creamos o novo hotel
                    Hotel novoHotel = new Hotel(nome);
                    // Engadímolo á lista de hoteles
                    hoteles.add(novoHotel);
                    System.out.println("Hotel engadido correctamente!");
                } 

                // b) Dar de alta unha habitación nun hotel
                case "b" ->  {
                    System.out.println("Seleccione o hotel no que quere engadir unha habitación:");
                    mostrarHoteis();
                    int opc = Integer.valueOf(sc.nextLine());
                    if(opc <= 0 || opc > hoteles.size()){
                        System.out.println("Hotel inválido");
                        break;
                    }
                    Hotel hotelSelec = hoteles.get(opc-1);

                    System.out.println("Introduza o número da habitación:");
                    String numero = sc.nextLine(); // Ó pedir este valor podería facer unha comprobación adicional que comprobe que é un numero entre 1-999, pero non o vexo estrictamente necesario
                    System.out.println("Introduza o tipo de habitación (i -> individual, d -> doble, t -> triple)");
                    char tipo = sc.nextLine().charAt(0); // A comprobación de este valor faise no método da clase en vez de aquí, poderíase facer de maneira diferente para
                    // poder poñer un mensaxe de erro específico e non so un "non sei poido engadir" pero non o vexo necesario
                    System.out.println("Introduza o prezo por noite da habitación:");
                    double prezo = Double.valueOf(sc.nextLine());

                    // Hotel.addHabitacion devolve true ou false dependendo de se se engadiu correctamente ou non 
                    if(!hotelSelec.addHabitacion(numero, tipo, prezo)) System.out.println("Non se poido engadir a habitación, comprobe os datos e tente de novo.");
                    else System.out.println("Habitación engadida correctamente!");
                }

                // c) Buscador de habitacións libres nun hotel
                case "c" -> {
                    System.out.println("Seleccione o hotel no que quere buscar:");
                    mostrarHoteis();
                    int opc = Integer.valueOf(sc.nextLine());
                    if(opc <= 0 || opc > hoteles.size()){
                        System.out.println("Hotel inválido");
                        break;
                    }
                    Hotel hotelSelec = hoteles.get(opc-1);

                    System.out.println("Introduza a fecha de entrada en formato dd/mm/aaaa");
                    String entradaRaw = sc.nextLine();
                    System.out.println("Introduza a fecha de saida en formato dd/mm/aaaa");
                    String saidaRaw = sc.nextLine();
                    System.out.println("Introduza o tipo de habitación (i -> individual, d -> doble, t -> triple)");
                    char tipo = sc.nextLine().charAt(0);

                    // Fagoo con optional xa que pode que non haxa habitacións disponibbles, a lista estariía valeira
                    Optional<ArrayList<Habitacion>> habitacionsDisponibles = hotelSelec.buscadorHabitacion(entradaRaw, saidaRaw, tipo);
                    if(habitacionsDisponibles.isPresent()){
                        System.out.println("As habitacións disponibles son:");
                        for(Habitacion habitacion : habitacionsDisponibles.get()){
                            System.out.println("\t-Habitación número "+habitacion.getNumero());
                        }
                    }
                    else System.out.println("Non hai habitacións que cumpran os requisitos.");
                }

                // d) Reservar unha habitación nun hotel
                case "d" -> {
                    System.out.println("Seleccione o hotel no que quere reservar unha habitación:");
                    mostrarHoteis();
                    int opc = Integer.valueOf(sc.nextLine());
                    if(opc <= 0 || opc > hoteles.size()){
                        System.out.println("Hotel inválido");
                        break;
                    }
                    Hotel hotelSelec = hoteles.get(opc-1);

                    System.out.println("Habitacións existentes:");
                    for(Habitacion habitacion : hotelSelec.getHabitacions()){
                        System.out.println(habitacion.getNumero());
                    }
                    System.out.println("Que habitación desexa reservar?");
                    String numero = sc.nextLine();

                    System.out.println("Introduza a fecha de entrada en formato dd/mm/aaaa");
                    String entradaRaw = sc.nextLine();
                    System.out.println("Introduza a fecha de saida en formato dd/mm/aaaa");
                    String saidaRaw = sc.nextLine();
                    System.out.println("Introduza o nome da persoa que faia reserva:");
                    String nome = sc.nextLine();

                    // Hotel.addReserva devolve true ou false dependendo de se se engadiu correctamente ou non 
                    if(hotelSelec.addReserva(numero, nome, entradaRaw, saidaRaw)) System.out.println("Reserva engadida correctamente!");
                    else System.out.println("Non se puido engadir a reserva, comprobe os datos e tente de novo.");
                }

                // e) Ver porcentaxe de ocupación dun determinado día nun hotel
                case "e" -> {
                    System.out.println("Seleccione o hotel que quere comprobar:");
                    mostrarHoteis();
                    int opc = Integer.valueOf(sc.nextLine());
                    if(opc <= 0 || opc > hoteles.size()){
                        System.out.println("Hotel inválido");
                        break;
                    }
                    Hotel hotelSelec = hoteles.get(opc-1);

                    System.out.println("Introduza a data a comprobar en formato dd/mm/aaaa");
                    String dataRaw = sc.nextLine();

                    double porcentaxe = hotelSelec.getPorcentaxeOcupa(dataRaw);
                    System.out.println("O porcentaxe de ocupación do hotel "+hotelSelec.getNome()+" o día "+dataRaw+" é de "+(porcentaxe*100));
                }

                case "s" -> {
                    System.out.println("Saindo");
                    menuActivo = false;
                }

                default -> System.out.println("Opcion inválida");


            }
        }
        sc.close(); // Cerramos o teclado

    }

    /**
     * Mostra todos os hoteis, para que o usuario poida seleccionalo
     */
    public static void mostrarHoteis(){
        for(int i = 1; i < hoteles.size()+1; i++){
            System.out.println(i+") "+hoteles.get(i-1).getNome());
        }
    }
}