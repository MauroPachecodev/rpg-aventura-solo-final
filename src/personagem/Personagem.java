package personagem;
import inimigo.Inimigo;
import item.Arma;
import item.Item;
import java.util.ArrayList;

public class Personagem {
    final protected String nome;
    protected int vida;
    protected int ouro;
    protected ArrayList<Item> inventario;

    public Personagem(String nome) {
        this.nome = nome;
        this.vida = 100;
        this.ouro = 0;
        this.inventario = new ArrayList<>();
    }

    public void atacar(Inimigo inimigo) {
        for (var item: inventario){
            if (item instanceof Arma arma){
                inimigo.receberDano(arma.mostrarDano());
                System.out.println(mostrarNome() + " atacou " + inimigo.mostrarNome() + arma.mostrarDano());
            }
            else{
                inimigo.receberDano(10);
                System.out.println(mostrarNome() + " atacou " + inimigo.mostrarNome() + " causando 10 de dano.");
            }
        }


    }

    public void receberDano(int dano) {
        if (vida > 0){
            vida = Math.max(vida - dano, 0);
        }
    }

    public void ganharVida(int valor){
        this.vida = Math.min(vida + valor, 100);
    }

    public void adicionarItem(Item item) {
        inventario.add(item);
    }

    public String mostrarNome(){
        return this.nome;
    }

    public int mostrarVida(){
        return this.vida;
    }

    public void mostrarStatus() {
        System.out.println("Personagem: " + nome);
        System.out.println("Vida: " + vida);
        System.out.println("Ouro: " + ouro);
        System.out.println("Itens: " + inventario.size());
    }
    public void receberOuro(int ouro){
        this.ouro += ouro;
    }
}

