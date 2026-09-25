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

    public int mostrarValor(){
        return this.valor;
    }
}

