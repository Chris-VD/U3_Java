import java.time.LocalDate;
import java.util.ArrayList;

public class App{
    public static void main(String[] Args){
        ArrayList<Deportista> deportistas = new ArrayList<>();
        ArrayList<Tenista> tenistas = new ArrayList<>();
        ArrayList<Piloto> pilotos = new ArrayList<>();
        ArrayList<PilotoF1> pilotosF1 = new ArrayList<>();
        ArrayList<PilotoMotoGP> pilotosMotoGP = new ArrayList<>();

        Tenista novoTenista = new Tenista("Jonás Alcaraz", "Carlos Alcaraz", LocalDate.of(1987, 5, 22), 3);
        Tenista novoTenista2 = new Tenista("Novak Djokovic", "Djokovic", LocalDate.of(1981, 7, 22), 2);
        PilotoF1 novoPilotoF1 = new PilotoF1("Fernando Alonsio Díaz", "Fernando Alonso", LocalDate.of(1981, 7, 29), "Aston Martin", 33, 26, 22);
        PilotoF1 novoPilotoF12 = new PilotoF1("Max Emilian Verstappen", "Verstappen", LocalDate.of(1997, 9, 30), "Red Bull Racing", 62, 33, 40);
        PilotoMotoGP novoMotoGP = new PilotoMotoGP("Marc Márquez Alentà", "Marc Márquez", LocalDate.of(1993, 2, 17), "Grenesi Racing", 102);
        PilotoMotoGP novoMotoGP2 = new PilotoMotoGP("Francesco Bagnaia", "Bagnaia", LocalDate.of(1997, 1, 14), "Ducati Lenovo Team", 461);

        deportistas.add(novoTenista);
        deportistas.add(novoTenista2);
        deportistas.add(novoPilotoF1);
        deportistas.add(novoPilotoF12);
        deportistas.add(novoMotoGP);
        deportistas.add(novoMotoGP2);

        pilotos.add(novoPilotoF1);
        pilotos.add(novoPilotoF12);
        pilotos.add(novoMotoGP);
        pilotos.add(novoMotoGP2);

        tenistas.add(novoTenista);
        tenistas.add(novoTenista2);

        pilotosF1.add(novoPilotoF1);
        pilotosF1.add(novoPilotoF12);

        pilotosMotoGP.add(novoMotoGP);
        pilotosMotoGP.add(novoMotoGP2);

        for (Deportista d:deportistas){
            System.out.println(d.toString());
        }

        System.out.println();

        for (Piloto p:pilotos){
            System.out.println(p.toString());
        }

        System.out.println();

        for (Tenista t:tenistas){
            System.out.println(t.toString());
        }

        System.out.println();

        for (PilotoF1 pf:pilotosF1){
            System.out.println(pf.toString());
        }

        System.out.println();

        for (PilotoMotoGP pmgp:pilotosMotoGP){
            System.out.println(pmgp.toString());
        }
    }
}