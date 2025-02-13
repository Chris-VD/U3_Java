package exer1;

public class App{
    public static void main(String[] Args){
        Grupo LaRaiz = new Grupo("La Raiz", 2006, "España");
        Disco EntrePoetasYPresos = new Disco("Entre Poetas Y Presos", 2016, LaRaiz, 15);
        System.out.println("Anos dende que se creou o grupo: "+LaRaiz.getIdade());
        System.out.println("Anos dende que se creou o grupo ata que sacaron o album: "+EntrePoetasYPresos.anosGrupo());
    }
}