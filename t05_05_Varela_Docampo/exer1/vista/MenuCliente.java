package vista;

import controlador.TendaMusica;
import modelo.excepcions.IdentificadorInvalidoExcepcion;
import modelo.excepcions.StockAEliminarInvalido;
import modelo.excepcions.StockInsuficienteExcepcion;

public class MenuCliente extends Menu{
    @Override
    protected void mostrar(){
        this.printMessage("Benvido, cliente.");
        boolean clienteMenu = true;
        while (clienteMenu){
            String opc = this.getString("Que desexa facer?\na) Ver produtos\nb) Compar produto");
            try {
                switch (opc) {
                    case "a"->{
                        new MenuMostrarProdutos().run();
                    }
                    case "b"->{
                        String pId = this.getString("Introduza o ID do produto: ");
                        TendaMusica.getInstance().comprarProduto(pId);
                        this.printMessage("Produto comprado correctamente.");
                    }
                    default->{
                        this.printMessage("Opción inválida, tente de novo.");
                    }
                }
            } catch (IdentificadorInvalidoExcepcion e) {
                this.printMessage(e.getMessage());
            }
            catch (StockInsuficienteExcepcion e) {
                this.printMessage(e.getMessage());
            }
            catch (StockAEliminarInvalido e) {
                this.printMessage(e.getMessage());
            }
        }
    }
}
