package edu.bsi.utfpr.sortanalysis;

public class Core {
    
    private boolean selectionSort;
    private boolean bubbleSort;
    private boolean insertionSort;
    private boolean quickSort;
    private boolean showGraphic;
    private int[][] imgMatrix;
    private int     imgLines;
    private int     imgColumns;
    private int     imgColours;
    private String labels[] = {"3 x 3", "5 x 5", "7 x 7", "9 x 9", "13 x 13", "19 x 19", "25 x 25", "33 x 33", "49 x 49"};
    
    Core(){
        this.selectionSort   = false;
        this.bubbleSort      = false;
        this.insertionSort   = false;
        this.quickSort       = false;
        this.showGraphic     = false;
    }
    
    //Gets and Sets
    
    /**
     * Set-up the original image data
     * @param int[][] pMatrix
     * @param int pNumberOfColours
     * @param int pTotalLines
     * @param int pTotalColumns 
     */
    public void setImage(int[][] pMatrix, int pNumberOfColours, int pTotalLines, int pTotalColumns, int sizeSubMatriz){
        
        // Temp attribute
        int[] tempSubMatrizSize = {3,5,7,9,13,19,25,33,49};
        
        this.imgMatrix  = pMatrix;
        this.imgLines   = pTotalLines;
        this.imgColumns = pTotalColumns;
        this.imgColours = pNumberOfColours;
        System.out.println(pNumberOfColours+" - "+pTotalLines+" - "+pTotalColumns+" - "+sizeSubMatriz);
    }
    
    public boolean prepareData(){
        
        return true;
    }
    
    public boolean setSelectionSort(){
        if(this.selectionSort == true)
            this.selectionSort = false;
        else
            this.selectionSort = true;
        return this.selectionSort;
    }
    
    public boolean setBubbleSort(){
        if(this.bubbleSort == true)
            this.bubbleSort = false;
        else
            this.bubbleSort = true;
        return this.bubbleSort;
    }
    
    public boolean setInsertionSort(){
        if(this.insertionSort == true)
            this.insertionSort = false;
        else
            this.insertionSort = true;
        return this.insertionSort;
    }
    
    public boolean setQuickSort(){
        if(this.quickSort == true)
            this.quickSort = false;
        else
            this.quickSort = true;
        return this.quickSort;
    }
    
    public boolean getAnySortTrue(){
        return (this.bubbleSort || this.insertionSort || this.quickSort || this.selectionSort);
    }
    
    public boolean setShowGraphic(){
        if(this.showGraphic == true)
            this.showGraphic = false;
        else
            this.showGraphic = true;
        return this.showGraphic;
    }
}
