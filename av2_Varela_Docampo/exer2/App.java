package exer2;

import java.util.Optional;

public class App{
    public static void main(String[] args) throws Exception {

        /////////////// Test producto escalar
        int[][] vectores1 = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 1, 0, -1 },
            { 3, 3, 3, 3 }
        };
        int[][] vectores2 = {
            { 4, 5, 6 },
            { 1, 1, 1 },
            { -1, 0, 1 },
            { 2, 2, 2 }
        };

        for (int i = 0; i < vectores1.length; i++) {
            Optional<Integer> resultado = productoEscalar(vectores1[i], vectores2[i]);
            if (resultado.isPresent())
                System.out.println("O producto escalor dos vectores é " + resultado.get());
            else
                System.out.println("Non se pode calcular o producto escalar");
        }

        /////////////////// Test distancia dous puntos
        double[][] puntos1 = {
            { 1.0, 2.0 },
            { 3.0, 4.0 },
            { 0.0, 0.0 },
            { 1.0 }
        };
        double[][] puntos2 = {
            { 4.0, 6.0 },
            { 0.0, 0.0 },
            { 1.0, 1.0 },
            { 2.0, 3.0 }
        };

        for (int i = 0; i < puntos1.length; i++) {
            Optional<Double> resultado = distanciaEntreDousPuntos(puntos1[i], puntos2[i]);
            if (resultado.isPresent())
                System.out.println("A distancia entre dous puntos é: " + resultado.get());
            else
                System.out.println("Non se pode calcular a distancia entre estes dous puntos");
        }

        /////////////////// Test matriz identidade
        int[][][] matrices = {
            {
                { 1, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 1 }
            },
            {
                { 1, 0, 0 },
                { 0, 1, 0 },
                { 1, 0, 1 }
            },
            {
                { 1, 0 },
                { 0, 1 }
            },
            {
                { 1, 0, 0 },
                { 0, 2, 0 },
                { 0, 0, 1 }
            },
            {
                { 1, 0, 0 },
                { 0, 1, 0 }
            }
        };

        for (int i = 0; i < matrices.length; i++) {
            boolean identidade = eMatrizIdentidade(matrices[i]);
            System.out.println("A matriz" + (identidade ? " é " : " non é ") + "unha matriz identidade.");
        }
    }

    /**
     * Calcula o produto escalar de dous vectores
     * @param vector1 
     * @param vector2
     * @return Optional<Integer> -> Optional.empty() se non se pode calcular o produto escalar
     */
    public static Optional<Integer> productoEscalar(int[] vector1, int[] vector2){
        Integer resultado = 0;

        // Comprobamos que os vectores teñan a mesma lonxitude para poder facer o produto escalar
        if (vector1.length != vector2.length){
            // Devolvemos un Optional.empty() en vez de null
            return Optional.empty();
        }

        // Imos posición por posición calculando o produto e sumandoo a resultado
        for(int i = 0; i<vector1.length; i++){
            resultado += vector1[i] * vector2[i];
        }

        // Devolvemos o resultado
        return Optional.of(resultado);
    }

    /**
     * Calcula a distancia entre dous puntos
     * @param vector1
     * @param vector2
     * @return  Optional<Double> -> Optional.empty() se os vectores instroducidos teñen máis de 2 elementos (non son un punto)
     */
    public static Optional<Double> distanciaEntreDousPuntos(double[] vector1, double[] vector2){
        Double distancia;

        // Comprobamos que os vectores introducidos so teñan dous elementos (se teñen máis ou menos non son un punto no eixo de coordenadas)
        if (vector1.length != 2 || vector2.length != 2){
            // Devolvemos un Optional.empty() en vez de null
            return Optional.empty();
        }

        // Para calcular a distancia entre dous puntos pensamos como se cada un dos punto fose un vértice dun triángulo equilátero, calculamos a base e a altura así
        double b = vector1[0] - vector2[0]; // Base
        double a = vector1[1] - vector2[1]; // Altura

        // Empregamos o teorema de pitágoras para obter a distancia
        distancia = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

        // Devolvemos a distancia
        return Optional.of(distancia);
    }

    /**
     * Comproba se unha matriz é identidade
     * @param matriz
     * @return boolean -> true se é identidade e false se non
     */
    public static boolean eMatrizIdentidade(int[][] matriz){
        
        // Comprobamos que a matriz introducida sexa cadrada
        if(matriz.length != matriz[0].length){
            // Se non o é, devovlemos false
            return false;
        }

        // Recorremos ambas matrices á vez
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                // Se o íncide que estamos comprobando é o mesmo en ambas matrices, quere dicir que para que sexa idendidade este ten que ser un 1
                if(i == j){
                    // Se non o é devolvemos false
                    if(matriz[i][j] != 1) return false;
                }
                // Para calquer outro valor, se non é 0 tamén devolvemos false
                else if(matriz[i][j] != 0) return false;
            }
        }

        // Se unha vez recorridas as matrices non se devolveu falso, é unha matrice identidade e devovlemos true
        return true;
    }
}