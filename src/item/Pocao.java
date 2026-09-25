package item;

import personagem.Personagem;

public class Pocao extends Item implements Usavel {

    public Pocao(String nome, String tipo, int cura) {
        super(nome, tipo, cura);
    }

    @Override
    public void usar(Personagem personagem) {
        personagem.ganharVida(mostrarValor());
    }


}
