import java.util.Random;
 
public class Baraja extends Mazo{

    public Baraja(){
        ultima = 0;
        cartas = new Carta[52];
        for(int palo=0;palo<4;palo++){
            for(int numero=0;numero<13;numero++){
                this.poner(new Carta(palo, numero));
            }
        }
        this.mezclar();
        console = new Console();
    }

    private void mezclar() {
        Random aleatorio = new Random();
        for(int i = 0; i<1000; i++){
            int origen = aleatorio.nextInt(52);
            int destino = aleatorio.nextInt(52);
            Carta carta = cartas[origen];
            cartas[origen] = cartas[destino];
            cartas[destino] = carta;
        }        
    }



    protected void mostrarContenido(){
        console.write("Baraja");
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
