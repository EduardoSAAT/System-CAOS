/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import Algoritms.Cad;

/**
 *
 * @author Ing Lalux
 */
public class Editor_Areas extends javax.swing.JFrame {

    /**
     * Creates new form Editor_Areas
     */
    public Editor_Areas() {
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
        textAgregarArea = new javax.swing.JTextField();
        botonAgregarArea = new javax.swing.JButton();
        textCambiarArea = new javax.swing.JTextField();
        botonCambiarArea = new javax.swing.JButton();
        botonEliminaArea = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("EDITOR DE AREAS");

        botonAgregarArea.setText("Agregar Nueva Area");
        botonAgregarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarAreaActionPerformed(evt);
            }
        });

        botonCambiarArea.setText("Cambiar Nombre Area");
        botonCambiarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambiarAreaActionPerformed(evt);
            }
        });

        botonEliminaArea.setText("Eliminar Area");
        botonEliminaArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminaAreaActionPerformed(evt);
            }
        });

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textAgregarArea)
                    .addComponent(botonAgregarArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textCambiarArea)
                    .addComponent(botonCambiarArea, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(botonEliminaArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonGuardar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textAgregarArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonAgregarArea)
                .addGap(18, 18, 18)
                .addComponent(textCambiarArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonCambiarArea)
                .addGap(18, 18, 18)
                .addComponent(botonEliminaArea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(botonGuardar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarAreaActionPerformed
        //Comprobar las condiciones iniciales
        if(Cad.isNulloVacia(textAgregarArea.getText()) || Cad.Equals("Cambiar Nombre Aqui!",textAgregarArea.getText(),false)){
            //Mandar un error
            textAgregarArea.setText("Cambiar Nombre Aqui!");
        }else{
            //Comprobar que ID no Exista
            if(Principal.DataControll.posActual_ArbolID(textAgregarArea.getText()) == -1){
                //Entonces no se encontro registro como este en el arbol y se puede agregar
                Principal.numNodos=Principal.numNodos+1;
                String newArbol = "A("+textAgregarArea.getText()+")"+"ID("+Principal.numNodos+")"+"%(0)"+"ACT("+textAgregarArea.getText()+")";
                Principal.DataControll.crearActual_Arbol(newArbol);
                
                //Reload del Tablero General
                Principal.MenuP.MenuTablero.Cargar_ComboAreas();
                Principal.MenuP.MenuTablero.Reload();
                
                //Cerrar esta ventana
                this.dispose();
            }else{
                textAgregarArea.setText("Arbol ya existe en el Registro!");
            }
        }
    }//GEN-LAST:event_botonAgregarAreaActionPerformed

    private void botonCambiarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambiarAreaActionPerformed
        if((Cad.isNulloVacia(textCambiarArea.getText())==false) && (textCambiarArea.getText().equals("Cambiar texto aqui!")==false)){
            //Modificar el Registro
            String oldName = Principal.MenuP.MenuTablero.comboAreas.getItemAt(Principal.MenuP.MenuTablero.comboAreas.getSelectedIndex());
            String newName = textCambiarArea.getText();
            Principal.DataControll.editaNameActual_Arbol(oldName, newName);


            //Recargar el Tablero
            Principal.MenuP.MenuTablero.Cargar_ComboAreas();
            Principal.MenuP.MenuTablero.Reload();
        }else{
            textCambiarArea.setText("Cambiar texto aqui!");
        }
    }//GEN-LAST:event_botonCambiarAreaActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        Principal.DataControll.saveActualReg_actualFile();
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonEliminaAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminaAreaActionPerformed
        //Modificar los Datos
        String nameArbol = Principal.MenuP.MenuTablero.comboAreas.getItemAt(Principal.MenuP.MenuTablero.comboAreas.getSelectedIndex());
        Principal.DataControll.eliminaActual_Arbol(nameArbol);
        
        //Pedir un Reload del Trablero
        Principal.MenuP.MenuTablero.Cargar_ComboAreas();
        Principal.MenuP.MenuTablero.Reload();
    }//GEN-LAST:event_botonEliminaAreaActionPerformed

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
            java.util.logging.Logger.getLogger(Editor_Areas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Editor_Areas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Editor_Areas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editor_Areas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Editor_Areas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregarArea;
    private javax.swing.JButton botonCambiarArea;
    private javax.swing.JButton botonEliminaArea;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField textAgregarArea;
    private javax.swing.JTextField textCambiarArea;
    // End of variables declaration//GEN-END:variables
}
