package edu.bsi.utfpr.sortanalysis;

public class Core {
    
    // Set all attributes
    private ReadPGMImage file; // Save the object file that is selected
    private ResultFileSort txtFile; // Save all sorts results
    // Define what sorts will be analysed
    private boolean   selectionSort;
    private boolean   bubbleSort;
    private boolean   insertionSort;
    private boolean   quickSort;
    private boolean   showGraphic;
    // Define the size of the sub matriz to analyse
    private int[]     subMatrizSize = {3, 5, 7, 9, 13, 19, 25, 33, 49}; // Define all submatriz size
    private int       subMatrizCounter; // Define a submatriz size counter
    // Declare new sub
    private int[][]   newSubMatriz;
    private int       borderValue; // Save the color os the img border
    // Save time millis from the sort where is executing
    private long startTime;
    private long endTime;
    private long diffTime;
    
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
        // Verify what sort time is selected
        if(this.selectionSort){
            // Create a new file text to save the results
            this.txtFile    = new ResultFileSort("selectionSort");
            this.txtFile.addValue("SELECTION SORT");
            this.txtFile.newLine();
            // Get the time in milliseconds
            this.startTime  = System.currentTimeMillis();
            // Start to order the matriz
            this.newOrderedMatriz(1);
            // Ordered time taked
            this.txtFile.addValue(String.format("Order Time: %02d:%03d sec/mil", (System.currentTimeMillis() - this.startTime)/1000, (System.currentTimeMillis() - this.startTime)%1000));
            this.txtFile.newLine();
            // Create a new image with the ordered matriz
            this.createNewImage(this.newSubMatriz);
            // Ordered time taked
            this.txtFile.addValue(String.format("Total Time: %02d:%03d sec/mil", (System.currentTimeMillis() - this.startTime)/1000, (System.currentTimeMillis() - this.startTime)%1000));
            // Close the text file
            this.txtFile.closeFile();
        }
        if(this.bubbleSort){
            this.txtFile = new ResultFileSort("bubbleSort");
            this.txtFile.addValue("BUBBLE SORT");
            this.txtFile.newLine();
            // Get the time in milliseconds
            this.startTime  = System.currentTimeMillis();
            // Start to order the matriz
            this.newOrderedMatriz(2);
            // Ordered time taked
            this.txtFile.addValue(String.format("Order Time: %02d:%03d sec/mil", (System.currentTimeMillis() - this.startTime)/1000, (System.currentTimeMillis() - this.startTime)%1000));
            this.txtFile.newLine();
            // Create a new image with the ordered matriz
            this.createNewImage(this.newSubMatriz);
            // Ordered time taked
            this.txtFile.addValue(String.format("Total Time: %02d:%03d sec/mil", (System.currentTimeMillis() - this.startTime)/1000, (System.currentTimeMillis() - this.startTime)%1000));
            // Close the text file
            this.txtFile.closeFile();
        }
        if(this.insertionSort){
            this.txtFile = new ResultFileSort("insertionSort");
            this.txtFile.addValue("INSERTION SORT");
            this.txtFile.newLine();
            // Get the time in milliseconds
            this.startTime  = System.currentTimeMillis();
            // Start to order the matriz
            this.newOrderedMatriz(3);
            // Ordered time taked
            this.txtFile.addValue(String.format("Order Time: %02d:%03d sec/mil", (System.currentTimeMillis() - this.startTime)/1000, (System.currentTimeMillis() - this.startTime)%1000));
            this.txtFile.newLine();
            // Create a new image with the ordered matriz
            this.createNewImage(this.newSubMatriz);
            // Ordered time taked
            this.txtFile.addValue(String.format("Total Time: %02d:%03d sec/mil", (System.currentTimeMillis() - this.startTime)/1000, (System.currentTimeMillis() - this.startTime)%1000));
            // Close the text file
            this.txtFile.closeFile();
        }
        if(this.quickSort){
            this.txtFile = new ResultFileSort("quickSort");
            this.txtFile.addValue("QUICK SORT");
            this.txtFile.newLine();
            // Get the time in milliseconds
            this.startTime  = System.currentTimeMillis();
            // Start to order the matriz
            this.newOrderedMatriz(4);
            // Ordered time taked
            this.txtFile.addValue(String.format("Order Time: %02d:%03d sec/mil", (System.currentTimeMillis() - this.startTime)/1000, (System.currentTimeMillis() - this.startTime)%1000));
            this.txtFile.newLine();
            // Create a new image with the ordered matriz
            this.createNewImage(this.newSubMatriz);
            // Ordered time taked
            this.txtFile.addValue(String.format("Total Time: %02d:%03d sec/mil", (System.currentTimeMillis() - this.startTime)/1000, (System.currentTimeMillis() - this.startTime)%1000));
            // Close the text file
            this.txtFile.closeFile();
        }
        return true;
    }
    
    private void newOrderedMatriz(int sort){
        // Add some temp attributes
        int start           = (int) Math.floor(this.subMatrizSize[this.subMatrizCounter] / 2); // Define the start point to read in the image file matriz
        int end             = this.file.getMatrixLines() - start; // Define the last point to read in the image file matriz
        int tempCounter     = 0;
        
        // Create the new matriz
        for(int line = 0; line < this.newSubMatriz.length; line++){
            long tempTime = System.currentTimeMillis();
            for(int column = 0; column < this.newSubMatriz[line].length; column++){
                // Fill all new matrix borders with an value
                if(line < start || line >= end || column < start || column >= end){
                    this.newSubMatriz[line][column] = this.borderValue;
                }
                else{
                    switch(sort){
                        case 1: this.newSubMatriz[line][column] = Sort.selectionSort(getSubArray(line, column));
                        break;
                        case 2: this.newSubMatriz[line][column] = Sort.bubbleSort(getSubArray(line, column));
                        break;
                        case 3: this.newSubMatriz[line][column] = Sort.insertionSort(getSubArray(line, column));
                        break;
                        case 4: 
                        break;
                    }
                }
            }
            this.txtFile.addValue(String.format("Line[%03d]: %02d:%03d sec/mil", line, (System.currentTimeMillis() - tempTime)/1000, (System.currentTimeMillis() - tempTime)%1000));
            this.txtFile.newLine();
        }       
    }
    
    private void createNewImage(int[][] matriz){
        PGMCreator newFile = new PGMCreator("imagem.pgm");
        newFile.createHeader("P2", this.file.getMatrixLines(), this.file.getMatrixColumns(), this.file.getNumberOfColour());
        for(int line = 0; line < this.newSubMatriz.length; line++){
            for(int column = 0; column < this.newSubMatriz[line].length; column++){
                // Fill all new matrix borders with an value
                newFile.addValue(String.valueOf(this.newSubMatriz[line][column])+" ");
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