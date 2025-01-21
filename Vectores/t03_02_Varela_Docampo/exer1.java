import java.util.Scanner;

public class exer1 {
    /*
    Exercicio 4. Deséxase xestionar as notas de estudantes dun curso mediante matrices en Java. O exercicio consiste en almacenar as notas de varios estudantes en diferentes módulos.
    Primeiro indicaranse o número de estudantes.
    A continuación indicarase o número de módulos.
    A continuación engadiranse as notas de cada estudante módulo a módulo.
    Unha vez introducidos as notas do alumnado mostrarase o seguinte menú utilizando a estrutura switch:
    a) Media dun alumno/a: pedirase o índice do alumno e calcularase a media das súas notas.
    b) Porcentaxe de aprobados: calcularase a porcentaxe de aprobados do módulo do que se introduza o índice. 
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Este programa deixarache almacenar os datos sobre os alumnos coas suas notas en caa módulo.");
        System.out.println("Introduza o número de alumnos:");
        int numAlumnos = scanner.nextInt();
        String[] alumnos = new String[numAlumnos];
        System.out.println("Introduza o número de módulos:");
        int numModulos = scanner.nextInt();
        String[] modulos = new String[numModulos];
        System.out.println("Introduza o nome dos alumnos un por un.");
        for (int i = 0; i < alumnos.length; i++){
            System.out.println("Nome de alumno:");
            String newAlumno = scanner.next();
            alumnos[i] = newAlumno;
        }
        System.out.println("Introduza o nome dos módulos un por un.");
        for (int i = 0; i < modulos.length; i++){
            System.out.println("Nome do módulo:");
            String newModulo = scanner.next();
            modulos[i] = newModulo;
        }
        double[][] notas = new double[numModulos][numAlumnos];
        for (int i = 0; i < alumnos.length; i++){
            System.out.println("Introduza as notas de "+alumnos[i]);
            for (int j = 0; j < modulos.length; j++){
                System.out.println(modulos[j]);
                double newNota = scanner.nextDouble();
                notas[j][i] = newNota;
            }
        }
        System.out.println("Datos introducidos.");
        boolean menu = true;
        while(menu){
            System.out.println("a)Ver a media dun alumno \nb)Ver o porcentaxe de aprobados dun módulo \nc)Sair");
            String opcion = scanner.next();
            switch (opcion) {
                case "a":
                    System.out.println("Ver a media de que alumno?");
                    int alumnoSelec;
                    while(true){
                        for(int i = 0; i < alumnos.length; i++){
                            System.err.println(i+") "+alumnos[i]);
                        }
                        alumnoSelec = scanner.nextInt();
                        if (alumnoSelec > alumnos.length){
                            System.out.println("Opción inválida.");
                            continue;
                        }
                        else{
                            break;
                        }
                    }
                    double suma = 0;
                    for(int i = 0; i < modulos.length; i++){
                        suma = suma + notas[i][alumnoSelec];
                    }
                    double media = suma / modulos.length;
                    System.out.println("A media do alumno "+alumnos[alumnoSelec]+" é "+media);
                    break;
                case "b":
                    System.out.println("Ver porcentaxe de aprobados de que módulo?");
                    int moduloSelec;
                    while (true) {
                        for(int i = 0; i < modulos.length; i++){
                            System.out.println(i+") "+modulos[i]);
                        }
                        moduloSelec = scanner.nextInt();
                        if (moduloSelec > modulos.length){
                            System.out.println("Opción inválida.");
                            continue;
                        }
                        else{
                            break;
                        }
                    }
                    int aprobados = 0;
                    for(int i = 0; i < alumnos.length; i++){
                        System.out.println(alumnos[i]+" "+modulos[moduloSelec]);
                        if(notas[moduloSelec][i] >= 5){
                            aprobados++;
                        }
                    }
                    System.out.println(aprobados+" "+alumnos.length);
                    double procentaxe = ((double)aprobados / (double)alumnos.length) * 100;
                    System.out.println("O porcentaxe de aprobados no módulo "+modulos[moduloSelec]+" é "+procentaxe);
                    break;
                case "c":
                    System.out.println("Finalizando programa");
                    menu = false;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
        scanner.close();   
    }
}
