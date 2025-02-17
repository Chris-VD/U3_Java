package exer2;

// Todos os iports necesarios
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    // Definimos o HashMap de rexistro aquí pq é maís fácil
    public static HashMap<String, Usuario> rexistro = new HashMap<String, Usuario>();
    // Formato de data que se empregará en todo o programa
    public static DateTimeFormatter formatoPrincipal = DateTimeFormatter.ofPattern("d/M/yyyy HH:mm");
    public static void main(String[] Args){
        // Métodos para engadir datos
        addUsers();
        addTarefas();

        // booleans que comproban o estado do programa
        boolean principal = true;
        boolean secundario = false;
        boolean programa = true;

        while (programa) {
            // Inicializamos aquí a variable de usuario
            Usuario user = null;

            while (principal) {
                // Inicializamos o escanner
                Scanner scanner = new Scanner(System.in);
                System.out.println("Que desexa facer?\n\ti) Iniciar sesión\n\tr) Rexistrarse\n\ts) Sair do programa");
                char opc = scanner.nextLine().charAt(0);

                switch (opc) {

                    // Log In
                    case 'i' -> {
                        // Pedimos todos os datos
                        System.out.println("Introduza seu nome de usurio:");
                        String username = scanner.nextLine();

                        // Comprobamos que o nome de usuario exista
                        if(!rexistro.keySet().contains(username)){
                            System.out.println("Usuario non existe.");
                            continue;
                        }
                        user = rexistro.get(username);
                        System.out.println("Introduza sua contrasinal:");
                        String pswS = scanner.nextLine();

                        // Comprobamos que a contrasinal sexa correcta
                        if(!HashPassword.hashPassword(pswS).equals(user.getHash())){
                            System.out.println("Contrasinal incorrecto.");
                            continue;
                        }

                        System.out.println("Benvido, "+user.getNome());
                        // Pechamos o loop da pantalla principal para poder ir ó seguinte menu
                        secundario = true;
                        principal = false;
                    }

                    // Sign Up
                    case 'r' -> {
                        // Inicializamos as variables necesarias para poder facer o rexistro
                        String pswS;
                        System.out.println("Introduza seu nome de pila:");
                        String nome = scanner.nextLine();
                        String username;

                        while(true){
                            // Comprobamos que o nome de usuario non se repita
                            System.out.println("Introduza seu nome de usuario:");
                            username = scanner.nextLine();
                            if(rexistro.keySet().contains(username)) System.out.println("Ese nome de usuario xa existe, tente de novo.");
                            else break;
                        }

                        while (true){
                            System.out.println("Introduza seu contrasinal:");
                            pswS = scanner.nextLine();
                            char[] psw = pswS.toCharArray();

                            // Comprobamos que sexa válido
                            if(!checkValidPsw(psw)){
                                System.out.println("Contrasinal inválido, debe conter unha maiúsucla, minúscula e un número.");
                                continue;
                            }

                            // Comprobamos que sexa correcto
                            System.out.println("Introduza o contrasinal outra vez");
                            if (!scanner.nextLine().equals(pswS)){
                                System.out.println("Os contrasinais non coinciden.");
                                continue;
                            }
                            break;
                        }

                        // Creamos o novo usuario con tódolos datos e engadímolo ó rexistro
                        Usuario novoUser = new Usuario(nome, username, HashPassword.hashPassword(pswS));
                        rexistro.put(username, novoUser);
                        System.out.println("Rexistrado correctamente!");
                    }

                    // Sair do programa
                    case 's' -> {
                        System.out.println("Saindo do programa...");
                        // Pechamos o scanner e todas as variables para sair de tódolos bucles
                        scanner.close();
                        principal = false;
                        secundario = false;
                        programa = false;
                        break;
                    }

                    // Opción inválida
                    default -> {
                        System.out.println("Opción inválida, tente de novo.");
                    }
                }
            }

            // Menú secundario logo do login
            while (secundario) {

                // Esto é para que non me aparezca amarelo no scanner por non pechalo
                @SuppressWarnings("resource")
                Scanner scanner = new Scanner(System.in);
                System.out.println("Que desexa facer?\n\ta) Modificar nome\n\tb) Ingresar tarefa pendente\n\tc) Mostrar tarefas pendentes\n\t"+
                                "d) Marcar tarefa como realizada\n\te) Mostrar tarefas pendentes nas próximas 48 horas\n\tf) Mostrar tarefas realizadas\n\t"+
                                "g) Mostrar tarefas pendentes pero que se sobrepasou a data e hora límite\n\th) Cerrar sesión");
                char opc = scanner.nextLine().charAt(0);

                switch (opc) {

                    // Cambiar o nome
                    case 'a' -> {
                        System.out.println("Introduza o novo nome:");
                        String newName = scanner.nextLine();
                        user.setNome(newName);
                        System.out.println("Nome modificado correctamente.\n");
                    }

                    // Engadir tarefa sin finalizar
                    case 'b' -> {
                        System.out.println("Introduza o nome da nova tarefa:");
                        String newName = scanner.nextLine();
                        System.out.println("Introduza a descricion da nova tarefa:");
                        String newDescricion = scanner.nextLine();
                        System.out.println("Introduza a daa límite da tarefa (dd/MM/yyyy HH:mm)");
                        String newDataRaw = scanner.nextLine();
                        LocalDateTime newData = LocalDateTime.parse(newDataRaw, formatoPrincipal);
                        Tarefa newTarefa = new Tarefa(newName, newDescricion, newData);
                        user.addTarefas(newTarefa);
                        System.out.println("Nova tarefa engadida correctamente.");
                    }

                    // Mostrar tarefas pendientes
                    case 'c' -> {

                        // Copiamos a lista de tódalas tarefas
                        ArrayList<Tarefa> tarefas = user.getTarefas();
                        // Comprobamos que non estea vacía
                        if (checkListEmpty(tarefas)) continue;
                        // Creamos unha nova lista para as tarefas que estan pendientes
                        ArrayList<Tarefa> pendientes = new ArrayList<Tarefa>();
                        // Comprobamos unha por unha
                        for(Tarefa tarefa: tarefas){
                            boolean isAfter = tarefa.getLimite().isAfter(LocalDateTime.now());
                            boolean isPending = !tarefa.isCompletada();
                            // Se a tarefa está pendiente engádese á nova lista, se non continúase
                            if(isAfter && isPending) pendientes.add(tarefa);
                        }
                        // Comprobamos que haxa tarefas na nova lista
                        if (checkListEmpty(tarefas)) continue;
                        // Mostramos as tarefas e dámoslle a opción ó usuario de ver os detalles
                        selecEMostrar(pendientes, false);
                        // Todo este proceso repítese nos seguintes apartados pero o único que cambia son as condicións para engadir as tarefas á nova lista
                    }

                    // Cambiar o estado das tarefas de incompletas a completadas
                    case 'd' -> {
                        ArrayList<Tarefa> tarefas = user.getTarefas();
                        if (checkListEmpty(tarefas)) continue;
                        ArrayList<Tarefa> pendientes = new ArrayList<Tarefa>();
                        for(Tarefa tarefa: tarefas){
                            boolean isAfter = tarefa.getLimite().isAfter(LocalDateTime.now());
                            boolean isPending = !tarefa.isCompletada();
                            if(isAfter && isPending) pendientes.add(tarefa);
                        }
                        if (checkListEmpty(tarefas)) continue;
                        int opc2 = selecEMostrar(pendientes, true);
                        // Unha vez se lle mostra ó usario que tarefas están sen completar, este escolle cal quere cambiar (a liña de arriba) e cámbiase
                        pendientes.get(opc2-1).changeCompletada();
	                    System.out.println("Tarefa modificada correctamente!");
                    }

                    // Mostrar tarefas pendientes nas próximas 48h
                    case 'e' -> {
                        ArrayList<Tarefa> tarefas = user.getTarefas();
                        if (checkListEmpty(tarefas)) continue;
                        ArrayList<Tarefa> pendientes = new ArrayList<Tarefa>();
                        for(Tarefa tarefa: tarefas){
                            boolean isBetween = tarefa.getLimite().isAfter(LocalDateTime.now()) && tarefa.getLimite().isBefore(LocalDateTime.now().plus(2, ChronoUnit.DAYS));
                            boolean isPending = !tarefa.isCompletada();
                            if(isBetween && isPending) pendientes.add(tarefa);
                        }
                        if (checkListEmpty(tarefas)) continue;
                        selecEMostrar(pendientes, false);
                    }

                    // Mostrar tarefas completadas
                    case 'f' -> {
                        ArrayList<Tarefa> tarefas = user.getTarefas();
                        if (checkListEmpty(tarefas)) continue;
                        ArrayList<Tarefa> completadas = new ArrayList<Tarefa>();
                        for(Tarefa tarefa: tarefas){
                            if(tarefa.isCompletada()) completadas.add(tarefa);
                        }
                        if (checkListEmpty(tarefas)) continue;
                        selecEMostrar(completadas, false);
                    }

                    // Mostrar tarefas que se pasan do límite de entrega
                    case 'g' -> {
                        ArrayList<Tarefa> tarefas = user.getTarefas();
                        if (checkListEmpty(tarefas)) continue;
                        ArrayList<Tarefa> pendientes = new ArrayList<Tarefa>();
                        for(Tarefa tarefa: tarefas){
                            boolean isBefore = tarefa.getLimite().isBefore(LocalDateTime.now());
                            boolean isPending = !tarefa.isCompletada();
                            if(isBefore && isPending) pendientes.add(tarefa);
                        }
                        if (checkListEmpty(tarefas)) continue;
                        selecEMostrar(pendientes, false);
                    }

                    // Cerrar sesión e volver ó menú principal
                    case 'h' -> {
                        System.out.println("Cerrando sesión...");
                        secundario = false;
                        principal = true;
                        break;
                    }

                    // Opción inválida
                    default -> {
                        System.out.println("Opción inválida, tente de novo.");
                    }
                }
            }
        }
    }

    /**
     * Comproba se unha arraylist esttá valeira ou é nula
     * @param lista lista a comprobar
     * @return boolean de se está valeira ou non
     */
    public static boolean checkListEmpty(ArrayList<Tarefa> lista){
        boolean check = false;
        if (lista == null || lista.size() == 0){
            System.out.println("Non hai tarefas!");
            check = true;
        }
        return check;
    }

    /**
     * Mostra unha lista de tarefas ó usuario e dalle a opción de ver os detalles
     * @param lista lista de tarefas
     * @param especial normalmente false, só e true no caso de cambiar o estado da tarefa xa que debe devolver un íncide para poder facer o cambio
     * @return normalmente nada, se o caso é especial un int que será o índice da tarefa a modificar
     */
    public static int selecEMostrar(ArrayList<Tarefa> lista, boolean especial){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int opc2;
        while(true){
            int contador = 0;
            // Mostramos as tarfas da lista
            for(Tarefa tarefa:lista){
                contador++;
                System.out.println(contador+") "+tarefa.getNome());
            }
            // Dámoslle a opción ó usuario de mostrar detalles
            System.out.println("Seleccione unha tarefa (0 para sair):");
            opc2 = scanner.nextInt();
            if (opc2 == 0) break;
            if(opc2 > lista.size() || opc2 < 0){
                System.out.println("Tarefa inválida.");
                continue;
            }
            // Para mostrar deralles:
            Tarefa tarefaSelec = lista.get(opc2-1);
            System.out.println("-"+tarefaSelec.getNome()+"\n\tDescrición: "+tarefaSelec.getDescricion()+"\n\tData límite: "+
                            tarefaSelec.getLimite().format(formatoPrincipal)+"\n\tEngadida o: "+tarefaSelec.getEngadida().format(formatoPrincipal));
            if (especial) break;
        }
        return opc2;
    }

    /**
     * Comproba que un contrasinal sexa válida
     * @param psw contrasinal a comprobar
     * @return boolean, true se é válida
     */
    public static boolean checkValidPsw(char[] psw){
        // booleans que fan as comprobacións
        boolean maiuscula = false;
        boolean minuscula = false;
        boolean numero = false;
        // imos caracter por caracter comprobando que teña mínimo
        for(char c:psw){
            // unha maiúscula
            if (!maiuscula && ((int)c >= 65 && (int)c <= 90)){
                maiuscula = true;
                continue;
            }
            // unha minúscula
            if (!minuscula && ((int)c >= 97 && (int)c <= 122)){
                minuscula = true;
                continue;
            }
            // un número
            if (!numero && ((int)c >= 48 && (int)c <= 57)){
                numero = true;
            }
        }
        // devolve os booleans, so será true se todos son true
        return (numero && minuscula && maiuscula);
    }

    // Estes dous métodos son so para engadir datos, ignorar
    public static void addUsers(){
        for(int i = 0; i < 4; i++){
            String username = "User"+i;
            String name = "Name"+i;
            String pswS = "Psw"+i;
            Usuario newUser = new Usuario(username, name, HashPassword.hashPassword(pswS));
            rexistro.put(username, newUser);
        }
    }
    public static void addTarefas(){
        LocalDateTime data = LocalDateTime.now();
        for(Usuario user:rexistro.values()){
            for(int i = 0; i<5; i++){
                data = data.plus(2, ChronoUnit.HOURS);
                Tarefa newTarefa = new Tarefa("Tarefa"+i, "Descricion"+i, data);
                if(i%2==0) newTarefa.changeCompletada();
                user.addTarefas(newTarefa);
            }
        }
    }
}