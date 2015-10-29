/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicalanalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gil
 */
public class Interface extends javax.swing.JFrame {

    /**
     * Creates new form Interface
     */
    public Interface() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Enter Text");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setText("Result");

        jButton1.setText("Analyze");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jButton1)
                .addContainerGap(182, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         try{
             probarLexerFile();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }
    public void probarLexerFile() throws IOException{
        File fichero = new File ("fichero.txt");
        PrintWriter writer;
        try {
            writer = new PrintWriter(fichero);
            writer.print(jTextField1.getText());
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
        Reader reader = new BufferedReader(new FileReader(fichero));
        Lexer lexer = new Lexer (reader);
        String resultado = "";
        while (true){
            Token token =lexer.yylex();
            if (token == null){
                resultado = resultado + "EOF";
                jTextArea1.setText(resultado);
                return;
            }
            switch (token){
                case QGENOP: 
                    resultado=resultado+ "<QGENOP: " + lexer.lexeme + "> ";
                   break;
                case ERROR: 
                    resultado=resultado+ "<ERROR: " + lexer.lexeme + "> ";
                   break;
                case SEPARATOR: 
                    resultado=resultado+ "<SEPARATOR: " + lexer.lexeme + "> ";
                   break;
                case COMMENT: 
                    resultado=resultado+ "<COMMENT: " + lexer.lexeme + "> ";
                   break;
                case EOL: 
                    resultado=resultado+ "<EOL: " + lexer.lexeme + "> ";
                   break;
                case CONCATENATION: 
                    resultado=resultado+ "<CONCATENATION: " + lexer.lexeme + "> ";
                   break;
                case ASSIGNMENT: 
                    resultado=resultado+ "<ASSIGNMENT: " + lexer.lexeme + "> ";
                   break;
                case RC: 
                    resultado=resultado+ "<RC: " + lexer.lexeme + "> ";
                   break;
                case LC: 
                    resultado=resultado+ "<LC: " + lexer.lexeme + "> ";
                   break;
                case RM: 
                    resultado=resultado+ "<RM: " + lexer.lexeme + "> ";
                   break;
                case LL: 
                    resultado=resultado+ "<LL: " + lexer.lexeme + "> ";
                   break;
                case RP: 
                    resultado=resultado+ "<RP: " + lexer.lexeme + "> ";
                   break;
                case LP: 
                    resultado=resultado+ "<LP: " + lexer.lexeme + "> ";
                   break;
                case RB: 
                    resultado=resultado+ "<RB: " + lexer.lexeme + "> ";
                   break;
                case LB: 
                    resultado=resultado+ "<LB: " + lexer.lexeme + "> ";
                   break;
                case TABLEOP: 
                    resultado=resultado+ "<TABLEOP: " + lexer.lexeme + "> ";
                   break;
                case FOROP: 
                    resultado=resultado+ "<FOROP: " + lexer.lexeme + "> ";
                   break;
                case INOP: 
                    resultado=resultado+ "<INOP: " + lexer.lexeme + "> ";
                   break;
                default:
                    resultado=resultado+ "<"+ lexer.lexeme + "> ";
            }
    }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}