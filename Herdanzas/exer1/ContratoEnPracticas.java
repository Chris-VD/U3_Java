public class ContratoEnPracticas extends Contrato{
    private String titulacion;

    // Constructor
    public ContratoEnPracticas(String nome, String apelidos, int salarioBrutoAnual, double IRPF, String titulacion){
        super(nome, apelidos, salarioBrutoAnual, IRPF);
        this.setTitulacion(titulacion);
    }

    // Métodos
    @Override
    public String toString(){
        return super.toString()+". Titulación: "+this.getTitulacion();
    }

    // Getters & Setters
    public String getTitulacion(){
        return this.titulacion;
    }
    public void setTitulacion(String titulacion){
        this.titulacion = titulacion;
    }
}