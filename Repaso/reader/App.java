package reader;

import java.io.IOException;

public class App {
    public static void main(String Args[]) throws IOException{
        for (char c=((char)System.in.read()); c!='!'; c=(char)System.in.read()){
            System.err.print(c);
        }
        boolean programa = true;
        while (programa){
            cleanBuffer(0);
            System.out.println("Case?");
            char opc = (char)System.in.read();
            switch (opc) {
                case 'a' -> {System.out.println("Case A");}
                case 'b' -> {System.out.println("Case B");}
                case 'c' -> {programa = false;}
                default ->{System.out.println("None");}
            }
        }
    }

    public static void cleanBuffer(int read) throws IOException{
        while(read != 10){
            System.in.skip(0);
        }
    }
}
