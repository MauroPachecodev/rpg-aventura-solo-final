package jogoaventura;

import inimigo.*;
import item.*;
import missao.*;

import java.util.*;

public class JogoAventura {
    private HashMap<String, Missao> missoes;
    private List<Inimigo> inimigos;

    public JogoAventura() {
        this.missoes = new HashMap<>();
        this.inimigos = new ArrayList<>();
        inicializarMundo();
    }

    private void inicializarMundo() {
        Item pocaoCura = new Pocao("Poção de Cura", "POCAO", 20);
        Item espada = new Arma("Espada de Ferro", "ARMA", 15);

        Inimigo goblin = new Goblin("Goblin da Floresta", "GOBLIN", 30, 5);
        Inimigo esqueleto = new Esqueleto("Esqueleto Guardião", "ESQUELETO", 40, 8);

        inimigos.add(goblin);
        inimigos.add(esqueleto);

        missoes.put("F1", new Missao("Problemas na Floresta", "Derrote o Goblin", goblin, pocaoCura, 25));
        missoes.put("C1", new Missao("Tumba Esquecida", "Derrote o Esqueleto", esqueleto, espada, 50));
    }

    public HashMap<String, Missao> getMissoes() {
        return missoes;
    }

    public List<Inimigo> getInimigos() {
        return inimigos;
    }
}
