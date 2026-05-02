import java.util.Random;

public class Baraja {

    private Carta[] cartas;
    private int ultima;
    private Console console;

    public Baraja() {
        ultima = 0;
        cartas = new Carta[52];
        for (int palo = 0; palo < 4; palo++) {
            for (int numero = 0; numero < 13; numero++) {
                this.poner(new Carta(palo, numero));
            }
        }
        this.mezclar();
        console = new Console();
    }

    private void mezclar() {
        Random aleatorio = new Random();
        for (int i = 0; i < 1000; i++) {
            int origen = aleatorio.nextInt(52);
            int destino = aleatorio.nextInt(52);
            Carta carta = cartas[origen];
            cartas[origen] = cartas[destino];
            cartas[destino] = carta;
        }
    }

    public void poner(Carta carta) {
        cartas[ultima] = carta;
        ultima++;
    }

    public void mostrar() {
        console.writeln("BARAJA ");
        Carta carta = this.cima();
        carta.mostrar();
    }

    private Carta cima() {
        return cartas[ultima - 1];
    }

    public void moverA(Descarte descarte) {
        if (this.barajaEstaVacia()) {
            console.writeln("La baraja esta vacia no puedes sacar mas cartas a -> descarte");
        } else {
            Carta carta = this.cima();
            carta.darVuelta();
            ultima = ultima - 1;
            descarte.añadir(carta);
        }
    }

    private boolean barajaEstaVacia() {
        return ultima == 0;
    }

}
