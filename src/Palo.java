public class Palo extends Mazo{

    public Palo() {
        ultima = 0;
        cartas = new Carta[13];
        console = new Console();
    }



    protected void mostrarContenido(){
        console.write("Palo");
        Carta carta = this.cima();
        carta.mostrar();
        console.writeln();        
    }

    public void moverA(Columna columna) {
        if (this.vacia()) {
            console.writeln("No se puede!");
        } else {
            Carta carta = this.sacar();
            if (columna.apilable(carta)) {
                columna.poner(carta);
            } else {
                this.poner(carta);
                console.writeln("Invalido");
            }
        }
    }

    public boolean completo() {
        return ultima==13;
    }

    public boolean apilable(Carta carta) {
        return this.vacia() && carta.esAs() ||
                !this.vacia() 
                    && carta.igualPalo(this.cima()) 
                    && carta.siguiente(this.cima());
    }

}
