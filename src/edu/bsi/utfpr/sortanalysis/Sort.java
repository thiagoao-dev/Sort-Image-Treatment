package edu.bsi.utfpr.sortanalysis;

public class Sort {
    
    /**
     * Bubble Sort
     * @param vetor[]
     * @return int
     */
    public static int bubbleSort(int[] vetor){
        // Declare attributes
        boolean houveTroca = true;
        int vetorSize = (int) (vetor.length-1)/2+1;
        // Sort method
        while (houveTroca) {
            houveTroca = false;
            for (int i = 0; i < (vetor.length)-1; i++){
                if (vetor[i] > vetor[i+1]){
                    int variavelAuxiliar = vetor[i+1];
                    vetor[i+1] = vetor[i];
                    vetor[i] = variavelAuxiliar;
                    houveTroca = true;
                }
            }
        }
        // Return the middle number of the vetor
        return vetor[vetorSize];
    }
    
    /**
     * Selection Sort Method
     * @param vetor[]
     * @return int
     */
    public static int selectionSort(int[] vetor){
        // Declare attributes
        int vetorSize = (int) (vetor.length-1)/2+1;
        int index_min, aux;
        // Sort Method
        for (int i = 0; i < vetor.length; i++) {
            index_min = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[index_min]) {
                    index_min = j;
                }
            }
            if (index_min != i) {
                aux = vetor[index_min];
                vetor[index_min] = vetor[i];
                vetor[i] = aux;
            }
        }
        // Return the middle number of the vetor
        return vetor[vetorSize];
    } 
    
    /**
     * Insert Sort Method
     * @param vetor[]
     * @return int
     */
    public static int insertionSort(int[] vetor){
        // Declare attributes
        int vetorSize = (int) (vetor.length-1)/2+1;
        // Sort Method
        for (int i = 1; i < vetor.length; i++){
            int a = vetor[i];
            int j;
            for (j = i - 1; j >= 0 && vetor[j] > a; j--)
            {
                vetor[j + 1] = vetor[j];
                vetor[j] = a;
            }
        }
        // Return the middle number of the vetor
        return vetor[vetorSize];
    }
    
    public static void quickSort(int vetor[], int pStart, int pEnd) {
    
    }
}