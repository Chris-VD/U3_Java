package utils;

import modelo.excepcions.ISBNInvalidoExcepcion;

public class ComprobadorISBN {
    public static void comprobarISBN(String isbn) throws ISBNInvalidoExcepcion{
        if (isbn.length() != 10) throw new ISBNInvalidoExcepcion("O ISBN "+isbn+" e inválido");
        Integer numeros;
        try {
            numeros = Integer.parseInt(isbn.substring(0, 9));
        } catch (Exception e) {
            throw new ISBNInvalidoExcepcion("O ISBN "+isbn+" e inválido");
        }
        int temp = 0;
        int i = 0;
        for (char c:String.valueOf(numeros).toCharArray()){
            i++;
            temp += c*i;
        }
        int resto = temp % 11;
        if (resto != isbn.charAt(9) && ((resto == 10 && 'X' != isbn.charAt(9)))) throw new ISBNInvalidoExcepcion("O ISBN "+isbn+" e inválido");
    }
}
