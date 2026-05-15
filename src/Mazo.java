abstract class Mazo {
    protected Carta[] cartas;
    protected int ultima;
    protected Console console;    
    protected String titulo;

    protected Mazo(int cantidad, String titulo){
        ultima = 0;
        cartas = new Carta[cantidad];
        console = new Console();
        this.titulo = titulo;
    }

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
        console.write(titulo + " ");
        if (vacia()) {
            console.writeln("VACIA!");
        } else {
            mostrarContenido();
        }
    }    

    protected abstract void mostrarContenido();

}
