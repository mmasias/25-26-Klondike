class Dealer {

    private Baraja baraja;
    private Mano mano;
    private Console console;

    public Dealer() {
        baraja = new Baraja();
        mano = new Mano();
        console = new Console();
    }

    public void jugar() {
        boolean estaJugando = true;
        reiniciar();
        do {
            console.cleanScreen();
            mano.mostrar();
            mostrarMenu();
            switch (console.readInt("Elija opción")) {
                case 1 -> pedir();
                case 2 -> reiniciar();
                case 3 -> estaJugando = false;
            }
        } while (estaJugando);
    }

    private void pedir() {
        if (mano.puedeJugar()) {
            mano.recibir(baraja.sacar());
        }
    }

    private void reiniciar() {
        baraja = new Baraja();
        mano = new Mano();
        for (int i = 0; i < 2; i++) {
            mano.recibir(baraja.sacar());
        }
    }

    private void mostrarMenu() {
        console.writeln("1. Pedir");
        console.writeln("2. Empezar de nuevo");
        console.writeln("3. Salir");
    }

    public static void main(String[] args) {
        new Dealer().jugar();
    }
}