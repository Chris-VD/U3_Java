import java.util.ArrayList;

public class App {
    public static void main(String[] args){
        ArrayList<Dia> dias = new ArrayList<>();
        String[] datas = {
            "2024-06-15",       
            "15/06/2024",       
            "6/15/2024",       
            "15-06-2024",       
            "2024.06.15",
            "15/6/2015",        
            "15.06.24",         
            "15 Xuño 2024",     
            "Xuño 15, 2024",    
            "2024/06/15",
            "1/1/2000",     
            "15 de Xuño de 2024",
            "31/04/99", 
        };

        for (String data:datas){
            try {
                Dia novaData = new Dia(data);
                dias.add(novaData);
            } catch (ExcepcionDataInválida e) {
                System.out.println(data +" non se engadiu");
                System.out.println();
            }
        }

        for (Dia dia:dias){
            System.out.println(dia.toString());
        }
    }
}
