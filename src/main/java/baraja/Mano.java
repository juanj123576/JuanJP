package baraja;
import java.util.ArrayList;

public class Mano {
	ArrayList<Carta> man= new ArrayList<Carta>();
    int pos =0;
    
    public void agregarCart(Carta cta){
        man.add(cta);
    }
    
    public String valorMano(){
        String mano="";
        for(int i=0; i<man.size(); i++){
            mano+=man.get(i).toString() + " ";
        }
        return mano;
    }
    
    public int puntaje(){
        int val=0;
        boolean ace=false;
        
        for (int i=0; i< man.size(); i++){
            Carta tmpCta= man.get(i);
            int valorCta= tmpCta.valor();
            
            if(valorCta==1) ace =true;
            if(valorCta>10) valorCta=10;
            
            val += valorCta;
        }
        
        if(ace== true && val+10<=21) val = val+10;
        
        return val;
    }
}
