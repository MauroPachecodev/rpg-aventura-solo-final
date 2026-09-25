package inimigo;

import personagem.Personagem;

public class Goblin extends Inimigo{
        public Goblin(String nome, String tipo, int vida, int dano) {
            super(nome, tipo, vida, dano);
    }

    @Override
    public void atacar(Personagem personagem) {
        personagem.receberDano(dano);
        System.out.println("goblin atacando por " + mostrarDano() + " de dano");
    }
}

