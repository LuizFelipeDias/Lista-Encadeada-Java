package lista;

/**
 * Classe que representa uma Lista Encadeada Simples.
 * @param <T> Tipo genérico: permite que a lista armazene qualquer tipo.
 */
public class ListaEncadeada<T> {

    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho;
    private final int NAO_ENCONTRADO = -1;

    public void limpa() {
        for (No<T> atual = this.inicio; atual != null; ) {
            No<T> proximo = atual.getProximo();
            atual.setElemento(null);
            atual.setProximo(null);
            atual = proximo;
        }
        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public void adiciona(T elemento) {
        No<T> celula = new No<>(elemento);
        if (this.tamanho == 0) {
            this.inicio = celula;
        } else {
            this.ultimo.setProximo(celula);
        }
        this.ultimo = celula;
        this.tamanho++;
    }

    /**
     * Adiciona um elemento no primeiríssimo lugar da lista.
     */
    public void adicionaInicio(T elemento) {
        if (this.tamanho == 0) {
            No<T> novoNo = new No<>(elemento);
            this.inicio = novoNo;
            this.ultimo = novoNo;
        } else {
            No<T> novoNo = new No<>(elemento, this.inicio);
            this.inicio = novoNo;
        }
        this.tamanho++;
    }

    /**
     * Insere um elemento em qualquer posição (0 até tamanho).
     */
    public void inserir(int posicao, T elemento) {
        if (posicao < 0 || posicao > this.tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }

        if (posicao == 0) {
            this.adicionaInicio(elemento);
        } else if (posicao == this.tamanho) {
            this.adiciona(elemento);
        } else {
            // Buscamos o nó imediatamente ANTERIOR à posição desejada
            No<T> noAnterior = this.buscaNo(posicao - 1);
            No<T> noProximo = noAnterior.getProximo();

            No<T> novoNo = new No<>(elemento, noProximo);
            noAnterior.setProximo(novoNo);
            this.tamanho++;
        }
    }

    /**
     * MÉTODO PRIVADO (AUXILIAR): Encontra o OBJETO NÓ em uma posição específica.
     */
    private No<T> buscaNo(int posicao) {
        // CORREÇÃO: Os índices válidos para buscar um NÓ existente vão de 0 até (tamanho - 1)
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IllegalArgumentException("Posição não existente");
        }

        No<T> atual = this.inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual;
    }

    /**
     * MÉTODO PÚBLICO: Retorna o VALOR (T) que está em uma determinada posição.
     */
    public T buscaPorPosicao(int posicao) {
        return this.buscaNo(posicao).getElemento();
    }

    public int busca(T elemento) {
        No<T> atual = this.inicio;
        int posicao = 0;

        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
                return posicao;
            }
            atual = atual.getProximo();
            posicao++;
        }
        return NAO_ENCONTRADO;
    }

    public void remover(T elemento) {
        if (this.tamanho == 0) return;

        No<T> atual = this.inicio;
        No<T> anterior = null;

        for (int i = 0; i < this.tamanho; i++) {
            if (atual.getElemento().equals(elemento)) {
                if (anterior == null) {
                    this.inicio = atual.getProximo();
                } else {
                    anterior.setProximo(atual.getProximo());
                }

                if (atual == this.ultimo) {
                    this.ultimo = anterior;
                }

                this.tamanho--;
                return;
            }
            anterior = atual;
            atual = atual.getProximo();
        }
    }

    public T removerInicio() {

        if (this.tamanho == 0) {
            throw new RuntimeException("Lista Vazia");
        }

        T removido = this.inicio.getElemento();
        this.inicio = this.inicio.getProximo();
        this.tamanho--;

        if (this.tamanho == 0) {
            this.ultimo = null;
        }

        return removido;
    }

    public T removerFinal() {

        if (this.tamanho == 0) {
            throw new RuntimeException("Lista Vazia");
        }

        if (this.tamanho == 1) {
            return this.removerInicio();
        }

        No<T> penultimoNo = this.buscaNo(this.tamanho - 2);
        T removido = penultimoNo.getProximo().getElemento();
        penultimoNo.setProximo(null);

        this.ultimo = penultimoNo;

        this.tamanho--;

        return removido;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    @Override
    public String toString() {
        if (this.tamanho == 0) {
            return "[ ]";
        }

        StringBuilder builder = new StringBuilder("[");
        No<T> atual = this.inicio;
        builder.append(atual.getElemento());

        while (atual.getProximo() != null) {
            atual = atual.getProximo();
            builder.append(",").append(atual.getElemento());
        }

        builder.append("]");
        return builder.toString();
    }
}