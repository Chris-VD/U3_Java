
public class MemoriaRam extends Componhente{
    private long memoriaBytes;
    private long velocidadeMemoriaHZ;

    // Constructores
    public MemoriaRam(String marca, String modelo, double prezo, double velocidadeMemoriaGz, double memoriaGB){
        super(marca, modelo, prezo);
        this.memoriaBytes = gigaBytesToBytes(memoriaGB);
        this.velocidadeMemoriaHZ = gigaHzToHz(velocidadeMemoriaGz);
    }

    // Métodos
    @Override
    public String toString(){
        return "Memoria RAM "+super.toString()+" con "+this.getMemoriaGB()+" GB e velocidade "+this.getMemoriaMHz()+" MHz";
    }

    public double getMemoriaGB(){
        return bytesToGigaBytes(memoriaBytes);
    }

    public double getMemoriaMHz(){
        return hzToMhz(velocidadeMemoriaHZ);
    }

    // Getters & Setters
    public long getMemoriaBytes() {
        return memoriaBytes;
    }
    public long getVelocidadeMemoriaHZ() {
        return velocidadeMemoriaHZ;
    }
}