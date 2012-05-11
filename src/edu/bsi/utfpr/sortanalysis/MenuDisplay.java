package edu.bsi.utfpr.sortanalysis;

import java.awt.Color;
import javax.swing.JOptionPane;


/**
 * @author Thiago Augustus de Oliveira
 * @version 1.0.0
 * @since 05-07-2012
 */

public class MenuDisplay extends javax.swing.JFrame {
    
    // Set the number of sub matrix avaliable
    private FileInput input;
    private ReadPGMImage imgFile;
    private Core core;
    
    /**
     * Constructor method
     */
    public MenuDisplay() {
        initComponents();
        this.imgFile = new ReadPGMImage();
        this.input   = new FileInput();
        this.core    = new Core();
        setLocation(300, 50);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titleMenuPanel = new javax.swing.JLabel();
        selectionSortButton = new javax.swing.JButton();
        quickSortButton = new javax.swing.JButton();
        bubbleSortButton = new javax.swing.JButton();
        insertionSortButton = new javax.swing.JButton();
        matrizSizeButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        matrizLabel = new javax.swing.JLabel();
        imageFile = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setMaximumSize(new java.awt.Dimension(300, 300));

        titleMenuPanel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        titleMenuPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleMenuPanel.setText("Sort Analysis");
        titleMenuPanel.setToolTipText("Sort Analysis Methods Using image.pgm Treatment");

        selectionSortButton.setText("Selection Sort");
        selectionSortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionActionPerformed(evt);
            }
        });

        quickSortButton.setText("Quick Sort");
        quickSortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quickActionPerformed(evt);
            }
        });

        bubbleSortButton.setText("Bubble Sort");
        bubbleSortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bubbleActionPerformed(evt);
            }
        });

        insertionSortButton.setText("Insertion Sort");
        insertionSortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertionActionPerformed(evt);
            }
        });

        matrizSizeButton.setText("Size of Image Matriz");
        matrizSizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matrizSizeActionPerformed(evt);
            }
        });

        startButton.setText("Start Analysis");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        matrizLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        matrizLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        matrizLabel.setText("3 x 3");

        imageFile.setText("Image File");
        imageFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageFileActionPerformed(evt);
            }
        });

        statusLabel.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        statusLabel.setForeground(new java.awt.Color(255, 0, 0));
        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bubbleSortButton, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectionSortButton, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insertionSortButton, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quickSortButton, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(matrizSizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(matrizLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageFile, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleMenuPanel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectionSortButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bubbleSortButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(insertionSortButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quickSortButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(matrizSizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(matrizLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imageFile, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(statusLabel))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionActionPerformed
        // TODO add your handling code here:
        if(this.core.setSelectionSort())
            this.selectionSortButton.setBackground(Color.GREEN);
        else
            this.selectionSortButton.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_selectionActionPerformed

    private void bubbleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bubbleActionPerformed
        // TODO add your handling code here:
        if(this.core.setBubbleSort())
            this.bubbleSortButton.setBackground(Color.GREEN);
        else
            this.bubbleSortButton.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_bubbleActionPerformed

    private void insertionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertionActionPerformed
        // TODO add your handling code here:
        if(this.core.setInsertionSort())
            this.insertionSortButton.setBackground(Color.GREEN);
        else
            this.insertionSortButton.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_insertionActionPerformed

    private void quickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quickActionPerformed
        // TODO add your handling code here:
        if(this.core.setQuickSort())
            this.quickSortButton.setBackground(Color.GREEN);
        else
            this.quickSortButton.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_quickActionPerformed

    private void matrizSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matrizSizeActionPerformed
        // TODO add your handling code here:
        this.matrizLabel.setText(this.core.getNextSubMatrix());
    }//GEN-LAST:event_matrizSizeActionPerformed

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        // TODO add your handling code here:
        // Set as not enable the start button
        this.startButton.setEnabled(false);
        // Verify if is any sort selected
        if(this.core.getAnySortTrue()){
            try{
                // Reading the file and creating this matriz and header
                this.imgFile.setImage(this.input.getFilePath());
                // Setting the core object and preparing the data
                this.core.setImageFile(this.imgFile);
                if(this.core.startSort()){
                    // Reset the start button
                    this.startButton.setEnabled(true);
                }                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "File was not found");
                // Reset the status label e start button
                this.startButton.setEnabled(true);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Select one or more sort");
            // Reset the status label e start button
            this.startButton.setEnabled(true);
        }
        
    }//GEN-LAST:event_startActionPerformed

    private void imageFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageFileActionPerformed
        // TODO add your handling code here:
            this.input.setVisible(true);
    }//GEN-LAST:event_imageFileActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MenuDisplay().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bubbleSortButton;
    private javax.swing.JButton imageFile;
    private javax.swing.JButton insertionSortButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel matrizLabel;
    private javax.swing.JButton matrizSizeButton;
    private javax.swing.JButton quickSortButton;
    private javax.swing.JButton selectionSortButton;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel titleMenuPanel;
    // End of variables declaration//GEN-END:variables
}
