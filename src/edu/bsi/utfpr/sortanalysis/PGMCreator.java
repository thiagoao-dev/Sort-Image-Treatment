/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bsi.utfpr.sortanalysis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author augustus
 */
public class PGMCreator {
    
    private String fileName;
    private File file;
    private FileWriter fWriter;
    private BufferedWriter bWriter;
    
    
    public PGMCreator(String pFileName){
        this.fileName = pFileName;
        this.initConfig();
    }

    private void initConfig(){
        // Create new file object
        this.file = new File(this.fileName);
        // Verify if this file exists
        if(!this.file.isFile()){
            try {
                this.file.createNewFile(); /* Cria um novo arquivo */
            } catch (IOException e) {
                // TODO Auto-generated catch block
                JOptionPane.showMessageDialog(null, "The new file cannot be created");
            }
        }
        // Create new file write object
        try {
            this.fWriter = new FileWriter(this.file);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "The new file cannot be writed");
        }
        // Create new buffered writer
        this.bWriter = new BufferedWriter(this.fWriter);
    }
    
    public void createHeader(String type, int nLines, int nColumns, int nColors){
        try {
            this.bWriter.write(type);
            this.bWriter.newLine();
            this.bWriter.write(nLines+" "+nColumns);
            this.bWriter.newLine();
            this.bWriter.write(String.valueOf(nColors));
            this.bWriter.newLine();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "The new file cannot be writed");
        }
    }
    
    public void addValue(String value){
        try {
            this.bWriter.write(value);
            this.bWriter.flush();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "The new file cannot be writed");
        }
    }
    
    public void newLine(){
        try {
            this.bWriter.newLine();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "The new file cannot be writed");
        }
    }
    
    public void closeFile(){
        try {
            this.bWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(PGMCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.fWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(PGMCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
