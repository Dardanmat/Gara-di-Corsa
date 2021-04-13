package tpsit.gara_di_corsa;
import java.util.ArrayList;

/*
Realizzare in Java un’applicazione che simuli una gara di corsa tra n corridori,
(n fornito in input) ciascuno caratterizzato dal proprio nome.

I corridori sono modellati da thread Java. Ognuno di essi, dopo l’avvio, 
incrementa iterativamente un contatore, stampando su schermo, 
ad ogni iterazione, il proprio nome ed il numero di iterazioni eseguite 
(cioè i metri percorsi). 

Dopo aver eseguito 100 iterazioni, il thread stampa su schermo un messaggio di notifica del proprio arrivo.
Successivamente implementare la CLASSIFICA dei corridori, 
sincronizzando l'accesso alla risorsa chiamata "CLASSIFICA" condivisa tra i threads corridori, 
che dovrà contenere il nome dei corridori in ordine di arrivo. Stampare la CLASSIFICA.
*/

public class Main {
    public static void main(String[] args) {
        
        Corridore.METRI = 100;
        Corridore.STAMPA_ARRIVO = true;
        Corridore.OGNI_QUANTO_STAMPARE = 1;
        
        ArrayList<Corridore> lista = new ArrayList<>();
        int n = 10; //numero players
        
        for (int i = 0; i < n; i++) {
            lista.add(new Corridore("Macchinetta-"+(i+1)));
        }
        
        for (Corridore c : lista) c.start();
        for (Corridore c : lista) try{c.join();}catch(Exception e){}
        
        Corridore.stampaClassifica();
        
    }
}
