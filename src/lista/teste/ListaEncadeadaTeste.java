package lista.teste;

import lista.ListaEncadeada;

public class ListaEncadeadaTeste {

    public static void main(String[] args) {
        System.out.println("--- Executando Testes Iniciais ---");
        testesIniciais();

        System.out.println("\n--- Executando Teste Adiciona Início ---");
        adicionaInicio();

        System.out.println("\n--- Executando Teste Adiciona por Posição ---");
        adicionaPosicao();

        System.out.println("\n--- Executando Teste Remover Elemento Final ---");
        removerFinal();
    }

    public static void removerFinal () {

        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.adiciona(40); // pos 0
        lista.adiciona(50); // pos 1

        // Inserindo o 20 no meio (posição 1)
        lista.inserir(1, 20);

        System.out.println("Lista após inserções ordenadas por posição: " + lista);

        System.out.println("Lista após inserções ordenadas por posição: " + lista);

        // Chama o método da estrutura de dados
        Integer removido = lista.removerFinal();
        System.out.println("Elemento removido do final: " + removido);
        System.out.println("Lista após remover o final: " + lista);

    }

    public static void adicionaPosicao() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.adiciona(10); // pos 0
        lista.adiciona(30); // pos 1

        // Inserindo o 20 no meio (posição 1)
        lista.inserir(1, 20);

        System.out.println("Lista após inserções ordenadas por posição: " + lista);

    }

    public static void adicionaInicio() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.adicionaInicio(3);
        lista.adicionaInicio(2);
        lista.adicionaInicio(1);

        System.out.println("Lista com adicionaInicio: " + lista);

        Integer removido = lista.removerInicio();
        System.out.println("Elemento removido do início: " + removido);

        System.out.println("Lista após removerInicio: " + lista);

    }

    public static void testesIniciais() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.adiciona(1);
        System.out.println("Tamanho = " + lista.getTamanho());
        System.out.println(lista);

        lista.adiciona(2);
        System.out.println(lista);

        lista.adiciona(3);
        System.out.println(lista);

        // Busca por elemento
        System.out.println("*********** Busca do elemento ***********");
        System.out.println("Posição do elemento 1: " + lista.busca(1));
        System.out.println("Posição do elemento 2: " + lista.busca(2));
        System.out.println("Posição do elemento 3: " + lista.busca(3));

        // Busca por posição
        System.out.println("*********** Busca por posição ***********");
        System.out.println("Elemento na pos 0: " + lista.buscaPorPosicao(0));
        System.out.println("Elemento na pos 1: " + lista.buscaPorPosicao(1));
        System.out.println("Elemento na pos 2: " + lista.buscaPorPosicao(2));

        // Teste de Remoção
        System.out.println("*********** Teste de Remoção ***********");
        lista.remover(2);
        System.out.println("Após remover o 2: " + lista);

        // Teste de Limpeza
        System.out.println("*********** Teste de Limpeza ***********");
        lista.limpa();
        System.out.println("Após limpar a lista: " + lista);
    }
}