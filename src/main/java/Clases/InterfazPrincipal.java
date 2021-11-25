package Clases;

import java.awt.Cursor;
import java.awt.FileDialog;
import static java.awt.Frame.HAND_CURSOR;
import java.io.File;
import java.io.FilenameFilter;
import javax.swing.ImageIcon;

public class InterfazPrincipal extends javax.swing.JFrame {

    ControlArchivos control;
    String archivoUsuario;//direccion del archivo seleccionado por el usuario

    public InterfazPrincipal() {
        initComponents();
        nombreArchivo.setText("Archivo seleccionado: Vacio");
        cambioBotonMetodo(botonMetodo.isSelected());
        setBotonesNuevos();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        seleccionarArchivo = new javax.swing.JButton();
        nombreArchivo = new javax.swing.JLabel();
        analizarArchivo = new javax.swing.JButton();
        botonMetodo = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        seleccionarArchivo.setBorderPainted(false);
        seleccionarArchivo.setContentAreaFilled(false);
        seleccionarArchivo.setFocusPainted(false);
        seleccionarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarArchivoActionPerformed(evt);
            }
        });

        nombreArchivo.setText("Archivo seleccionado:");

        analizarArchivo.setBorderPainted(false);
        analizarArchivo.setContentAreaFilled(false);
        analizarArchivo.setFocusable(false);
        analizarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analizarArchivoActionPerformed(evt);
            }
        });

        botonMetodo.setBorderPainted(false);
        botonMetodo.setContentAreaFilled(false);
        botonMetodo.setFocusPainted(false);
        botonMetodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMetodoActionPerformed(evt);
            }
        });

        jLabel1.setText("Busqueda binaria");

        jLabel2.setText("Hash");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(analizarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seleccionarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(analizarArchivo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(17, 17, 17)))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seleccionarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreArchivo))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void seleccionarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarArchivoActionPerformed
        FileDialog fd = new FileDialog(this, "Selecciona un archivo", FileDialog.LOAD);
        fd.setDirectory("C:\\");
        fd.setFile("*.txt;*.csv;*.c*.cs");//Archivos permitidos por el programa
        fd.setVisible(true);
        fd.setFilenameFilter(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt") || name.endsWith(".csv")|| name.endsWith(".cs")|| name.endsWith(".c");
            }
        });
        String filename = fd.getFile();//obtenemos el nombre del archivo
        if (filename == null) {
            nombreArchivo.setText("Archivo seleccionado: Vacio");//en caso de que no seleccionase nada,
            //escribir Archivo vacio de nuevo
        } else {
            nombreArchivo.setText("Archivo seleccionado: " + fd.getFile());//En caso contrario, escribir
            //el nombre del archivo en la ventana
        }
        archivoUsuario = fd.getDirectory() + fd.getFile();//Construccion de la cadena completa del 
        //archivo elegido
    }//GEN-LAST:event_seleccionarArchivoActionPerformed

    private void analizarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analizarArchivoActionPerformed
        if(archivoUsuario!=null){
            control = new ControlArchivos(this);
        control.setMetodo(botonMetodo.isSelected());
        System.out.println(nombreArchivo.getText());
        System.out.println("uno dos tres");
        String[] s = nombreArchivo.getText().split(" ");
        System.out.println(s[s.length-1]);
        System.out.println();
        control.leerArchivos(archivoUsuario,s[s.length-1]);
        }else{
            System.out.println("No hay ningun archivo seleccionado");
        }
    }//GEN-LAST:event_analizarArchivoActionPerformed

    private void botonMetodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMetodoActionPerformed
    cambioBotonMetodo(botonMetodo.isSelected());
    }//GEN-LAST:event_botonMetodoActionPerformed
    private void cambioBotonMetodo(boolean metodo){
       if(metodo){
        ImageIcon boton = new ImageIcon("src\\main\\java\\botones\\toogleNormal.png");
         botonMetodo.setIcon(boton);
       }else {
           ImageIcon boton = new ImageIcon("src\\main\\java\\botones\\toogleInvertido.png");
            botonMetodo.setIcon(boton);
       }
    }
    public void setBotonesNuevos(){
        ImageIcon boton = new ImageIcon("src\\main\\java\\Botones\\analizar1.png");
        analizarArchivo.setIcon(boton);
        boton = new ImageIcon("src\\main\\java\\Botones\\analizar0.png");
        analizarArchivo.setRolloverIcon(boton);
        boton = new ImageIcon("src\\main\\java\\Botones\\analizar2.png");
        analizarArchivo.setPressedIcon(boton);
        analizarArchivo.setCursor(new Cursor(HAND_CURSOR));
        
        boton = new ImageIcon("src\\main\\java\\Botones\\seleccionarArchivo1.png");
        seleccionarArchivo.setIcon(boton);
        boton = new ImageIcon("src\\main\\java\\Botones\\seleccionarArchivo0.png");
        seleccionarArchivo.setRolloverIcon(boton);
        boton = new ImageIcon("src\\main\\java\\Botones\\seleccionarArchivo2.png");
        seleccionarArchivo.setPressedIcon(boton);
        seleccionarArchivo.setCursor(new Cursor(HAND_CURSOR));
    }

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
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton analizarArchivo;
    private javax.swing.JToggleButton botonMetodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel nombreArchivo;
    private javax.swing.JButton seleccionarArchivo;
    // End of variables declaration//GEN-END:variables
}
