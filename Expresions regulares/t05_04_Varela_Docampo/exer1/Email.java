import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    public static final Pattern pattern = Pattern.compile("([^@]+)(@[^@]+\\.[a-zA-Z]{2,})");
    private String correo;

    public Email(String email) throws EmailInvalidoException{
        this.setEmail(email);
    }

    public boolean comprobarEmail(String email){
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    public String toString(){
        return getDominio()+": "+getConta();
    }

    public String getConta(){
        Matcher matcher = pattern.matcher(correo);
        if (matcher.find()) return matcher.group(1);
        else return "CONTA MALA";
    }

    public String getDominio(){
        Matcher matcher = pattern.matcher(correo);
        if (matcher.find()) return matcher.group(2);
        else return "DOMINO MALO";
    }

    public String getMessageError(String email){
        return "Esta cadea non é un correo: " + email;
    }

    public void setEmail(String email) throws EmailInvalidoException{
        if (this.comprobarEmail(email)) this.correo = email;
        else throw new EmailInvalidoException(getMessageError(email));
    }
}
