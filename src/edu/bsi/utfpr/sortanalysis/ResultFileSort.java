package edu.bsi.utfpr.sortanalysis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResultFileSort {
    
    private File file;
    private FileWriter fWriter;
    private BufferedWriter bWriter;
    
    public ResultFileSort(String fileName){
        // Define a new object txt
        this.file = new File(fileName+".txt");
        // Verify if this file exists
        if(!this.file.isFile()){
            try {
                this.file.createNewFile();
            } catch (Exception e) {}
        }
        try {
            this.fWriter = new FileWriter(this.file);
            this.bWriter = new BufferedWriter(this.fWriter);
        } catch (IOException ex) {}
    }
    
    public void addValue(String value){
        try {
            this.bWriter.write(value);
        } catch (IOException ex) {}
    }
    
    public void newLine(){
        try {
            this.bWriter.newLine();
        } catch (IOException ex) {}
    }
    
    public void closeFile(){
        try {
            this.bWriter.close();
            this.fWriter.close();
        } catch (IOException ex) {}
    }
    
}
