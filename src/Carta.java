public class Carta {

    private int palo;
    private int numero;
    private String[] palos = { "Corazones", "Diamantes", "Tréboles", "Picas" };
    private String[] numeros = { "As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
    private Console console = new Console();

    public Carta(int palo, int numero) {
        this.palo = palo;
        this.numero = numero;
    }

    public void mostrar() {
        console.writeln(" "+ numeros[numero] + " de " + palos[palo]);
    }

    public void moverA(Palo paloA) {
        paloA.poner(this);
    }

    public void moverA(Columna escogerColumna) {
        escogerColumna.poner(this);
    }
}