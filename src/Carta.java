public class Carta {
    private int numero;
    private int palo;

    public Carta(int palo, int numero) {
        this.palo = palo;
        this.numero = numero;
    }

    public void mostrar() {
        System.out.println(obtenerNumero() + "de " + obtenerPalo());
    }

    public String obtenerNumero () {
        String resultado = "";
        if(numero == 0) {
            resultado = "A";
        } else if(numero == 11) {
            resultado = "J";
        } else if(numero == 12) {
            resultado = "Q";
        } else if(numero == 13) {
            resultado = "K";
        } else {
            resultado = "" + (numero + 1);  
        }
        return resultado;
    }
    
    private String obtenerPalo() {
        String resultado = "";
        if(palo == 0) {
            resultado = "♠ (Picas)";
        } else if(palo == 1) {
            resultado = "♥ (Corazones)";
        } else if(palo == 2) {
            resultado = "♦ (Diamantes)";
        } else if(palo == 3) {
            resultado = "♣ (Tréboles)";
        } else {
            resultado = "Desconocido";
        }
        return resultado;
    }


}
