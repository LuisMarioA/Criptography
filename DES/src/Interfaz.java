import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Interfaz extends javax.swing.JFrame {
    public Interfaz() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonSeleccionarArchivo = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        jComboBoxStandard = new javax.swing.JComboBox<>();
        jComboBoxOperationMode = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonDecrypt = new javax.swing.JButton();
        jButtonEncrypt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("DES & AES");

        jButtonSeleccionarArchivo.setText("Select image");
        jButtonSeleccionarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeleccionarArchivoActionPerformed(evt);
            }
        });

        txtNombre.setEditable(false);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jComboBoxStandard.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DES", "AES" }));
        jComboBoxStandard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxStandardActionPerformed(evt);
            }
        });

        jComboBoxOperationMode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ECB", "OFB", "CBC", "CFB" }));
        jComboBoxOperationMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOperationModeActionPerformed(evt);
            }
        });

        jLabel2.setText("Select Standard");

        jLabel3.setText("Select Operation mode");

        jButtonDecrypt.setText("Decrypt");
        jButtonDecrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDecryptActionPerformed(evt);
            }
        });

        jButtonEncrypt.setText("Encrypt");
        jButtonEncrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEncryptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(143, 143, 143))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonDecrypt))
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxStandard, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxOperationMode, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSeleccionarArchivo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(106, 106, 106)
                    .addComponent(jButtonEncrypt)
                    .addContainerGap(219, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSeleccionarArchivo))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxStandard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxOperationMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jButtonDecrypt)
                .addGap(25, 25, 25))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(155, Short.MAX_VALUE)
                    .addComponent(jButtonEncrypt)
                    .addGap(24, 24, 24)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSeleccionarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSeleccionarArchivoActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File (".")); 
        int respuesta = fc.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION){
            //Crear un objeto File con el archivo elegido
            File archivoElegido = fc.getSelectedFile();
            //Mostrar el nombre del archvivo en un campo de texto
            txtNombre.setText(archivoElegido.getName());
            nombreArchivo=archivoElegido.getName();
            rutaArchivo=archivoElegido.getParent();
            try {
                myCipher.mostrarImagen(nombreArchivo);
            } catch (IOException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonSeleccionarArchivoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void jComboBoxStandardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxStandardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxStandardActionPerformed

    private void jComboBoxOperationModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOperationModeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxOperationModeActionPerformed

    private void jButtonDecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDecryptActionPerformed
        String standard=jComboBoxStandard.getSelectedItem().toString();
        String modo=jComboBoxOperationMode.getSelectedItem().toString();
        System.out.println(standard + " " + modo);
        String llave=JOptionPane.showInputDialog(null, "Key=");
        if(standard.equals("DES")){
             if(modo.equals("ECB"))
                 MyCipher.DES_ECB(2, llave, nombreArchivo);
             else
                 MyCipher.DES_(2,modo,llave,nombreArchivo);
        }else if(standard.equals("AES")){
            if(modo.equals("ECB"))
                 MyCipher.AES_ECB(2, llave, nombreArchivo);
             else
                 MyCipher.AES_(2,modo,llave,nombreArchivo);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDecryptActionPerformed

    private void jButtonEncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEncryptActionPerformed
       String standard=jComboBoxStandard.getSelectedItem().toString();
       String modo=jComboBoxOperationMode.getSelectedItem().toString();
       System.out.println(standard + " " + modo);
       String llave=JOptionPane.showInputDialog(null, "Key=");
       if(standard.equals("DES")){
            if(modo.equals("ECB"))
                MyCipher.DES_ECB(1, llave, nombreArchivo);
            else
                MyCipher.DES_(1,modo,llave,nombreArchivo);
       }else if(standard.equals("AES")){
           if(modo.equals("ECB"))
                MyCipher.AES_ECB(1, llave, nombreArchivo);
            else
                MyCipher.AES_(1,modo,llave,nombreArchivo);
       }
    }//GEN-LAST:event_jButtonEncryptActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDecrypt;
    private javax.swing.JButton jButtonEncrypt;
    private javax.swing.JButton jButtonSeleccionarArchivo;
    private javax.swing.JComboBox<String> jComboBoxOperationMode;
    private javax.swing.JComboBox<String> jComboBoxStandard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
    String rutaArchivo="";
    String nombreArchivo="";
    private MyCipher myCipher=new MyCipher();
}
