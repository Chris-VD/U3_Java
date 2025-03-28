import java.util.regex.Matcher;

public class EmailSanClemente extends Email{
    public EmailSanClemente(String email) throws EmailInvalidoException{
        super(email);
    }

    @Override
    public boolean comprobarEmail(String email){
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()){
            return matcher.group(2).equals("@iessanclemente.net");
        }
        return false;
    }

    @Override
    public String getMessageError(String email){
        return "Esta cadea non é un correo San Clemente: "+email;
    }
}
