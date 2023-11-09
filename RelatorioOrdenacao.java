import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RelatorioOrdenacao {
    
    private int tamanho;

    private int[] dados;

    private static Random random = new Random(12345);

    private static CSVWriter fw = new CSVWriter();

    public RelatorioOrdenacao(int tamanho) {
        this.tamanho = tamanho;
        this.dados = new int[tamanho];
    }

    // Métodos de testagem de métodos de ordenação

    public void testarQuickSort(){

        long tempoInicioNano = System.nanoTime();
        long tempoInicioMili = System.currentTimeMillis();

        Sorter.quicksort(new Registro(dados));

        long tempoFimNano    = System.nanoTime();
        long tempoFimMili    = System.currentTimeMillis();

        System.out.printf("""
                TIPO DA ORDENAÇÃO      : %s
                TEMPO DE EXECUÇÃO (ms) : %s
                TEMPO DE EXECUÇÃO (ns) : %s
                QTDE. DE ITERAÇÕES     : %s
                QTDE. DE TROCAS        : %s
                ""","Quicksort", tempoFimMili - tempoInicioMili + " ms", tempoFimNano - tempoInicioNano + " ns", Sorter.getIteracoesQuicksort(), Sorter.getSwapsQuicksort());

        fw.inserirNovoRegistro("Quicksort", tamanho, (tempoFimMili - tempoInicioMili), (tempoFimNano - tempoInicioNano), Sorter.getIteracoesQuicksort(), Sorter.getSwapsQuicksort());

    }

    public void testarBubbleSort(){

        long tempoInicioNano = System.nanoTime();
        long tempoInicioMili = System.currentTimeMillis();

        Sorter.bubblesort(new Registro(dados));

        long tempoFimNano    = System.nanoTime();
        long tempoFimMili    = System.currentTimeMillis();

        System.out.printf("""
                TIPO DA ORDENAÇÃO      : %s
                TEMPO DE EXECUÇÃO (ms) : %s
                TEMPO DE EXECUÇÃO (ns) : %s
                QTDE. DE ITERAÇÕES     : %s
                QTDE. DE TROCAS        : %s
                ""","Bubblesort", tempoFimMili - tempoInicioMili + " ms", tempoFimNano - tempoInicioNano + " ns", Sorter.getIteracoesBubblesort(), Sorter.getSwapsBubblesort());

        fw.inserirNovoRegistro("Bubblesort", tamanho, (tempoFimMili - tempoInicioMili), (tempoFimNano - tempoInicioNano), Sorter.getIteracoesBubblesort(), Sorter.getSwapsBubblesort());

    }

    public void testarMergeSort(){

        Registro dadosParaTeste = new Registro(dados);
        int tamanhoDadosParaTeste = dadosParaTeste.getLenght();

        long tempoInicioNano = System.nanoTime();
        long tempoInicioMili = System.currentTimeMillis();


        Sorter.mergeSort(dadosParaTeste, tamanhoDadosParaTeste);

        long tempoFimNano    = System.nanoTime();
        long tempoFimMili    = System.currentTimeMillis();

        System.out.printf("""
                TIPO DA ORDENAÇÃO      : %s
                TEMPO DE EXECUÇÃO (ms) : %s
                TEMPO DE EXECUÇÃO (ns) : %s
                QTDE. DE ITERAÇÕES     : %s
                QTDE. DE TROCAS        : %s
                ""","Mergesort", tempoFimMili - tempoInicioMili + " ms", tempoFimNano - tempoInicioNano + " ns", Sorter.getIteracoesMergesort(), Sorter.getSwapsMergesort());


        fw.inserirNovoRegistro("Mergesort", tamanho, (tempoFimMili - tempoInicioMili), (tempoFimNano - tempoInicioNano), Sorter.getIteracoesMergesort(), Sorter.getSwapsMergesort());


    }

    // Métodos de população de dados para relatório

    public void popularAleatoriamente(){

        for (int i = 0; i < tamanho; i++) {
            
            dados[i] = gerarNumeroAleatorio(tamanho);

        }

    }

    public void popularSequencialmente(){

        for (int i = 0; i < tamanho; i++) {
            
            dados[i] = i+1;

        }

        dados = embaralharArray(dados);

    }

    public static int[] embaralharArray(int[] array){

        List<Integer> arrayAsList = converterParaListInteger(array);

        Collections.shuffle(arrayAsList);

        return converterParaArrayInt(arrayAsList);
        
    }

    private static int gerarNumeroAleatorio(int limite){

        return random.nextInt(limite + 1);

    }

    private static int[] converterParaArrayInt(List<Integer> arrayFrom){

        int[] result = new int[arrayFrom.size()];

        for (int i = 0; i < arrayFrom.size(); i++) {
        
            result[i] = (arrayFrom.get(i).intValue());

        }

        return result;

    }

    private static List<Integer> converterParaListInteger(int[] arrayFrom){

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arrayFrom.length; i++) {
        
            result.add(Integer.valueOf(arrayFrom[i]));

        }

        return result;

    }


    //Getters e Setters

    public int[] getDados() {
        return dados;
    }

}
