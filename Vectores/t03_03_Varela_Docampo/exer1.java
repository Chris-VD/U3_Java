import java.util.Scanner;

public class exer1 {
    public static void main(String[] args) {

        // Iniciamos o escaner e introducimos o programa.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Este programa calculará cantas iteracións son necesarias para chegar á constante de Kaprekar a partir do número que introduzas: ");
        int num = scanner.nextInt();

        // Definimos as variables que imos empregar.
        int dix1,dix2,dix3,dix4,maior, menor, cambio;;
        int iteracions = 1;

        // Comezamos o bucle.
        while (true){

            // Comprobamos se o número introducido é válido.
            if (num == 6174){
                System.out.println("6174 é a constante de Kaprekar");
                iteracions = 0;
                break;
            }

            // Separamos o número nos seus díxitos.
            dix4 = num%10;
            dix3 = num/10%10;
            dix2 = num/100%10;
            dix1 = num/1000%10;

            // Comprobamos que non é un repdigit.
            if (dix1==dix2 && dix2==dix3 && dix3==dix4){
                System.out.println("Non se pode chegar á constante de Kaprekar con este número");
                iteracions = -1;
                break;
            }

            // Ordenamos os díxitos
            int[] dixitos = {dix1, dix2, dix3, dix4};
            for (int i = 0; i < dixitos.length; i++){
                for (int j = i+1; j < dixitos.length; j++){
                    if (dixitos[i] > dixitos[j]){
                        cambio = dixitos[j];
                        dixitos[j] = dixitos[i];
                        dixitos[i] = cambio;
                    }
                }
            }

            // Calculamos os dous números que debemos empregar.
            menor = dixitos[0]*1000 + dixitos[1]*100 + dixitos[2]*10 + dixitos[3];
            maior = dixitos[3]*1000 + dixitos[2]*100 + dixitos[1]*10 + dixitos[0];

            // calculamos o resultado e comprobamos se xa acabamos ou non.
            num = maior - menor;
            System.out.println(maior+" - "+menor+" = "+num);
            if (num == 6174){
                break;
            }
            else{
                // Se inda non acabamos, actualizamos o contador de iteracións.
                iteracions++;
            }
        }
        
        System.out.println("Fixeron falta "+iteracions+" iteracións para chegar á constante de Kaprekar");
        scanner.close();
    }
}