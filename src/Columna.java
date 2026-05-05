public class Columna {

    private Carta[] cartas;
    private int ultima;
    private int posicion;
    private Console console;

    public Columna(Baraja baraja, int posicion) {
        this.posicion = posicion;
        ultima = 0;
        cartas = new Carta[19];
        for (int i = 0; i < posicion; i++) {
            Carta carta = baraja.sacar();
            if (i == posicion - 1) {
                carta.voltear();
            }
            this.poner(carta);
        }
        console = new Console();
    }

    private void poner(Carta carta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'poner'");
    }

    public void mostrar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrar'");
    }

    public void moverA(Palo paloA) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moverA'");
    }

    public void moverA(Columna escogerColumna) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moverA'");
    }

}
