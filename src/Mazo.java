abstract class Mazo {
    protected Carta[] cartas;
    protected int ultima;
    protected Console console;    

    public void poner(Carta carta) {
        cartas[ultima] = carta;
        ultima++;
    }

    public boolean vacia() {
        return ultima == 0;
    }

    public Carta sacar() {
        assert !vacia();
        ultima--;
        return cartas[ultima];
    }  

    protected Carta cima() {
        return cartas[ultima-1];
    }    

    public void mostrar() {
        if (vacia()) {
            console.writeln("VACIA!");
        } else {
            mostrarContenido();
        }
    }    

    protected abstract void mostrarContenido();

}
