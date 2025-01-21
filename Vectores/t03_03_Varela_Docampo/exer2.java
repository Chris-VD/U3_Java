import java.util.Scanner;

public class exer2 {
    public static void main(String[] args) {

        // Pedimos os valores
        Scanner scanner = new Scanner(System.in);
        System.out.println("Número de pasaxeiros no piso superior:");
        int superior = scanner.nextInt();
        System.out.println("Número de pasaxeiros no piso inferior:");
        int inferior = scanner.nextInt();

        // num é o número total de pasaxeiros, o can podemos empregar para achegarnos ó rango.
        int num = superior + inferior;
        int suma = 0;
        for (int i = 0; i<=num;i++){
            suma = suma + i;
        }
        suma++;
        // Ó facer a secuencia, este número é o da esquerda (1, 2, 4, 7, 11). Sabendo esto podemos saber cal é noso rango, xa que...

        // Se lle sumamos o número de superiores, por como está feito o esquema, danos o rango directamente!
        int rango = suma + superior;
        System.out.println("O rango de esta combinación é "+rango);
        scanner.close();
    }
}
