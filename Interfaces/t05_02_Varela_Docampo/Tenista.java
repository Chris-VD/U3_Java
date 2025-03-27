import java.time.LocalDate;

public class Tenista extends Deportista{
    public int rankingMundial;

    // Contructor
    public Tenista(String nomeReal, String nomePila, LocalDate dataNacemento, int rankingMundial){
        super(nomeReal, nomePila, dataNacemento);
        this.setRankingMundial(rankingMundial);
    }

    // Métodos
    @Override
    public String toString(){
        return super.toString()+"Nº "+getRankingMundial()+" do mundo.";
    }

    // Getters & Setters
    public void setRankingMundial(int rankingMundial){
        this.rankingMundial = rankingMundial;
    }
    public int getRankingMundial(){
        return this.rankingMundial;
    }
}
