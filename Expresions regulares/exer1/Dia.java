import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dia {
    private String data;
    public static final Pattern pattern = Pattern.compile("(\\d{1,2})/(\\d{1,2})/(\\d{2,4})");

    public Dia(String dataRaw) throws ExcepcionDataInválida{
        this.comprobarFormatoDia(dataRaw);
        dataRaw = this.cambiarFormato(dataRaw);
        this.data = dataRaw;
    }

    public boolean comprobarFormatoDia(String dia) throws ExcepcionDataInválida{
        Matcher matcher = pattern.matcher(dia);
        if (matcher.matches()) return true;
        else throw new ExcepcionDataInválida("Data inválida");
    }
    public String cambiarFormato(String dia){
        Matcher matcher = pattern.matcher(dia);
        String _dia = "";
        String _mes = "";
        String _ano = "";
        if (matcher.find()){
            _dia = matcher.group(1);
            _mes = matcher.group(2);
            _ano = matcher.group(3);
            if (matcher.group(1).length() == 1) _dia = "0"+_dia;
            if (matcher.group(2).length() == 1) _mes = "0"+_mes;
            if (matcher.group(3).length() == 2) _ano = "20"+_ano;
        }
        System.out.println("ERM "+_dia+"/"+_mes+"/"+_ano);
        return _dia+"/"+_mes+"/"+_ano;
    }
    @Override
    public String toString(){
        return data;
    }
}
