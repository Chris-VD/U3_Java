package vista;

import controlador.TendaMusica;
import modelo.excepcions.ISBNInvalidoExcepcion;
import modelo.excepcions.PrezoMenorZeroExcepcion;
import modelo.excepcions.StockMenorZeroExcepcion;
import utils.EnumInstrumentos;
import utils.EnumSaxofons;

public class MenuEngadirProduto extends Menu {
    @Override
    protected void mostrar(){
        this.printMessage("Seleccione que tipo de produto quere engadir:");
        boolean engadirMenu = true;
        while (engadirMenu) {
            this.printMessage("a) Frauta\nb) Saxofón\nc) Trombón\nd) Libro\ne) Estoxo\ns) Sair");
            String opc = this.getString("> ");
            double prezo;
            String descricion;
            int stock;
            String marca;
            String modelo;
            try {
                switch (opc) {
                    case "a" ->{
                        prezo = this.getDouble("Introduza o prezo do produto: ");
                        descricion = this.getString("Introduza a descrición do produto: ");
                        stock = this.getInt("Introduza o stock actual do prouto");
                        marca = this.getString("Introduza a marca do produto: ");
                        modelo = this.getString("Introduza o modelo do produto: ");
                        boolean pds = this.getString("A frauta ten pe de Si? (Y/N) ").equals("Y") ? true:false;
                        TendaMusica.getInstance().engadirFrauta(prezo, descricion, stock, marca, modelo, pds);
                    }
                    case "b" ->{
                        prezo = this.getDouble("Introduza o prezo do produto: ");
                        descricion = this.getString("Introduza a descrición do produto: ");
                        stock = this.getInt("Introduza o stock actual do prouto");
                        marca = this.getString("Introduza a marca do produto: ");
                        modelo = this.getString("Introduza o modelo do produto: ");
                        EnumSaxofons tipo;
                        String opc2 = this.getString("Que tipo de saxofón é?\na) Soprano\nb) Tenor\nc) Alto\nd) Barítono");
                        switch (opc2) {
                            case "a"->{
                                tipo = EnumSaxofons.SOPRANO;
                            }
                            case "b"->{
                                tipo = EnumSaxofons.TENOR;
                            }
                            case "c"->{
                                tipo = EnumSaxofons.ALTO;
                            }
                            case "d"->{
                                tipo = EnumSaxofons.BARÍTONO;
                            }
                            default->{
                                this.printMessage("Tipo inválido, abortando.");
                                continue;
                            }
                        }
                        TendaMusica.getInstance().engadirSaxofon(prezo, descricion, stock, marca, modelo, tipo);
                    }
                    case "c" ->{
                        prezo = this.getDouble("Introduza o prezo do produto: ");
                        descricion = this.getString("Introduza a descrición do produto: ");
                        stock = this.getInt("Introduza o stock actual do prouto: ");
                        marca = this.getString("Introduza a marca do produto: ");
                        modelo = this.getString("Introduza o modelo do produto: ");
                        boolean transpositor = this.getString("Ten transpositor? (Y/N) ").equals("Y") ? true:false;
                        TendaMusica.getInstance().engadirTrombon(prezo, descricion, stock, marca, modelo, transpositor);
                    }
                    case "d" ->{
                        prezo = this.getDouble("Introduza o prezo do produto: ");
                        descricion = this.getString("Introduza a descrición do produto: ");
                        stock = this.getInt("Introduza o stock actual do prouto: ");
                        String titulo = this.getString("Introduza o título do libro: ");
                        String ISBN = this.getString("Introduza o ISBN do libro: ");
                        TendaMusica.getInstance().engadirLibro(prezo, descricion, stock, titulo, ISBN);
                    }
                    case "e" ->{
                        prezo = this.getDouble("Introduza o prezo do produto: ");
                        descricion = this.getString("Introduza a descrición do produto: ");
                        stock = this.getInt("Introduza o stock actual do prouto: ");
                        marca = this.getString("Introduza a marca do estoxo: ");
                        EnumInstrumentos tipo;
                        String opc2 = this.getString("Que tipo de instrumento é?\na) Frauta\nb) Saxofón\nc) Trombón");
                        switch (opc2) {
                            case "a"->{
                                tipo = EnumInstrumentos.FRAUTA;
                            }
                            case "b"->{
                                tipo = EnumInstrumentos.SAXOFON;
                            }
                            case "c"->{
                                tipo = EnumInstrumentos.TROMBON;
                            }
                            default->{
                                this.printMessage("Tipo inválido, abortando.");
                                continue;
                            }
                        }
                        TendaMusica.getInstance().engadirEstoxo(prezo, descricion, stock, tipo, marca);
                    }
                    case "s" ->{
                        this.printMessage("Saindo...");
                        engadirMenu = false;
                    }
                    default ->{
                        this.printMessage("Opción inválida, tente de novo.");
                    }
                }
            } catch (PrezoMenorZeroExcepcion e) {
                this.printMessage(e.getMessage());
            } catch (StockMenorZeroExcepcion e) {
                this.printMessage(e.getMessage());
            } catch (ISBNInvalidoExcepcion e) {
                this.printMessage(e.getMessage());
            }
        }
    }
}
