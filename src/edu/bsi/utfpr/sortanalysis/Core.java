package edu.bsi.utfpr.sortanalysis;

public class Core {
    
    // Set all attributes
    private boolean   selectionSort;
    private boolean   bubbleSort;
    private boolean   insertionSort;
    private boolean   quickSort;
    private boolean   showGraphic;
    private int[]     subMatrizSize = {3, 5, 7, 9, 13, 19, 25, 33, 49}; // Define all submatriz size
    private int       subMatrizCounter; // Define a submatriz size counter
    private ReadPGMImage file;
    private int[][]   newSubMatriz;
    private int       borderValue;
    
    /**
     * Init the main attributes
     */
    public Core(){
        this.selectionSort    = false;
        this.bubbleSort       = false;
        this.insertionSort    = false;
        this.quickSort        = false;
        this.showGraphic      = false;
        this.subMatrizCounter = 0;
        this.borderValue      = 0;
    }
    
    /**
     * Start the ordering with the selected sort method
     * @return boolean
     */
    public boolean startSort(){
        // Get a new ordered matriz
        this.newOrderedMatriz();
        this.createNewImage(this.newSubMatriz);
        return true;
    }
    
    private void newOrderedMatriz(){
        // Add some temp attributes
        int start           = (int) Math.floor(this.subMatrizSize[this.subMatrizCounter] / 2); // Define the start point to read in the image file matriz
        int end             = this.file.getMatrixLines() - start; // Define the last point to read in the image file matriz
        int tempCounter     = 0;
        
        // Create the new matriz
        for(int line = 0; line < this.newSubMatriz.length; line++){
            for(int column = 0; column < this.newSubMatriz[line].length; column++){
                // Fill all new matrix borders with an value
                if(line < start || line >= end || column < start || column >= end){
                    this.newSubMatriz[line][column] = this.borderValue;
                }
                else{
                    this.newSubMatriz[line][column] = Sort.bubbleSort(getSubArray(line, column));
                }
            }
        }       
    }
    
    private void createNewImage(int[][] matriz){
        PGMCreator newFile = new PGMCreator("imagem.pgm");
        newFile.createHeader("P2", this.file.getMatrixLines(), this.file.getMatrixColumns(), this.file.getNumberOfColour());
        for(int line = 0; line < this.newSubMatriz.length; line++){
            for(int column = 0; column < this.newSubMatriz[line].length; column++){
                // Fill all new matrix borders with an value
                newFile.addValue(String.valueOf(this.newSubMatriz[column][line])+" ");
            }
            newFile.newLine();
        }
        newFile.closeFile();        
    }
    
    /**
     * Get the neighbor values in an array 
     * @param int x
     * @param int y
     * @return int[]
     */
    private int[] getSubArray(int x, int y){
        // Declare attributes
        int[] tempArray  = new int[this.subMatrizSize[this.subMatrizCounter]*this.subMatrizSize[this.subMatrizCounter]];
        int count        = 0;
        // Sets the neighborhood distance from the middle point
        int neighbor     = (int) Math.floor(this.subMatrizSize[this.subMatrizCounter] / 2);
        // Sets the minimum and maximum values distance for de main point
        int minY         = y - neighbor;
        int maxY         = y + neighbor;
        int minX         = x - neighbor;
        int maxX         = x + neighbor;
        // Run all position of the neighbor in axe Y
        for(int Y = minY; Y <= maxY; Y++){
            // Run all position of the neighbor in axe Y
            for(int X = minX; X <= maxX; X++){
                // Get the image file value
                tempArray[count] = this.file.getValue(Y, X);
                ++count;
            }
        }
        // Return an array
        return tempArray;
    }
    
    //Gets and Sets
    
    /**
     * Set-up the original image data
     */
    public void setImageFile(ReadPGMImage pImageFile){
        // Set the obj ReadPGMImage
        this.file = pImageFile;
        this.newSubMatriz = new int[this.file.getMatrixLines()][this.file.getMatrixColumns()];
    }    
    /**
     * Set-up the seleciton sort method
     * @return boolean
     */
    public boolean setSelectionSort(){
        if(this.selectionSort == true)
            this.selectionSort = false;
        else
            this.selectionSort = true;
        return this.selectionSort;
    }
    
    /**
     * Set-up the bubble sort method
     * @return boolean
     */
    public boolean setBubbleSort(){
        if(this.bubbleSort == true)
            this.bubbleSort = false;
        else
            this.bubbleSort = true;
        return this.bubbleSort;
    }
    
    /**
     * Set-up the insertion sort method
     * @return boolean
     */
    public boolean setInsertionSort(){
        if(this.insertionSort == true)
            this.insertionSort = false;
        else
            this.insertionSort = true;
        return this.insertionSort;
    }
    
    /**
     * Set-up the quick sort method
     * @return boolean
     */
    public boolean setQuickSort(){
        if(this.quickSort == true)
            this.quickSort = false;
        else
            this.quickSort = true;
        return this.quickSort;
    }
    
    /**
     * Return if is any sort selected
     * @return boolean
     */
    public boolean getAnySortTrue(){
        return (this.bubbleSort || this.insertionSort || this.quickSort || this.selectionSort);
    }
    
    /**
     * Set-up the graphic mode
     * @return boolean
     */
    public boolean setShowGraphic(){
        if(this.showGraphic == true)
            this.showGraphic = false;
        else
            this.showGraphic = true;
        return this.showGraphic;
    }
    
    /**
     * Return a String content the size of the submatriz size
     * @return String
     */
    public String getNextSubMatrix(){
        // Init the submatrix counter
        if(this.subMatrizCounter == this.subMatrizSize.length - 1)
            this.subMatrizCounter = -1;
        this.subMatrizCounter++;
        // Mount the String
        String temp = String.valueOf(this.subMatrizSize[this.subMatrizCounter]) + " x " + String.valueOf(this.subMatrizSize[this.subMatrizCounter]);
        return temp;
    }
}
