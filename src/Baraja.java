import java.util.Random;

public class Baraja extends Mazo {

    private static final int PALOS = 4;
    private static final int NUMEROS = 13;
    private static final int NUMERO_CARTAS = PALOS * NUMEROS;
    private static final String TITULO = "Baraja";

    public Baraja() {
        super(NUMERO_CARTAS, TITULO);
        for (int palo = 0; palo < PALOS; palo++) {
            for (int numero = 0; numero < NUMEROS; numero++) {
                this.poner(new Carta(palo, numero));
            }
        }
        this.mezclar();
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

    protected void mostrarContenido() {
        Carta carta = cima();
        carta.mostrar();
        console.writeln();
    }

    public void moverA(Descarte descarte) {
        if (this.vacia()) {
            console.writeln("No hay cartas!!!");
        } else {
            int contador = 3;
            while (contador > 0 && !this.vacia()) {
                Carta carta = this.sacar();
                carta.voltear();
                descarte.poner(carta);
                contador--;
            }
        }
    }
}
