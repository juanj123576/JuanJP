package webServer;
import static spark.Spark.*;
import baraja.*;

public class Server {

	static Baraja b;
	static Mano manServer;
	static Mano manCliente;
	
	public static void main(String[] args) {
	
		get("/nuevoJuego", (get,res)->nuevPartida());
		get("/pide",(get,res)->pideCarta());
		get("/puntaje",(get,res)->puntaje());
		get("/plantarse",(get,res)->pTotal());
		get("/diler",(get,res)->diler());
		
	}
	
	public static String nuevPartida() {
		b= new Baraja();
		b.creaCartas();
		
		manCliente=new Mano();
		manServer=new Mano();
		
		manServer.agregarCart(b.getOneC());
		manServer.agregarCart(b.getOneC());
		
		manCliente.agregarCart(b.getOneC());
		manCliente.agregarCart(b.getOneC());
		
		while(manServer.puntaje()<=16) {
			manServer.agregarCart(b.getOneC());
		}
		
		return manCliente.valorMano()+" Puntaje: " +manCliente.puntaje();
	}
	
	public static String pideCarta() {
		
			manCliente.agregarCart(b.getOneC());
			return manCliente.valorMano()+" Puntaje: " +manCliente.puntaje();
			}
	
	public static String puntaje() {
		
		String ptg=""+manCliente.puntaje();
		return ptg;
	}
	
	public static String pTotal() {
		
		String mensaje=" "; 
		
		if ((manServer.puntaje() <= 21 || manCliente.puntaje() > 21) || ((manCliente.puntaje() < manServer.puntaje()) && manServer.puntaje()<=21)) {

            mensaje =  "PERDISTE ...";
            return mensaje;    
            
        }else if ((manCliente.puntaje() <= 21 ||manServer.puntaje() > 21) || ((manServer.puntaje() < manCliente.puntaje())&& manServer.puntaje()<=21)) {
            
        	mensaje ="GANASTE ...";
            return mensaje;

        }else if ((manServer.puntaje() == manCliente.puntaje())||(manCliente.puntaje()>21 && manServer.puntaje()>21)) {
        	
            mensaje ="EMPATE ...";
            return mensaje;
        }
		return mensaje;
	}
	
	public static String diler() {
		
		return manServer.valorMano()+" Puntaje: " +manServer.puntaje();
		
	}
	
}
