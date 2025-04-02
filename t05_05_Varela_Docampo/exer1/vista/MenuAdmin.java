package vista;

import controlador.TendaMusica;
import modelo.excepcions.IdentificadorInvalidoExcepcion;
import modelo.excepcions.StockAEliminarInvalido;

public class MenuAdmin extends Menu{
    @Override
    protected void mostrar(){
        this.printMessage("Benvido, admin.");
        boolean adminMenu = true;
        while (adminMenu){
            this.printMessage("Que desexa facer?\na) Engadir un produto\nb) Ver produtos\nc) Ver produto concreto\nd) Engadir stock a produto\ne) Retirar stock de produto\ns) Sair");
            String opc = this.getString("> ");
            try {
                switch (opc) {
                    case "a"->{
                        new MenuEngadirProduto().run();
                    }
                    case "b"->{
                        new MenuMostrarProdutos().run();
                    }
                    case "c"->{
                        String pId = this.getString("Introduza o ID do produto.");
                        TendaMusica.getInstance().mostrarProdId(pId);
                    }
                    case "d"->{
                        String pId = this.getString("Introduza o ID do produto.");
                        TendaMusica.getInstance().mostrarProdId(pId);
                        int stockEngadir = this.getInt("Introduza o stocka a engadir: ");
                        TendaMusica.getInstance().engadirStock(pId, stockEngadir);
                    }
                    case "e"->{
                        String pId = this.getString("Introduza o ID do produto.");
                        TendaMusica.getInstance().mostrarProdId(pId);
                        int stockEngadir = this.getInt("Introduza o stocka a eliminar: ");
                        TendaMusica.getInstance().eliminarStock(pId, stockEngadir);
                    }
                    case "s"->{
                        this.printMessage("Saindo...");
                        adminMenu = false;
                    }
                    default->{
                        this.printMessage("Opción inválida, tente de novo.");
                    }
                }
            }
            catch (IdentificadorInvalidoExcepcion e) {
                this.printMessage(e.getMessage());
            }
            catch (StockAEliminarInvalido e) {
                this.printMessage(e.getMessage());
            }
        }
    }
    
}
