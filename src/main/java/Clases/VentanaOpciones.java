/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Clases;

import java.awt.Color;
import java.awt.Cursor;
import static java.awt.Frame.HAND_CURSOR;
import java.io.UnsupportedEncodingException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;

/**
 *
 * @author felix_5bh1a4y
 */
public class VentanaOpciones extends javax.swing.JDialog {
    VentanaResultados ventanaResultados;
    int eleccion;
    String palabraNoEncontrada;
    String palabraNueva;
    VentanaNuevaPalabra newWord;
    boolean siCambio;

    public VentanaOpciones(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        eleccion = 0;
        cuadroTexto.setEditable(false);
        newWord = new VentanaNuevaPalabra(parent, true);
        ventanaResultados = new VentanaResultados(parent,true);
        cambiarBotones();
    }

    public void enviarTexto(String texto, String palabraNoEncontrada) {
        this.palabraNoEncontrada = palabraNoEncontrada;
        cuadroTexto.setText(texto);
        subrayarPalabra();
        setVisible(true);
    }

    public void subrayarPalabra() {
        try {
            Highlighter hilite = cuadroTexto.getHighlighter();
            Document doc = cuadroTexto.getDocument();
            String text = doc.getText(0, doc.getLength());
            int pos = 0;
            // Search for pattern
            while ((pos = text.indexOf(palabraNoEncontrada, pos)) >= 0) {
                // Create highlighter using private painter and apply around pattern
                hilite.addHighlight(pos, pos + palabraNoEncontrada.length(), new DefaultHighlighter.DefaultHighlightPainter(Color.yellow));
                pos += palabraNoEncontrada.length();
            }
        } catch (BadLocationException e) {
            System.out.println("No salio bien");
        }
    }
    public void modificarInterfaz(int ignoradas,int agregadas, int reemplazadas,int totales,int malas){
        ventanaResultados.mostrarResultados(ignoradas,agregadas,reemplazadas,totales,malas);
        
    }

