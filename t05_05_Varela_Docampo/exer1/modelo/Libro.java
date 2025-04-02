package modelo;

import modelo.excepcions.ISBNInvalidoExcepcion;
import modelo.excepcions.PrezoMenorZeroExcepcion;
import modelo.excepcions.StockMenorZeroExcepcion;
import utils.ComprobadorISBN;

public class Libro extends Complemento{
    private String titulo;
    private String isbn;

    // Constructores
    public Libro(double prezo, String descricion, int stock, String titulo, String ISBN) throws PrezoMenorZeroExcepcion, StockMenorZeroExcepcion, ISBNInvalidoExcepcion{
        super(prezo, descricion, stock);
        this.titulo = titulo;
        this.setIsbn(ISBN);
    }

    // Metodos
    @Override
    public String toString(){
        return "Libro: "+this.titulo+", ISBN: "+this.isbn+". "+super.toString();
    }

    // Getters & Setters
    public void setIsbn(String isbn) throws ISBNInvalidoExcepcion{
        ComprobadorISBN.comprobarISBN(isbn);
        this.isbn = isbn;
    }
    public String getNome(){
        return titulo;
    }
    public String getIsbn(){
        return isbn;
    }
}
