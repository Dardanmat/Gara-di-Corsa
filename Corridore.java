package tpsit.gara_di_corsa;
import java.util.ArrayList;


public class Corridore extends Thread{

    public static int METRI = 100;
    public static ArrayList<String> classifica = new ArrayList<>();
    public static boolean STAMPA_ARRIVO = false;
    public static int OGNI_QUANTO_STAMPARE = 1;
    
    public Corridore(String name) {
        super(name);
    }
    
    @Override
    public void run() {
        for (int i = 0; i < METRI; i++) {
            if((i+1)%OGNI_QUANTO_STAMPARE == 0) System.out.println(super.getName() + " " + (i+1) + "m");
        }
        assegnazioneClassifica(super.getName());
    }
    
    public static synchronized void assegnazioneClassifica(String nome){
        if(STAMPA_ARRIVO) stampaArrivo(nome);
        classifica.add(nome);
    }
    
    public static void stampaArrivo(String nome){
        System.out.println("--------------------"+ nome + " ha concluso la gara!");
    }
    
    public static void stampaClassifica(){
        for (int i = 0; i < classifica.size(); i++) {
            System.out.println("n." + (i+1) + " > " +classifica.get(i));
        }
    }
    
}