    public int getEleccion() {
        return eleccion;
    }
    public void setEleccion(int a){
        eleccion = a;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonIgnorar = new javax.swing.JButton();
        botonIgnorarTodo = new javax.swing.JButton();
        botonAgregarDiccionario = new javax.swing.JButton();
        botonTerminar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        cuadroTexto = new javax.swing.JTextPane();
        buscarReemplazar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        botonIgnorar.setBorderPainted(false);
        botonIgnorar.setContentAreaFilled(false);
        botonIgnorar.setFocusPainted(false);
        botonIgnorar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIgnorarActionPerformed(evt);
            }
        });

        botonIgnorarTodo.setBorderPainted(false);
        botonIgnorarTodo.setContentAreaFilled(false);
        botonIgnorarTodo.setFocusPainted(false);
        botonIgnorarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIgnorarTodoActionPerformed(evt);
            }
        });

        botonAgregarDiccionario.setBorderPainted(false);
        botonAgregarDiccionario.setContentAreaFilled(false);
        botonAgregarDiccionario.setFocusPainted(false);
        botonAgregarDiccionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarDiccionarioActionPerformed(evt);
            }
        });

        botonTerminar.setBorderPainted(false);
        botonTerminar.setContentAreaFilled(false);
        botonTerminar.setFocusPainted(false);
        botonTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTerminarActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(cuadroTexto);

        buscarReemplazar.setBorderPainted(false);
        buscarReemplazar.setContentAreaFilled(false);
        buscarReemplazar.setFocusPainted(false);
        buscarReemplazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarReemplazarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonIgnorar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(botonIgnorarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonAgregarDiccionario, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(buscarReemplazar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(botonTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(botonIgnorarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonAgregarDiccionario, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonIgnorar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buscarReemplazar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonIgnorarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIgnorarActionPerformed
        eleccion = 0;
        setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_botonIgnorarActionPerformed

    private void botonTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTerminarActionPerformed
        eleccion = 4;
        setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_botonTerminarActionPerformed

    private void botonIgnorarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIgnorarTodoActionPerformed
        eleccion = 1;
        setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_botonIgnorarTodoActionPerformed

    private void botonAgregarDiccionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarDiccionarioActionPerformed
        eleccion = 2;
        setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_botonAgregarDiccionarioActionPerformed

    private void buscarReemplazarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarReemplazarActionPerformed
        eleccion = 3;
        newWord.setTextoEstatico(palabraNoEncontrada);
        newWord.setVisible(true);
        palabraNueva = newWord.getNuevaPalabra();
        siCambio = newWord.getSiCambio();// TODO add your handling code here:
        if(siCambio){
            setVisible(false);
        }else{
            
            System.out.println("No se ingreo");
        }
    }//GEN-LAST:event_buscarReemplazarActionPerformed
    public boolean getSiCambio(){
        return siCambio;
    }
    public String getNuevaPalabra(){
        return palabraNueva;
    }
    public void cambiarBotones(){
        ImageIcon boton = new ImageIcon("src\\main\\java\\botones\\ignorar1.png");
        botonIgnorar.setIcon(boton);
        boton = new ImageIcon("src\\main\\java\\botones\\ignorar0.png");
        botonIgnorar.setRolloverIcon(boton);
        boton = new ImageIcon("src\\main\\java\\botones\\ignorar2.png");
        botonIgnorar.setPressedIcon(boton);
        botonIgnorar.setCursor(new Cursor(HAND_CURSOR));
        botonIgnorar.setLocation(90, 35);
        
        boton = new ImageIcon("src\\main\\java\\botones\\ignorarTodo1.png");
        botonIgnorarTodo.setIcon(boton);
        boton = new ImageIcon("src\\main\\java\\botones\\ignorarTodo0.png");
        botonIgnorarTodo.setRolloverIcon(boton);
        boton = new ImageIcon("src\\main\\java\\botones\\ignorarTodo2.png");
        botonIgnorarTodo.setPressedIcon(boton);
        botonIgnorarTodo.setCursor(new Cursor(HAND_CURSOR));
        botonIgnorar.setLocation(90, WIDTH);
        
        boton = new ImageIcon("src\\main\\java\\botones\\agregarDiccionario1.png");
        botonAgregarDiccionario.setIcon(boton);
        boton = new ImageIcon("src\\main\\java\\botones\\agregarDiccionario0.png");
        botonAgregarDiccionario.setRolloverIcon(boton);
        boton = new ImageIcon("src\\main\\java\\botones\\agregarDiccionario2.png");
        botonAgregarDiccionario.setPressedIcon(boton);
        botonAgregarDiccionario.setCursor(new Cursor(HAND_CURSOR));
        
        boton = new ImageIcon("src\\main\\java\\botones\\sustituir1.png");
        buscarReemplazar.setIcon(boton);
        boton = new ImageIcon("src\\main\\java\\botones\\sustituir0.png");
        buscarReemplazar.setRolloverIcon(boton);
        boton = new ImageIcon("src\\main\\java\\botones\\sustituir2.png");
        buscarReemplazar.setPressedIcon(boton);
        buscarReemplazar.setCursor(new Cursor(HAND_CURSOR));
        
        boton = new ImageIcon("src\\main\\java\\botones\\terminar1.png");
        botonTerminar.setIcon(boton);
        boton = new ImageIcon("src\\main\\java\\botones\\terminar0.png");
        botonTerminar.setRolloverIcon(boton);
        boton = new ImageIcon("src\\main\\java\\botones\\terminar2.png");
        botonTerminar.setPressedIcon(boton);
        botonTerminar.setCursor(new Cursor(HAND_CURSOR));
        
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
            java.util.logging.Logger.getLogger(VentanaOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaOpciones dialog = new VentanaOpciones(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton botonAgregarDiccionario;
    private javax.swing.JButton botonIgnorar;
    private javax.swing.JButton botonIgnorarTodo;
    private javax.swing.JButton botonTerminar;
    private javax.swing.JButton buscarReemplazar;
    private javax.swing.JTextPane cuadroTexto;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
