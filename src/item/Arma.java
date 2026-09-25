package item;

public class Arma extends Item {
    public Arma(String nome, String tipo, int dano) {
        super(nome, tipo, dano);
    }

    public int mostrarDano() {
        return mostrarValor();
    }
}
