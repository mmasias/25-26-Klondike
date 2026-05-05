class Klondike {

    private Baraja baraja;
    private Palo[] palos;
    private Columna[] columnas;
    private Descarte descarte;
    private Console console;

    private final int NUMERO_COLUMNAS = 7;
    private final int NUMERO_PALOS = 4;

    public Klondike() {
        baraja = new Baraja();
        palos = new Palo[NUMERO_PALOS];
        for (int i = 0; i < NUMERO_PALOS; i++) {
            palos[i] = new Palo();
        }
        columnas = new Columna[NUMERO_COLUMNAS];
        for (int i = 0; i < NUMERO_COLUMNAS; i++) {
            columnas[i] = new Columna(baraja, i + 1);
        }
        descarte = new Descarte();
        console = new Console();
    }

    private void jugar() {
        Menu menu = new Menu();

        boolean estaJugando = true;
        boolean haGanado = false;

        do {
            this.mostrarTapete();
            menu.mostrar();
            switch (menu.pedirOpcion()) {
                case 1 -> baraja.moverA(descarte);
                case 2 -> descarte.moverA(this.escogerPalo("A"));
                case 3 -> descarte.moverA(this.escogerColumna("A"));
                case 4 -> this.escogerPalo("De").moverA(this.escogerColumna("A"));
                case 5 -> this.escogerColumna("De").moverA(this.escogerPalo("A"));
                case 6 -> this.escogerColumna("De").moverA(this.escogerColumna("A"));
                case 7 -> descarte.voltear(baraja);
                case 8 -> this.escogerColumna("De").voltear();
                case 9 -> estaJugando = false;
            }
            haGanado = this.validarFinal();
        } while (estaJugando && !haGanado);
        console.writeln((!haGanado ? "NO " : "") + "GANASTE");
    }

    private boolean validarFinal() {
        for (int i = 0; i <= NUMERO_PALOS; i++) {
            if (!palos[i].completo()) {
                return false;
            }
        }
        return true;
    }

    private Columna escogerColumna(String prefijo) {
        return columnas[console.readInt(prefijo + " que columna?") - 1];
    }

    private Palo escogerPalo(String prefijo) {
        return palos[console.readInt(prefijo + " que palo?") - 1];
    }

    private void mostrarTapete() {
        console.cleanScreen();
        baraja.mostrar();
        this.linea();
        descarte.mostrar();
        this.linea();
        for (int i = 0; i < NUMERO_PALOS; i++) {
            palos[i].mostrar();
        }
        this.linea();
        for (int i = 0; i < NUMERO_COLUMNAS; i++) {
            columnas[i].mostrar();
        }
        this.linea();
    }

    private void linea() {
        console.writeln("-".repeat(30));
    }

    public static void main(String[] args) {
        new Klondike().jugar();
    }
}