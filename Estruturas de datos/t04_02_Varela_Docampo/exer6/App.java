package exer6;

// Todos os imports
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App{
    
    // Como tal non faría falta ter aquí os formatos de datetime pero apeteceume pq queda ben
    public static final DateTimeFormatter formatoFichadoFull = DateTimeFormatter.ofPattern("HH:mm d/M/yyyy");
    public static final int ano = LocalDateTime.now().getYear();

    public static void main(String[] Args){

        // Definimos os hash maps e arraylists
        HashMap<String, ArrayList<LocalDateTime>> mapa = new HashMap<>();
        ArrayList<LocalDateTime> ficha = new ArrayList<>();

        // Todo este bloque é para engadir os valores, ignoralo
        mapa.put("17929701M", ficha);
        mapa.put("56306071R", ficha);
        mapa.put("66188536X", ficha);
        for (Map.Entry<String, ArrayList<LocalDateTime>> entry : mapa.entrySet()) {
            if(!checkDni(entry.getKey())){
                System.out.println("DNI inválido!");
                continue;
            }
            ArrayList<LocalDateTime> tempFicha = new ArrayList<>();
            LocalDateTime novaFecha = LocalDateTime.now().minus(1, ChronoUnit.DAYS);
            for(int i = 0; i < mapa.size()+2; i++){
                tempFicha.add(novaFecha);
                novaFecha = novaFecha.plus(2, ChronoUnit.HOURS);
            }
            mapa.put(entry.getKey(), tempFicha);
            for(int i = 0; i < entry.getValue().size(); i++){
                System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue().get(i).format(formatoFichadoFull));
            }
            System.out.println();
        }

        // boolean para comporbar que o loop siga
        boolean programa = true;

        while(programa == true){

            // Inicializamos o scanner e pedimos ó usuario que facer
            Scanner scanner = new Scanner(System.in);
            System.out.println("Que desexa facer?\n\ta) Fichar entrada/saida\n\tb) Comprobar salario\n\tc) Sair");
            char opc = scanner.nextLine().charAt(0);

            switch (opc) {

                // Engadir fichado
                case 'a' -> {

                    // Pedimos o DNI
                    System.out.println("Introduza seu DNI: ");
                    String dniAComprobar = scanner.nextLine();

                    // Comprobamos o DNI
                    if(!mapa.containsKey(dniAComprobar)){
                        System.out.println("DNI non existe, engadindo novo...");
                        if(!checkDni(dniAComprobar)){
                            System.out.println("DNI inválido, non se puido engador.");
                            break;
                        }
                        else mapa.put(dniAComprobar, new ArrayList<LocalDateTime>());
                    }

                    // Esta parte do código era para engadir manualmente a hroa de fichado, para facer probas que tiveran sentido
                    /*
                    // Pedimos e comprobamos a data de fichado
                    System.out.println("Introduza a hora de fichado (HH:mm d/M)");
                    // Como tal a data pídese en formato (HH:mm d/M) pero fai falta que teña o ano para poder facer o parse polo que engádoo logo
                    String horaAComprobar = scanner.nextLine()+"/"+ano;
                    LocalDateTime novaFecha = LocalDateTime.parse(horaAComprobar, formatoFichadoFull);
                    */
                    
                    // Gardamos a hora actual
                    LocalDateTime novaFecha = LocalDateTime.now();
                    mapa.get(dniAComprobar).add(novaFecha);
                    System.out.println("Fichado correctamente.");
                }

                // Comprobar soldo
                case 'b' -> {

                    // Pedimos e comprobamos o DNI
                    System.out.println("Introduza seu DNI: ");
                    String dniAComprobar = scanner.nextLine();
                    if(!checkDni(dniAComprobar) || !mapa.containsKey(dniAComprobar)){
                        System.out.println("DNI inválido.");
                        break;
                    }

                    // Definimos todas as variables necesarias para facer as comprobacións e a suma das horas traballadas
                    Duration traballoTotal = Duration.ZERO;
                    Duration traballado = null;
                    LocalDateTime horaEntrada = null;
                    LocalDateTime horaSaida = null;
                    // Lista das horas de entrada e saida do DNI seleccionado
                    ArrayList<LocalDateTime> listaFichados = mapa.get(dniAComprobar);

                    // Imos valor por valor, tendo en conta que os pares son as horas de entrada e os impares as de saida
                    for(int i = 0; i < listaFichados.size(); i++){
                        // As de entrada son os pares e mais 0, que non sei sei pasa o check ó facer (0 % 2 =?= 0)
                        if(i == 0 || i % 2 == 0) horaEntrada = listaFichados.get(i); // Se é par, gardamos a hora como hroa de entrada
                        // Se non é par, gardamos a hroa coma hora de saida e calculamos o tempo traballado nese intervalo
                        else{
                            horaSaida = listaFichados.get(i);
                            traballado = Duration.between(horaEntrada, horaSaida);
                            // Sumamos o intervalo calculado ó total de hroas traballadas
                            traballoTotal = traballoTotal.plus(traballado);
                        }
                    }

                    // Pasamos o intervalo total a minutos e calculamos o salario
                    double salario = traballoTotal.toMinutes() * 12/60;
                    System.out.println("O seu salario é de "+salario+" euros.");
                }

                // Pechar programa
                case 'c' -> {
                    System.out.println("Pechando programa...");
                    scanner.close();
                    programa = false;
                }
                
                // Se o usuario introduce unha opción inválida...
                default -> {
                    System.out.println("Opción inválida, tente de novo.");
                }
            }
        }
    }

    /**
     * Método que comproba se un DNI é válido ou non
     * @param DNI DNI a comprobar, String
     * @return true se o DNI é válido, false se non
     */
    public static boolean checkDni(String DNI){
        // Comprobamos que a lonxitude sexa correcta
        if (DNI.length() != 9) return false;
        
        // Creamos a lista das letras para a comprobación
        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

        // Separamos o DNI en números e letras
        int numeros = Integer.parseInt(DNI.substring(0,8));
        char letra = DNI.charAt(8);

        // Comrpobamos que a letra introducida é a corretcta para o número do DNI
        int resto = numeros % 23;
        return (letras[resto] == letra);
    }
}