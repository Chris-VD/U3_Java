import java.util.ArrayList;

public class App {
    public static void main(String[] args){
        ArrayList<Email> emails = new ArrayList<>();
        ArrayList<EmailSanClemente> emailsSC = new ArrayList<>();
        String[] emailsRaw = {
            "maria.gomez@iessanclemente.net",
            "juan.perez@gmail.com",
            "laura.fernandez@iessanclemente.net",
            "laura.fernandeziessanclemente.net",
            "carlos.rodriguez@yahoo.com",
            "ana.martinez@iessanclemente.net",
            "pedro.lopez@hotmail.com",
            "sofia.rivas@iessanclemente.net",
            "miguel.vazquez@outlook.com",
            "paula.castro@iessanclemente.net",
            "david.sanchez@protonmail.com",
            "david.sanchez@protonmail"
        };

        for (String email:emailsRaw){
            try {
                Email novoEmail = new Email(email);
                emails.add(novoEmail);
            } catch (EmailInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println();

        for (String email:emailsRaw){
            try {
                EmailSanClemente novoClemente = new EmailSanClemente(email);
                emailsSC.add(novoClemente);
            } catch (EmailInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println();

        for (Email email:emails){
            System.out.println(email.toString());
        }
        
        System.out.println();

        for (EmailSanClemente email:emailsSC){
            System.out.println(email.toString());
        }
    }
}
