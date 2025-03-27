import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class App{
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] Args){
        ArrayList<Deportista> deportistas = new ArrayList<>();
        ArrayList<Tenista> tenistas = new ArrayList<>();
        ArrayList<Piloto> pilotos = new ArrayList<>();
        ArrayList<PilotoF1> pilotosF1 = new ArrayList<>();
        ArrayList<PilotoMotoGP> pilotosMotoGP = new ArrayList<>();

        Tenista novoTenista = new Tenista("Jonás Alcaraz", "Carlos Alcaraz", LocalDate.of(1987, 5, 22), 3);
        Tenista novoTenista2 = new Tenista("Novak Djokovic", "Djokovic", LocalDate.of(1981, 7, 22), 2);
        Tenista novoTenista3 = new Tenista("Jannik Sinner", "Sinner", LocalDate.of(2001, 8, 16), 1);
        PilotoF1 novoPilotoF1 = new PilotoF1("Fernando Alonsio Díaz", "Fernando Alonso", LocalDate.of(1981, 7, 29), "Aston Martin", 33, 26, 22);
        PilotoF1 novoPilotoF12 = new PilotoF1("Max Emilian Verstappen", "Verstappen", LocalDate.of(1997, 9, 30), "Red Bull Racing", 62, 33, 40);
        PilotoMotoGP novoMotoGP = new PilotoMotoGP("Marc Márquez Alentà", "Marc Márquez", LocalDate.of(1993, 2, 17), "Grenesi Racing", 102);
        PilotoMotoGP novoMotoGP2 = new PilotoMotoGP("Francesco Bagnaia", "Bagnaia", LocalDate.of(1997, 1, 14), "Ducati Lenovo Team", 461);

        deportistas.add(novoTenista);
        deportistas.add(novoTenista2);
        deportistas.add(novoTenista3);
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
        tenistas.add(novoTenista3);

        pilotosF1.add(novoPilotoF1);
        pilotosF1.add(novoPilotoF12);

        pilotosMotoGP.add(novoMotoGP);
        pilotosMotoGP.add(novoMotoGP2);

        Comparator comparadorPilotos = new Comparator<Piloto>() {
            public int compare(Piloto p1, Piloto p2){
                return p2.getPuntos() - p1.getPuntos();
            }
        };

        Collections.sort(deportistas);
        for (Deportista d:deportistas){
            System.out.println(d.toString());
        }

        System.out.println();

        Collections.sort(pilotos, comparadorPilotos);
        for (Piloto p:pilotos){
            System.out.println(p.toString());
        }

        System.out.println();

        Collections.sort(tenistas, new Comparator<Tenista>() {
            public int compare(Tenista t1, Tenista t2){
                return t1.getRankingMundial() - t2.getRankingMundial();
            }
        });
        for (Tenista t:tenistas){
            System.out.println(t.toString());
        }

        System.out.println();

        Collections.sort(pilotosF1, comparadorPilotos);
        for (PilotoF1 pf:pilotosF1){
            System.out.println(pf.toString());
        }

        System.out.println();

        Collections.sort(pilotosMotoGP, comparadorPilotos);
        Collections.reverse(pilotosMotoGP);
        for (PilotoMotoGP pmgp:pilotosMotoGP){
            System.out.println(pmgp.toString());
        }
    }
}