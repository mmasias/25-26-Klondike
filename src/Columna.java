public class Columna {

    private Carta[] cartas;
    private int cantidadCartas;
    private int cartaVisible;
    private Console console;

    public Columna(Baraja baraja, int cartasCorrespodientes) {
        console = new Console();
        cartas = new Carta[52];
        cantidadCartas = 0;
        for (int j = 0; j < cartasCorrespodientes; j++) {
            cartas[cantidadCartas] = baraja.sacarCarta();
            cantidadCartas++;
        }
        if (this.cantidadCartas > 0) {
            this.cartas[this.cantidadCartas - 1].darVuelta();
        }
        cartaVisible = cantidadCartas - 1;
        cartaVisible = cantidadCartas - 1;
    }

    public void mostrar() {
        for (int i = 0; i < cantidadCartas; i++) {
            if (i < cartaVisible) {
                console.write("[X]");
            } else {
                this.cartas[i].mostrar();
            }
        }
        console.writeln("");
    }

    public void moverA(Palo paloA) {
        if (!this.estaVacio()) {
            Carta cartaCima = this.cartas[cantidadCartas - 1];
            if (paloA.esApilable(cartaCima)) {
                paloA.añadir(cartaCima);
                cantidadCartas--;
                if (this.cartaVisible == this.cantidadCartas && !this.estaVacio()) {
                    cartaVisible--;
                    this.cartas[this.cartaVisible].darVuelta();
                }
            }
        }
    }

    public void moverA(Columna destino) {
        if (!this.estaVacio()) {
            Carta cartaCima = this.cartas[cantidadCartas - 1];

            if (destino.esApilable(cartaCima)) {
                destino.añadir(cartaCima);
                this.cantidadCartas--;
                if (this.cartaVisible == this.cantidadCartas && !this.estaVacio()) {
                    this.cartaVisible--;
                    this.cartas[this.cartaVisible].darVuelta();
                }
            }
        }
    }

    public void añadir(Carta cartaCima) {
        this.cartas[cantidadCartas] = cartaCima;
        cantidadCartas++;
    }

    private boolean sonColoresDistintos(Carta carta1, Carta carta2) {

        return carta1.esRoja() != carta2.esRoja();
    }

    public boolean esApilable(Carta cartaNueva) {
        if (this.estaVacio()) {
            return cartaNueva.getNumero() == 13;
        }
        Carta ultima = this.cartas[cantidadCartas - 1];
        return sonColoresDistintos(ultima, cartaNueva) &&
                cartaNueva.getNumero() + 1 == ultima.getNumero();

    }

    private boolean estaVacio() {
        return cantidadCartas == 0;
    }

}
