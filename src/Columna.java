public class Columna extends Mazo{
 
    private static final int NUMERO_CARTAS = 24;
    private static final String TITULO = "Columna";
    private int posicion;


    public Columna(Baraja baraja, int posicion) {
        super(NUMERO_CARTAS, TITULO);
        this.posicion = posicion;
        for (int i = 0; i < posicion; i++) {
            Carta carta = baraja.sacar();
            if (i == posicion - 1) {
                carta.voltear();
            }
            this.poner(carta);
        }
    }

    protected void mostrarContenido(){
        console.write(posicion + " ");
        for (int i = 0; i < ultima; i++) {
            cartas[i].mostrar();
        }        
        console.writeln();
    }

    public void moverA(Palo palo) {
        if (this.vacia()) {
            console.writeln("No se puede");
        } else {
            Carta carta = this.sacar();
            if (palo.apilable(carta)) {
                palo.poner(carta);
            } else {
                this.poner(carta);
                console.writeln("No se puede!");
            }
        }
    }

    public void moverA(Columna columna) {
        if (this.vacia()) {
            console.writeln("no se puede!");
        } else {
            Carta carta = sacar();
            if (columna.apilable(carta)) {
                columna.poner(carta);
            } else {
                this.poner(carta);
                System.out.println("No se puede!");
            }
        }
    }

    public boolean apilable(Carta carta) {
        return this.vacia() && carta.esRey() ||
                !this.vacia()
                        && this.cima().bocaArriba()
                        && this.cima().siguiente(carta)
                        && this.cima().distintoColor(carta);

    }

    public void voltear() {
        if (this.vacia()) {
            console.writeln("No hay carta para voltear");
        } else if (cima().bocaArriba()) {
            console.writeln("No hay carta boca abajo en la cima");
        } else {
            cima().voltear();
        }
    }
}
