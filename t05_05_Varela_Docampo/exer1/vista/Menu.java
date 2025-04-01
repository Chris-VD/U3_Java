package vista;

import java.util.List;
import java.util.Scanner;

import modelo.excepcions.ConstrasinalInvalidoExcepcion;
import modelo.excepcions.UsuarioRepetidoExcepcion;

public abstract class Menu {
    private Scanner scanner;

    /**
     * Construtor de menú
     */
    public Menu(){
        scanner = new Scanner(System.in);
    }

    /**
     * Arranca o menú
     */
    public void run() throws UsuarioRepetidoExcepcion, ConstrasinalInvalidoExcepcion{
        this.mostrar();
    }

    /**
     * Método abstracto, que é necesario implantar para mostrar por terminal
     * @throws ConstrasinalInvalidoExcepcion 
     * @throws UsuarioRepetidoExcepcion 
     */
    protected abstract void mostrar() throws UsuarioRepetidoExcepcion, ConstrasinalInvalidoExcepcion;

    /**
     * Pide por teclado unha cadea de texto
     * @param frase que se mostra ao usuario
     * @return
     */
    protected String getString(String frase) {
        System.out.print(frase);
        String mensaxe = this.scanner.nextLine();
        return mensaxe;
    }

    /**
     * Pide por teclado un double
     * @param frase que se mostra ao usuario
     * @return
     */
    protected double getDouble(String frase) {
        System.out.print(frase);
        double mensaxe = this.scanner.nextDouble();
        return mensaxe;
    }

    /**
     * Pie por teclado unha frase
     * @param frase que se mostra ao usuario
     * @return
     */
    protected int getInt(String frase) {
        System.out.print(frase);
        int mensaxe = this.scanner.nextInt();
        this.scanner.nextLine(); // Limpiar buffer
        return mensaxe;
    }

    protected Boolean getBoolean(String frase){
        System.out.print(frase);
        String mensaxe = this.scanner.nextLine();
        Boolean isbool;
        if (mensaxe.equals("Y") || mensaxe.equals("Yes") || mensaxe.equals("y") || mensaxe.equals("y")) isbool = true;
        else isbool = false;
        return isbool;
    }

    /**
     * Imprime unha frase por pantalla engadindo unha nova liña
     * @param frase
     */
    protected void printMessage(String frase) {
        System.out.println(frase);
    }

    /**
     * Imprime unha lista de elementos
     * @param <T> Clase xenérica para poder realizalo cunha lista de calquera tipo
     * @param lista
     */
    protected <T> void printList(List<T> lista) {
        for(T elemento: lista) {
            printMessage(elemento.toString());
        }
    }


}