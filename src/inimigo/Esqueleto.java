package inimigo;

import personagem.Personagem;

public class Esqueleto extends Inimigo {

    public Esqueleto(String nome, String tipo, int vida, int dano) {
        super(nome, tipo, vida, dano);
    }

    @Override
    public void atacar(Personagem personagem) {
        personagem.receberDano(dano);
        System.out.println("esqueleto atacando por " + mostrarDano() + "de dano");
    }
}
