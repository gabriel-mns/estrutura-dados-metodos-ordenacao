public class Sorter {

    private static int iteracoesQuicksort = 0;
    private static int swapsQuicksort = 0;

    private static int iteracoesBubblesort = 0;
    private static int swapsBubblesort = 0;

    private static int iteracoesMergesort = 0;
    private static int swapsMergesort = 0;
    
    public static void quicksort(Registro registro){

        quicksortRecursivo(registro, 0, registro.getLenght()-1);

    }

    public static void quicksortRecursivo(Registro vetor, int inferior, int superior){

        iteracoesQuicksort++;

        if (inferior >= superior) return;

        int pivo = particiona(vetor, inferior, superior)-1;

        quicksortRecursivo(vetor, inferior, pivo -1);
        quicksortRecursivo(vetor, pivo + 1,superior);
        
    }

    public static void bubblesort(Registro registro){

        int[] vetor = registro.getRegistro();

        int n = registro.getLenght();

        for (int i = 0; i < n; i++) {
            
            for (int j = 1; j < (n-i); j++) {

                iteracoesBubblesort++;

                if(vetor[j-1] > vetor[j]){

                    registro.swap(j, j-1);
                    swapsBubblesort++;

                }
                
            }

        }

    }

    public static void mergeSort(Registro registro, int lengthDoArray){

        iteracoesMergesort++;

        int[] arrayOriginal = registro.getRegistro();

        // Se chegar em um array com só um elemento, volta esse único elemento
        if (lengthDoArray < 2) return;

        // Pega o index do meio do array
        int meioDoArray = lengthDoArray / 2;

        // Cria o array de esquerda com metade do tamanho do array original
        int[] arrayDaEsquerda = new int[meioDoArray];

        // Cria o array da direita com o número de itens restantes do array (total-esquerda)
        int[] arrayDaDireita = new int[lengthDoArray - meioDoArray];

        // Adiciona os números no array da esquerda
        for (int i = 0; i < meioDoArray; i++) {

            arrayDaEsquerda[i] = arrayOriginal[i];

        }

        //Adiciona os números no array da direita (números a partir do meio)
        for (int i = meioDoArray; i < lengthDoArray; i++) {
            
            arrayDaDireita[i - meioDoArray] = arrayOriginal[i];

        }

        Registro registroEsquerda = new Registro(arrayDaEsquerda);
        Registro registroDireita  = new Registro(arrayDaDireita);

        //Separa o array da esquerda em subarrays
        mergeSort(registroEsquerda, meioDoArray);

        //Separa o array da direita em subarrays
        mergeSort(registroDireita, lengthDoArray - meioDoArray);

        //Faz com que o registro seja mesclado (e ordenado)
        registro.setRegistro(mesclarArrays(registroEsquerda.getRegistro(), registroDireita.getRegistro()));

    }

    public static int[] mesclarArrays(int[] arrayEsquerda, int[] arrayDireita){

        int tamanhoEsquerda = getArrayLength(arrayEsquerda);
        int tamanhoDireita  = getArrayLength(arrayDireita);

        int indexAtualEsquerda = 0;
        int indexAtualDireita  = 0;
        int indexResultado     = 0;

        int[] result = new int [tamanhoEsquerda + tamanhoDireita];

        //Enquanto tiver números para comparar NOS DOIS arrays
        while(indexAtualDireita < tamanhoDireita && indexAtualEsquerda < tamanhoEsquerda){

            swapsMergesort++;

            //Pega os números nas posições atuais de cada um
            int numeroDireita = arrayDireita[indexAtualDireita];
            int numeroEsquerda = arrayEsquerda[indexAtualEsquerda];

            //Compara os números e verifica se o da direita é menor
            if(numeroDireita <= numeroEsquerda){

                //Se for, coloca o número da direita no resultado
                result[indexResultado] = numeroDireita;

                //E passa para o próximo
                indexAtualDireita++;
                indexResultado++;

            } else {

                //Se não for, coloca o número da esquerda no resultado
                result[indexResultado] = numeroEsquerda;

                //E passa para o próximo
                indexAtualEsquerda++;
                indexResultado++;

            }

        }

        //Caso haja números restantes no array da direita, coloca eles no resultado
        while(indexAtualDireita < tamanhoDireita){

            swapsMergesort++;

            result[indexResultado] = arrayDireita[indexAtualDireita];

            indexAtualDireita++;
            indexResultado++;

        }

        //Caso haja números restantes no array da esquerda, coloca eles no resultado
        while(indexAtualEsquerda < tamanhoEsquerda){

            swapsMergesort++;

            result[indexResultado] = arrayEsquerda[indexAtualEsquerda];

            indexAtualEsquerda++;
            indexResultado++;

        }

        return result;

    } 

    private static int particiona(Registro registro, int inferior, int superior){

        int[] vetor = registro.getRegistro();

        int pivot        = vetor[inferior];
        int numeroAtual  = inferior+1;
        int ultimoInsert = inferior+1;

        while(numeroAtual <= superior) {
            
            if(vetor[numeroAtual] < pivot){

                registro.swap(numeroAtual, ultimoInsert);
                ultimoInsert++;
                swapsQuicksort++;

            }

            numeroAtual++;

        }

        registro.swap(inferior, ultimoInsert-1);

        return ultimoInsert;

    }

    private static String arrayToString(int[] array){

        String result="[";

        for (int i : array) {
            result += i + ",";
        }

        return result + ']';

    }

    private static int getArrayLength(int[] array){

        int tamanho = 0;

        for (int num : array) {
            tamanho++;
        }

        return tamanho;

    }

    public static int getIteracoesQuicksort() {
        return iteracoesQuicksort;
    }

    public static void setIteracoesQuicksort(int iteracoesQuicksort) {
        Sorter.iteracoesQuicksort = iteracoesQuicksort;
    }

    public static int getSwapsQuicksort() {
        return swapsQuicksort;
    }

    public static void setSwapsQuicksort(int swapsQuicksort) {
        Sorter.swapsQuicksort = swapsQuicksort;
    }

    public static int getIteracoesBubblesort() {
        return iteracoesBubblesort;
    }

    public static void setIteracoesBubblesort(int iteracoesBubblesort) {
        Sorter.iteracoesBubblesort = iteracoesBubblesort;
    }

    public static int getSwapsBubblesort() {
        return swapsBubblesort;
    }

    public static void setSwapsBubblesort(int swapsBubblesort) {
        Sorter.swapsBubblesort = swapsBubblesort;
    }

    public static int getIteracoesMergesort() {
        return iteracoesMergesort;
    }

    public static void setIteracoesMergesort(int iteracoesMergesort) {
        Sorter.iteracoesMergesort = iteracoesMergesort;
    }

    public static int getSwapsMergesort() {
        return swapsMergesort;
    }

    public static void setSwapsMergesort(int swapsMergesort) {
        Sorter.swapsMergesort = swapsMergesort;
    }

    

}
