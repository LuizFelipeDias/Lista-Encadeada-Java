package lista;

/**
 * Classe que representa a unidade básica de uma lista encadeada (o Nó).
 * @param <T> O tipo genérico. Imagine que o Nó é uma caixa que pode guardar qualquer objeto.
 */
public class No<T> {

    /* Atributo que guarda o conteúdo/valor real dentro desta "caixa" */
    private T elemento;

    /* O "Ponteiro": Este atributo guarda o endereço de memória do próximo Nó.
       É o que conecta um elemento ao outro na lista.
    */
    private No<T> proximo;

     

    /**
     * Construtor 1: Usado quando você quer criar um nó que ainda não aponta para ninguém.
     * Geralmente usado ao adicionar um elemento no final da lista.
     */
    public No(T elemento) {
        /* Guarda o valor passado no atributo 'elemento' */
        this.elemento = elemento;
        /* Por padrão, ele nasce apontando para o vazio (null) */
        this.proximo = null;
    }

    /**
     * Construtor 2: Usado quando você já sabe quem será o próximo elemento.
     * Muito útil para inserções no início ou no meio da lista.
     */
    public No(T elemento, No<T> proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
    }

//    public No(T elemento, No<T> proximo, No<T> anterior) {
//        this.elemento = elemento;
//        this.anterior = anterior;
//        this.proximo = proximo;
//    }

    /* Getter: Retorna o que está guardado dentro deste nó */
    public T getElemento() {
        return elemento;
    }

    /* ‘Setter’: Permite alterar o valor guardado neste nó sem precisar criar um nó novo */
    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    /* Getter: Retorna a referência do próximo nó para podermos "caminhar" pela lista */
    public No<T> getProximo() {
        return proximo;
    }

    /*
    public No<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(No<T> anterior) {
        this.anterior = anterior;
    }
    */

    /* Setter: Define ou altera quem é o próximo nó na corrente */
    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    /**
     * Transforma os dados do nó em uma String para facilitar a leitura no console.
     */
    @Override
    public String toString() {
        // Nota: Removi o "proximo" do append para evitar que o Java tente imprimir
        // toda a lista recursivamente, o que causaria erro em listas grandes.
        return "No [elemento=" + elemento + "]";
    }
}