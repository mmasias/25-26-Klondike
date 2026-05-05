public class Columna {
    private Carta[] cartas;
    private int ultima;
    Baraja baraja;
    int i;

    public Columna(Baraja baraja, int i) {
        this.baraja = baraja;
        this.i = i;
        this.cartas = new Carta[52];
        this.ultima = 0;
    }

    public void poner(Carta carta) {
        cartas[ultima] = carta;
        ultima++;
    }

    public Carta sacar() {
        if(ultima > 0) {
            ultima--;
            return cartas[ultima];
        }
        return null;
    }

    public void mostrar() {
       System.out.println("numero de columna " + i + "carta: " + cartas[ultima]);
    }

    public void moverA(Palo paloA) {
        this.cartas[ultima] = paloA.cartas[ultima];
    }

    public void moverA(Columna escogerColumna) {
        this.cartas[ultima] = escogerColumna.cartas[ultima];
    }

}
