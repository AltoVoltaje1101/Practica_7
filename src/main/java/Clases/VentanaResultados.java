/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Clases;

/**
 *
 * @author felix_5bh1a4y
 */
public class VentanaResultados extends javax.swing.JDialog {

    /**
     * Creates new form VentanaResultados
     */
    public VentanaResultados(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public void mostrarResultados(int ignoradas,int agregadas, int reemplazadas,int totales,int malas){
        
        palabrasIgnoradas.setText("Palabras ignoradas:"+ignoradas);
        palabrasAgregadas.setText("Palabras Agregadas:"+agregadas);
        palabrasCorregidas.setText("Palabras reemplazadas:"+reemplazadas);
        palabrasTotales.setText("Palabras Totales:"+totales);
        this.malas.setText("Palabras Incorrectas:"+malas);
                setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        palabrasIgnoradas = new javax.swing.JLabel();
        palabrasAgregadas = new javax.swing.JLabel();
        palabrasCorregidas = new javax.swing.JLabel();
        palabrasTotales = new javax.swing.JLabel();
        malas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        palabrasIgnoradas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        palabrasIgnoradas.setText("jLabel1");

        palabrasAgregadas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        palabrasAgregadas.setText("jLabel1");

        palabrasCorregidas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        palabrasCorregidas.setText("jLabel1");

        palabrasTotales.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        palabrasTotales.setText("jLabel1");

        malas.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(malas)
                    .addComponent(palabrasTotales)
                    .addComponent(palabrasCorregidas)
                    .addComponent(palabrasAgregadas)
                    .addComponent(palabrasIgnoradas))
                .addContainerGap(226, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(palabrasIgnoradas)
                .addGap(18, 18, 18)
                .addComponent(palabrasAgregadas)
                .addGap(18, 18, 18)
                .addComponent(palabrasCorregidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(malas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(palabrasTotales)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VentanaResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaResultados dialog = new VentanaResultados(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel malas;
    private javax.swing.JLabel palabrasAgregadas;
    private javax.swing.JLabel palabrasCorregidas;
    private javax.swing.JLabel palabrasIgnoradas;
    private javax.swing.JLabel palabrasTotales;
    // End of variables declaration//GEN-END:variables
}
