package inimigo;
import personagem.Personagem;

public abstract class Inimigo {
    final protected String nome;
    final protected String tipo;
    protected int vida;
    protected int dano;

    public Inimigo(String nome, String tipo, int vida, int dano) {
        this.nome = nome;
        this.tipo = tipo;
        this.vida = vida;
        this.dano = dano;
    }

    public void receberDano(int dano) {
        if (vida > 0){
            vida = Math.max(vida - dano, 0);
        }
    }

    public String mostrarNome(){
        return this.nome;
    }

    public int mostrarDano(){
        return this.dano;
    }

    public abstract void atacar(Personagem personagem);

    public boolean estaVivo() {
        return vida > 0;
    }
}
