package exer2;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] Args){
        Scanner scanner = new Scanner(System.in);
        boolean principal = true;
        boolean secundario = false;
        boolean programa = true;
        scanner.close();
        while (programa) {
            while (principal) {
                System.out.println("Benvido, que desexa facer?\n\ti) Iniciar sesión\n\tr) Rexistrarse\n\ts) Sair do programa");
                char opc = scanner.nextLine().charAt(0);
                switch (opc) {
                    case 'i' -> {

                    }   
                    case 'r' -> {
                        String pswS;
                        System.out.println("Introduza seu nome de pila:");
                        String nome = scanner.nextLine();
                        System.out.println("Introduza seu nome de usuario:");
                        String username = scanner.nextLine();
                        while (true){
                            System.out.println("Introduza seu contrasinal:");
                            pswS = scanner.nextLine();
                            char[] psw = pswS.toCharArray();
                            if(!checkValidPsw(psw)){
                                System.out.println("Contrasinal inválido, debe conter unha maiúsucla, minúscula e un número.");
                                continue;
                            }
                            System.out.println("Introduza o contrasinal outra vez");
                            if (!scanner.nextLine().equals(pswS)){
                                System.out.println("Os contrasinais non coinciden.");
                                continue;
                            }
                            else System.out.println("Rexistrado correctamente!");
                            break;
                        }
                        Usuario novoUser = new Usuario(nome, username, new ArrayList<Tarefa>(), HashPassword.hashPassword(pswS));
                    }
                    case 's' -> {
                        System.out.println("Saindo do programa...");
                        scanner.close();
                        principal = false;
                        secundario = false;
                        programa = false;
                        break;
                    }
                    default -> {
                        System.out.println("Opción inválida, tente de novo.");
                    }
                }
            }
            while (secundario) {
                // FIXME
                System.out.println("Benvido ");
                System.out.println("Que desexa facer?\n\ta) Modificar nome\n\tb) Ingresar tarefa pendent\n\tc) Mostrar tarefas pendentes\n\t"+
                                "d) Marcar tarefa como realizada\n\te) Mostrar tarefas pendentes nas próximas 48 horas\n\t f) Mostrar tarefas realizadas\n\t"+
                                "g) Mostrar tarefas pendentes pero que se sobrepasou a data e hora límite\n\th) Cerrar sesión");
                char opc = scanner.nextLine().charAt(0);
                switch (opc) {
                    case 'a' -> {

                    }
                    case 'b' -> {

                    }
                    case 'c' -> {

                    }
                    case 'd' -> {

                    }
                    case 'e' -> {

                    }
                    case 'f' -> {

                    }
                    case 'g' -> {

                    }
                    case 'h' -> {
                        System.out.println("Cerrando sesión...");
                        secundario = false;
                        principal = true;
                        break;
                    }
                    default -> {
                        System.out.println("Opción inválida, tente de novo.");
                    }
                }
            }
        }
    }
    public static boolean checkValidPsw(char[] psw){
        boolean maiuscula = false;
        boolean minuscula = false;
        boolean numero = false;
        for(char c:psw){
            if (!maiuscula && ((int)c >= 65 && (int)c <= 90)){
                maiuscula = true;
                continue;
            }
            if (!minuscula && ((int)c >= 97 && (int)c <= 122)){
                minuscula = true;
                continue;
            }
            if (!numero && ((int)c >= 48 && (int)c <= 57)){
                numero = true;
            }
        }
        return (numero && minuscula && maiuscula);
    }
}