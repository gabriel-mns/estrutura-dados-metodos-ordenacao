public class Registro {
    
    private int[] registro;

    public Registro() {
    }

    public int[] getRegistro() {
        return registro;
    }

    public void setRegistro(int[] registro) {
        this.registro = registro;
    }

    public Registro(int[] registro) {
        this.registro = registro;
    }

    public void swap(int index1, int index2){

        int aux = registro[index2];
        registro[index2] = registro[index1];
        registro[index1] = aux;


    }

    public int getLenght(){

        int tamanho = 0;

        for (int __ : registro) {
            
            tamanho++;

        }

        return tamanho;

    }

}
