package baraja;
import java.util.Arrays;
import java.util.Collections;

public class Baraja {
	Carta cartas[] = new Carta[52];
    int pos;
    
    public void creaCartas(){
        String simbolo = "23456789TJKQA";
        String tipos = "SCDH"; //S:ESPADA, C:TREBOL, D:DIAM, H:CORA
        int ind = 0;
        
        for (int i= 0; i< tipos.length(); i++){
            for(int j= 0; j< simbolo.length(); j++){
                
                Carta tmpCarta = new Carta();
                tmpCarta.setSimb(simbolo.charAt(j));
                tmpCarta.setTipo(tipos.charAt(i));
                this.cartas[ind]= tmpCarta;
                ind++;
                
            }
        }
        revolverCartas();
    }
    
    private void revolverCartas(){
        Collections.shuffle(Arrays.asList(this.cartas));
    }
    
    
    public Carta getOneC(){
        if(pos == 51){
            System.out.println("Baraja vacia");
            return null;
        }else{
            Carta tmpCarta = this.cartas[pos];
            pos++; return tmpCarta;
        }
    }

}
