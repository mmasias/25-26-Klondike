public class Columna {

    private int numeroCartas;
    private Carta[] cartas;

    public Columna(Baraja baraja, int i) {
        this.numeroCartas = i;
        this.cartas = new Carta[i];
        for (int j = 0; j < i; j++) {
            this.cartas[j] = baraja.sacarCarta();
        }
    }

    public void mostrar() {
        if (numeroCartas == 0) {
            System.out.println("[vacía]");
            return;
        }
        for (int j = 0; j < numeroCartas - 1; j++) {
            System.out.println("[Carta boca abajo]");
        }
        System.out.println(cartas[numeroCartas - 1]);
    }

    public void moverA(Palo paloA) {
        cartas[numeroCartas - 1].moverA(paloA);
        numeroCartas--;
    }

    public void moverA(Columna escogerColumna) {
        cartas[numeroCartas - 1].moverA(escogerColumna);
        numeroCartas--;
    }
}