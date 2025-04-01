package vista;

public class MenuAdmin extends Menu{
    @Override
    protected void mostrar(){
        this.printMessage("Benvido, admin.");
        boolean adminMenu = true;
        while (adminMenu){
            // TODO
            this.printMessage("Que desexa facer?\na) Engadir un produto\nb) Ver produtos");
        }
    }
    
}
