package item;

public abstract class Item {
    final protected String nome;
    final protected String tipo;
    final protected int valor;

    public Item(String nome, String tipo, int valor) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public int mostrarValor() {
        return this.valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return valor == item.valor &&
                java.util.Objects.equals(nome, item.nome) &&
                java.util.Objects.equals(tipo, item.tipo);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(nome, tipo, valor);
    }
}

