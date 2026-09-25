package missao;
import inimigo.Inimigo;
import item.Item;
import personagem.Personagem;

public class Missao {
    final protected String titulo;
    final protected String descricao;
    protected EstadoMissao estadoMissao;
    protected Inimigo alvo;
    final protected Item recompensa;
    final protected int ouroRecompensa;

    public Missao(String titulo, String descricao, Inimigo alvo, Item recompensa, int ouroRecompensa) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.alvo = alvo;
        this.recompensa = recompensa;
        this.ouroRecompensa = ouroRecompensa;
        this.estadoMissao = EstadoMissao.PENDENTE;
    }

    public String mostrarTitulo() {
        return this.titulo;
    }

    public EstadoMissao getEstado() {
        return this.estadoMissao;
    }

    public Inimigo getAlvo() {
        return this.alvo;
    }
    
    public void concluir(Personagem personagem) {

        estadoMissao = EstadoMissao.CONCLUIDA;
        personagem.receberOuro(ouroRecompensa);
        personagem.adicionarItem(recompensa);
        System.out.println("Missão concluída: " + mostrarTitulo());
    }
}