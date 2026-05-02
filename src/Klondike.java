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
            int opcion = menu.pedirOpcion();

            switch (opcion) {
                case 1:
                    baraja.moverA(descarte);
                    break;
                case 2:
                    Palo paloDestino = this.escogerPalo("A");
                    descarte.moverA(paloDestino);
                    break;
                case 3:
                    Columna columnaDestino = this.escogerColumna("A");
                    descarte.moverA(columnaDestino);
                    break;
                case 4:
                    Palo paloDe = this.escogerPalo("De");
                    Columna columnaA = this.escogerColumna("A");
                    paloDe.moverA(columnaA);
                    break;
                case 5:
                    Columna columnaDe = this.escogerColumna("De");
                    Palo paloA = this.escogerPalo("A");
                    columnaDe.moverA(paloA);
                    break;
                case 6:
                    this.escogerColumna("De").moverA(this.escogerColumna("A"));
                    break;
                case 7:
                    descarte.voltear(baraja);
                    break;
                case 8:
                    estaJugando = false;
                    break;
                default:
                    break;
            }
            haGanado = this.validarFinal();
        } while (estaJugando || !haGanado);
        console.writeln(!haGanado ? "NO " : "" + "Ganaste crack!");
    }

    private boolean validarFinal() {
        for (int i = 0; i <= NUMERO_PALOS; i++) {
            if(!palos[i].completo()){
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
        for (int i = 0; i < 50; i++) {
            console.writeln();
        }
        baraja.mostrar();
        console.writeln("DESCARTE: ");
        descarte.mostrar();
        console.writeln("PALOS: ");
        for (int i = 0; i < NUMERO_PALOS; i++) {
            palos[i].mostrar();
        }
        console.writeln("COLUMNAS: ");
        for (int i = 0; i < NUMERO_COLUMNAS; i++) {
            columnas[i].mostrar();
        }
    }

    public static void main(String[] args) {
        new Klondike().jugar();
    }
}