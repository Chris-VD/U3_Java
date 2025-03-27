public class ExcepcionDNIInvalido extends RuntimeException{
    public ExcepcionDNIInvalido(String msg){
        super(msg);
    }

    public static boolean comprobarDNI(String dni){
        if (dni.length() != 9) return false;
        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int numeros = Integer.parseInt(dni.substring(0, 8));
        int resta = numeros % 23;
        return (dni.charAt(8) == letras[resta]);
    }
}
