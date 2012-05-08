package edu.bsi.utfpr.sortanalysis;

import java.io.File;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileInput extends javax.swing.JFrame {
    
    // Attributes
    private File file;
    private String fileName;
    private String filePath;

    /**
     * Init the constructor method
     */
    public FileInput() {
        initComponents();
        this.fileName = null;
        this.filePath = null;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocation(500, 50);
        this.fileChooser.setFileFilter(new FileNameExtensionFilter("file.pgm", "pgm"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileChooser.setSelectedFiles(null);
        fileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fileChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Return the file name
     * @return String
     */
    public String getFileName(){
        return this.fileName;
    }
    
    /** 
     * Return the file path
     * @return String 
     */
    public String getFilePath(){
        return this.filePath;
    }
    
    private void fileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserActionPerformed
        // TODO add your handling code here:
        if(evt.getActionCommand().equals("ApproveSelection")){
            this.file = this.fileChooser.getSelectedFile();
            this.fileName = this.file.getName();
            this.filePath = this.file.getPath();
            this.dispose();
        }
        else if(evt.getActionCommand().equals("CancelSelection")){
            this.dispose();
        }
    }//GEN-LAST:event_fileChooserActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser fileChooser;
    // End of variables declaration//GEN-END:variables
}
