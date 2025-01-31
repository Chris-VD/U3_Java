import concesionario.Vehiculo;
import utils.TipoCombustible;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println(Vehiculo.getNumeroTotalVehiculos()); // 0
        
        Vehiculo leon = new Vehiculo("1234CGF", "SEAT", "León");
        System.out.println(Vehiculo.getNumeroTotalVehiculos()); // 1
        Vehiculo c3 = new Vehiculo("6894DEF", "Citroen", "C3", TipoCombustible.ELECTRICO);
        System.out.println(Vehiculo.getNumeroTotalVehiculos()); // 2

        System.out.println(leon.getMatricula() + " " + leon.getTipoCombustible()); // 1234CGF GASOLINA
        System.out.println(c3.getMatricula() + " " + c3.getTipoCombustible()); // 0000XXX ELECTRICO

        leon.acelerar(20);
        leon.acelerar();
        System.out.println(leon.getVelocidade()); // 30.0

        leon.acelerar(100);
        System.out.println(leon.getVelocidade()); // 120.0

        leon.decelerar();
        leon.decelerar(200);
        System.out.println(leon.getVelocidade()); // 0.0

        Vehiculo.setVelocidadeMaxima(130);

        leon.acelerar(125);
        System.out.println(leon.getVelocidade()); // 125.0

    }

}