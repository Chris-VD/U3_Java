package vista;

import controlador.TendaMusica;

public class MenuMostrarProdutos extends Menu{
    @Override
    protected void mostrar(){
        boolean produtosMenu = true;
        while (produtosMenu) {
            this.printMessage("Que desexa ver?\na) Todos os produtos\nb) Todos os isntrumentos\nc) Todas as flautas\nd) Todos os trombóns\ne) Todos os saxofóns\nf) Todos os complementos\ng) Todos os libros\nh) Todos os estoxos\ns) Sair");
            String opc = this.getString("> ");
            switch (opc) {
                case "a"->{
                    this.printMessage(TendaMusica.getInstance().mostrarProdutos());
                }
                case "b"->{
                    this.printMessage(TendaMusica.getInstance().mostrarInstrumentos());
                }
                case "c"->{
                    this.printMessage(TendaMusica.getInstance().mostrarFrautas());
                }
                case "d"->{
                    this.printMessage(TendaMusica.getInstance().mostrarTrombons());
                }
                case "e"->{
                    this.printMessage(TendaMusica.getInstance().mostrarSaxofons());
                }
                case "f"->{
                    this.printMessage(TendaMusica.getInstance().mostrarComplementos());
                }
                case "g"->{
                    this.printMessage(TendaMusica.getInstance().mostrarLibros());
                }
                case "h"->{
                    this.printMessage(TendaMusica.getInstance().mostrarEstoxos());
                }
                case "s"->{
                    this.printMessage("Saindo do menu...");
                    produtosMenu = false;
                }
                default->{
                    this.printMessage("Opción inválida, tente de novo.");
                }
            }
        }
    }
}
