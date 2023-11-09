import java.util.Arrays;

public class MainOrdenacao { 
    
    public static void main(String[] args) {

        // int[] tamanhos = {50, 500, 1000, 5000, 10000};
        int[] tamanhos = {50, 50, 50, 50, 50, 500,500,500,500,500,1000,1000,1000,1000,1000, 5000, 5000, 5000, 5000, 5000, 10000, 10000, 10000, 10000, 10000};

        for (int tamanho : tamanhos) {
    
            System.out.printf("\n========= TESTE - %s NÚMEROS =========\n", tamanho);

            RelatorioOrdenacao relatorioQuicksort  = new RelatorioOrdenacao(tamanho);
            RelatorioOrdenacao relatorioBubblesort = new RelatorioOrdenacao(tamanho);
            RelatorioOrdenacao relatorioMergesort  = new RelatorioOrdenacao(tamanho);
    
            relatorioQuicksort.popularAleatoriamente();
            relatorioBubblesort.popularAleatoriamente();
            relatorioMergesort.popularAleatoriamente();

            relatorioQuicksort.testarQuickSort();
            System.out.println("");
            relatorioBubblesort.testarBubbleSort();
            System.out.println("");
            relatorioMergesort.testarMergeSort();
            System.out.println("");

            System.out.printf("\n========= FIM DOS TESTES - %s NÚMEROS =========\n", tamanho);
            
        }

    }

}
