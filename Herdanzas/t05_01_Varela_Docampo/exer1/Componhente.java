

public class Componhente extends Produto{
    public Componhente(String marca, String modelo, double prezo){
        super(marca, modelo, prezo);
    }

    public static double bytesToGigaBytes(long bytes){
        return (double) bytes/1000000000;
    }

    public static long gigaBytesToBytes(double gigabytes){
        return (long) gigabytes*1000000000;
    }

    public static double hzToMhz(long hz){
        return (double) hz/1000000;
    }

    public static long gigaHzToHz(double ghz){
        return (long) ghz*1000000000;
    }
}
