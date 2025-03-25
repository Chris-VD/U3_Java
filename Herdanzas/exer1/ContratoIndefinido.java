public class ContratoIndefinido extends Contrato{
    private boolean pagaExtraProrrateada;

    // Constructor
    public ContratoIndefinido(String nome, String apelidos, int salarioBrutoAnual, double IRPF, boolean pagaExtraProrrateada){
        super(nome, apelidos, salarioBrutoAnual, IRPF);
        this.setPagaExtraProrrateada(pagaExtraProrrateada);
    }

    // Métodos
    @Override
    public double getSalarioMensualNeto(){
        if (pagaExtraProrrateada) return this.getSalarioNetoAnual()/12 + (this.getSalarioNetoAnual()/12*2)/12;
        else return this.getSalarioNetoAnual()/12;
    }

    @Override
    public String toString(){
        int pagasAnuais = pagaExtraProrrateada ? 12 : 14;
        return super.toString()+". Pagas anuais: "+pagasAnuais;
    }

    // Getters & Setters
    public void setPagaExtraProrrateada(boolean pagaExtraProrrateada){
        this.pagaExtraProrrateada = pagaExtraProrrateada;
    }
    public boolean getPagaExtraProrrateada(){
        return this.pagaExtraProrrateada;
    }
}
