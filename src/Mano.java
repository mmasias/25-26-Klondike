
public class Mano {

    private Carta[] cartas;
    private int ultima;
    private Console console;
    final int PUNTAJE_GANADOR = 21;
    final int MAXIMO_CARTAS = 11;

    public Mano() {
        ultima = 0;
        cartas = new Carta[MAXIMO_CARTAS];
        console = new Console();
    }

    private void poner(Carta carta) {
        cartas[ultima] = carta;
        ultima++;
    }

    public void mostrar() {
        for (int i = 0; i < ultima; i++) {
            this.cartas[i].mostrar();
        }
        console.writeln(ultima == 0 ? "" : (" - Puntaje:" + this.obtenerPuntaje()));
    }

    public boolean haGanado() {
        return this.obtenerPuntaje() == PUNTAJE_GANADOR;
    }

    public boolean haPerdido() {
        return this.obtenerPuntaje() > PUNTAJE_GANADOR;
    }

    private int obtenerPuntaje() {
        int puntaje = 0;
        int numeroDeAses = 0;
        for (int i = 0; i < ultima; i++) {
            Carta carta = cartas[i];
            int valor = carta.getNumero() + 1;
            if (valor >= 10) {
                valor = 10;
            } else if (valor == 1) {
                valor = 11;
                numeroDeAses++;
            }
            puntaje = puntaje + valor;
        }
        while (puntaje > PUNTAJE_GANADOR && numeroDeAses > 0) {
            puntaje = puntaje - 10;
            numeroDeAses = numeroDeAses - 1;
        }
        return puntaje;
    }

    public void recibir(Carta carta) {
        carta.voltear();
        this.poner(carta);
    }

    public boolean puedeJugar() {
        return !this.haGanado() && !this.haPerdido();
    }
}