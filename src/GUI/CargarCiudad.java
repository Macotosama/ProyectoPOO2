/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author peperony
 */
public class CargarCiudad extends javax.swing.JPanel {

    /**
     * Creates new form CargarCiudad
     */
    public CargarCiudad() {
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

        jButtonSalir = new javax.swing.JButton();
        jButtonAtrasCargarCiudad = new javax.swing.JButton();
        jButtonCargarElementos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonSalir.setBackground(new java.awt.Color(0, 0, 0));
        jButtonSalir.setFont(new java.awt.Font("Arial Black", 3, 11)); // NOI18N
        jButtonSalir.setForeground(new java.awt.Color(204, 0, 0));
        jButtonSalir.setText("Salir");
        jButtonSalir.setFocusPainted(false);
        add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 700, -1, -1));

        jButtonAtrasCargarCiudad.setBackground(new java.awt.Color(0, 0, 0));
        jButtonAtrasCargarCiudad.setFont(new java.awt.Font("Arial Black", 3, 11)); // NOI18N
        jButtonAtrasCargarCiudad.setForeground(new java.awt.Color(204, 0, 0));
        jButtonAtrasCargarCiudad.setText("Atras");
        jButtonAtrasCargarCiudad.setActionCommand("AtrasCargarCiudad");
        add(jButtonAtrasCargarCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 700, -1, -1));

        jButtonCargarElementos.setBackground(new java.awt.Color(0, 0, 0));
        jButtonCargarElementos.setFont(new java.awt.Font("Arial Black", 3, 48)); // NOI18N
        jButtonCargarElementos.setForeground(new java.awt.Color(204, 0, 0));
        jButtonCargarElementos.setText("Cargar Contenido");
        jButtonCargarElementos.setFocusPainted(false);
        add(jButtonCargarElementos, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 740, 230));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Arial Black", 3, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/CargarCiudad.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonAtrasCargarCiudad;
    public javax.swing.JButton jButtonCargarElementos;
    public javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
