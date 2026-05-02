public class Descarte {
    private final int NUMERO_MAXIMO_DE_CARTAS = 52;
    private int numeroCartas;
    private Carta[] cartas;
    private Console console;

    public Descarte() {
        this.numeroCartas = 0;
        this.cartas = new Carta[NUMERO_MAXIMO_DE_CARTAS];
        this.console = new Console();
    }

    public void mostrar() {
        if (numeroCartas == 0) {
            console.writeln("[vacío]");
        }
        for (int i = 0; i < numeroCartas; i++) {
            cartas[i].mostrar();
        }
    }

    public void moverA(Palo paloDestino) {
        Carta cartaAMover = cartas[numeroCartas - 1];
        paloDestino.poner(cartaAMover);
        numeroCartas--;
    }

    public void moverA(Columna columnaDestino) {
        Carta cartaAMover = cartas[numeroCartas - 1];
        columnaDestino.poner(cartaAMover);
        numeroCartas--;
    }

    public void voltear(Baraja baraja) {
        while (numeroCartas > 0) {

            Carta cartaAVolver = cartas[numeroCartas - 1];
            baraja.poner(cartaAVolver);
            numeroCartas--;
        }
    }

    public void poner(Carta carta) {
        this.cartas[numeroCartas] = carta;
        this.numeroCartas++;
    }
}