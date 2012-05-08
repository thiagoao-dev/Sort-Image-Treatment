package edu.bsi.utfpr.sortanalysis;

/**
 * @author Thiago Augustus de Oliveira
 * @version 1.0.0
 * @since 05-07-2012
 */

import java.io.*;
import javax.swing.JOptionPane;

public class ReadPGMImage {
 
    // Attributes
    private String imgName;
    private File file;
    private FileReader fileReader;
    private BufferedReader bFileReader;
    private int[][] imgMatrix;
    private int imgW;
    private int imgH;
    private int imgNumColor;
    
    /**
     * Set image name
     * @param pImgName - full image path and name of the file
     */
    public boolean setImage(String pImgName){
        // Set the image path e name
        this.imgName = pImgName;
        // Init all
        return(this.initConfig());
    }
    
    private boolean initConfig(){
        // Initiate the attributes
        this.imgH = 0;
        this.imgW = 0;
        this.imgNumColor = 0;
        this.file = new File(this.imgName);
        
        // Verify if it's a valid file
        if(this.file.isFile()){
            try {
                this.fileReader = new FileReader(this.file);
                this.bFileReader = new BufferedReader(this.fileReader);
                // Set information from the header of the file
                this.setHeader();
                // Set the image matrix
                this.setMatrix();
            } 
            catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "The file can't be read");
                return false;
            }            
        }else{
            JOptionPane.showMessageDialog(null, "The file was not found");
            return false;
        }
        return true;
    }
    
    /**
     * Method to read a line from the file
     * @return String
     */
    private String getNextLine(){
        try {
            // Return the next line of the image file
            return this.bFileReader.readLine();
        } 
        catch (IOException ex) {
            // Return null
            return null;
        }
    }
    
    /**
     * SetHeader
     * @return void
     */
    private void setHeader(){
        // Verify if the first line is equal a P2
        if(this.getNextLine().equals("P2")){
            // Read the next line that have de size of the image file
            try{
                String size[] = this.getNextLine().split(" ");
                // Set some attributes with the sizes and number of colours of image file matrix
                this.imgH = Integer.parseInt(size[0]);
                this.imgW = Integer.parseInt(size[0]);
                this.imgNumColor = Integer.parseInt(this.getNextLine());
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error on read file header");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Error on read file header");
        }
    }
    
    /**
     * SetMatrix method, create a new matrix with the image file values readed
     * @return void
     */
    private void setMatrix(){
        // Init some attributes
        int tempLCount  = 0;
        int tempCCount  = 0;
        String tempLine = null;
        String tempArray[];
        // Create the matrix with same size of the image file readed
        this.imgMatrix = new int[this.imgH][this.imgW];
        // Do the loop while the return isn't null
        do{
            // Read the next line from the image file
            tempLine = this.getNextLine();
            // Verify if the tempLine isn't null
            if(tempLine != null){
                // Break the string where is space char
                tempArray = tempLine.split(" ");
                // Make a loop to read all the tempArray
                for(int i = 0; i < tempArray.length; i++){
                    // See if the limit of the matrix was not reached
                    if(tempLCount < this.imgH){
                        // See if the column counter reach the limit of the image matrix
                        if(tempCCount >= this.imgW){
                            // Increment line counter
                            tempLCount++;
                            // Increment the column counter
                            tempCCount = 0;
                        }
                        // Add the value of the temparray in the image matrix
                        this.imgMatrix[tempLCount][tempCCount] = Integer.parseInt(tempArray[i]);
                        // Increment the column counter
                        tempCCount++;
                    }
                }
            }
        // Keep looping while not reach the end of the image file
        }while(tempLine != null);
        
        // Call method to close de file
        this.closeFile();
    }
    
    /**
     * Close the file
     * @return void
     */
    private void closeFile(){
        try {
            this.bFileReader.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error to close the file");
        }
        try {
            this.fileReader.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error to close the file");
        }
    }
    
    /**
     * Return the image matrix
     * @return int[][]
     */
    public int[][] getMatrix(){
        return this.imgMatrix;
    }
    
    /**
     * Return the number of lines
     * @return int
     */
    public int getMatrixLines(){
        return this.imgH;
    }
    
    /**
     * Return the number of columns
     * @return int
     */
    public int getMatrixColumns(){
        return this.imgW;
    }
    
    /**
     * Return the number of colours
     * @return int
     */
    public int getNumberOfColour(){
        return this.imgNumColor;
    }
}
