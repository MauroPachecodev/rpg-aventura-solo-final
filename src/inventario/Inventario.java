package inventario;

import java.util.ArrayList;
import java.util.List;

public class Inventario<T> {
    private List<T> itens;

    public Inventario() {
        this.itens = new ArrayList<>();
    }

    public void adicionar(T item) {
        itens.add(item);
    }

    public void remover(T item) throws item.ItemNaoEncontradoException {
        if (!buscar(item)) {
            throw new item.ItemNaoEncontradoException("Item não encontrado no inventário!");
        }
        itens.remove(item);
    }

    public boolean buscar(T item) {
        for (var i : itens) {
            if (i.equals(item)) {
                return true;
            }
        }
        return false;
    }

    public void listar() {
        for (var item : itens) {
            System.out.println(item);
        }
    }

    public int total() {
        return itens.size();
    }

    public List<T> getItens() {
        return itens;
    }
}
