import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailSanClemente extends Email{
    public static final Pattern patternSC = Pattern.compile("([^@]+)@iessanclemente.net");

    public EmailSanClemente(String email) throws EmailInvalidoException{
        super(email);
    }

    @Override
    public boolean comprobarEmail(String email){
        Matcher matcher = patternSC.matcher(email);
        return matcher.matches();
    }

    @Override
    public String getMessageError(String email){
        return "Esta cadea non é un correo San Clemente: "+email;
    }
}
