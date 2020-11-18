package baraja;

public class Carta {
	private char simbolo;
    private char tipo;

    public void setSimb(char sim) {
        this.simbolo = sim;
    }

    public void setTipo(char tip) {
        this.tipo = tip;
    }

    public char getSimb() {
        return this.simbolo;
    }

    public char getTipo() {
        return this.tipo;
    }

    public int valor() {
        if(this.simbolo=='T') return 10;
        else if (this.simbolo == 'J') {
            return 11;
        } else if (this.simbolo == 'Q') {
            return 12;
        } else if (this.simbolo == 'K') {
            return 13;
        } else if (this.simbolo == 'A') {
            return 1;
        } else {
            return Integer.parseInt(this.simbolo + "");
        }
    }

    public String toString() {
        return this.simbolo + "" + this.tipo;
    }
}
