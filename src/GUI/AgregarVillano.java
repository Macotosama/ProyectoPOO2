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
public class AgregarVillano extends javax.swing.JPanel {

    /**
     * Creates new form AgregarVillano
     */
    public AgregarVillano() {
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
        jButtonAtrasAgregarVillano = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListCiudades = new javax.swing.JList<>();
        jLabelCiudades = new javax.swing.JLabel();
        jButtonCiudad = new javax.swing.JButton();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldEdad = new javax.swing.JTextField();
        jTextFieldSexo = new javax.swing.JTextField();
        jTextFieldAltura = new javax.swing.JTextField();
        jTextFieldOrigen = new javax.swing.JTextField();
        jTextFieldOcupacion = new javax.swing.JTextField();
        jTextFieldOrientacionSexual = new javax.swing.JTextField();
        jTextFieldPersonaCercana = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListArchienemigo = new javax.swing.JList<>();
        jLabelEnemigo = new javax.swing.JLabel();
        jButtonArchienemigo = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldDireccion = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldNombreVillano = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonSalir.setBackground(new java.awt.Color(0, 0, 0));
        jButtonSalir.setFont(new java.awt.Font("Arial Black", 3, 11)); // NOI18N
        jButtonSalir.setForeground(new java.awt.Color(204, 0, 0));
        jButtonSalir.setText("Salir");
        jButtonSalir.setFocusPainted(false);
        add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 700, -1, -1));

        jButtonAtrasAgregarVillano.setBackground(new java.awt.Color(0, 0, 0));
        jButtonAtrasAgregarVillano.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jButtonAtrasAgregarVillano.setForeground(new java.awt.Color(204, 0, 0));
        jButtonAtrasAgregarVillano.setText("Atras");
        jButtonAtrasAgregarVillano.setActionCommand("AtrasAgregarVillano");
        jButtonAtrasAgregarVillano.setFocusPainted(false);
        add(jButtonAtrasAgregarVillano, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 700, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Nombre:");
        jLabel2.setOpaque(true);
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 240, 30));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Edad:");
        jLabel3.setOpaque(true);
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 240, 30));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("Sexo:");
        jLabel4.setOpaque(true);
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 240, 30));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("Altura:");
        jLabel5.setToolTipText("");
        jLabel5.setOpaque(true);
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 240, 30));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("Ciudad origen:");
        jLabel6.setToolTipText("");
        jLabel6.setOpaque(true);
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 240, 30));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Ocupación:");
        jLabel7.setOpaque(true);
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 240, 30));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("Orientación sexual:");
        jLabel8.setOpaque(true);
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 240, 30));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 204));
        jLabel9.setText("Persona sercana:");
        jLabel9.setOpaque(true);
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 240, 30));

        jListCiudades.setBackground(new java.awt.Color(0, 0, 0));
        jListCiudades.setFont(new java.awt.Font("Arial Black", 3, 11)); // NOI18N
        jListCiudades.setForeground(new java.awt.Color(204, 0, 0));
        jListCiudades.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListCiudades);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 110, 170));

        jLabelCiudades.setOpaque(true);
        add(jLabelCiudades, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 330, 170));

        jButtonCiudad.setBackground(new java.awt.Color(0, 0, 0));
        jButtonCiudad.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jButtonCiudad.setForeground(new java.awt.Color(204, 0, 0));
        jButtonCiudad.setText("Ciudad");
        jButtonCiudad.setActionCommand("CiudadVillano");
        add(jButtonCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 630, 290, -1));

        jTextFieldNombre.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldNombre.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jTextFieldNombre.setForeground(new java.awt.Color(204, 0, 0));
        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });
        add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 330, -1));

        jTextFieldEdad.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldEdad.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jTextFieldEdad.setForeground(new java.awt.Color(204, 0, 0));
        add(jTextFieldEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 330, -1));

        jTextFieldSexo.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldSexo.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jTextFieldSexo.setForeground(new java.awt.Color(204, 0, 0));
        add(jTextFieldSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 330, -1));

        jTextFieldAltura.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldAltura.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jTextFieldAltura.setForeground(new java.awt.Color(204, 0, 0));
        add(jTextFieldAltura, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 330, -1));

        jTextFieldOrigen.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldOrigen.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jTextFieldOrigen.setForeground(new java.awt.Color(204, 0, 0));
        add(jTextFieldOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 330, -1));

        jTextFieldOcupacion.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldOcupacion.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jTextFieldOcupacion.setForeground(new java.awt.Color(204, 0, 0));
        add(jTextFieldOcupacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, 330, -1));

        jTextFieldOrientacionSexual.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldOrientacionSexual.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jTextFieldOrientacionSexual.setForeground(new java.awt.Color(204, 0, 0));
        add(jTextFieldOrientacionSexual, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 330, -1));

        jTextFieldPersonaCercana.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldPersonaCercana.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jTextFieldPersonaCercana.setForeground(new java.awt.Color(204, 0, 0));
        add(jTextFieldPersonaCercana, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 330, -1));

        jListArchienemigo.setBackground(new java.awt.Color(0, 0, 0));
        jListArchienemigo.setFont(new java.awt.Font("Arial Black", 3, 11)); // NOI18N
        jListArchienemigo.setForeground(new java.awt.Color(204, 0, 0));
        jListArchienemigo.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jListArchienemigo);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 40, 110, 140));

        jLabelEnemigo.setOpaque(true);
        add(jLabelEnemigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 40, 160, 140));

        jButtonArchienemigo.setBackground(new java.awt.Color(0, 0, 0));
        jButtonArchienemigo.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jButtonArchienemigo.setForeground(new java.awt.Color(204, 0, 0));
        jButtonArchienemigo.setText("Archienemigo");
        jButtonArchienemigo.setActionCommand("ArchienemigoVillano");
        add(jButtonArchienemigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 190, 280, -1));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 204));
        jLabel11.setText("Direccion:");
        jLabel11.setOpaque(true);
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 290, 120, -1));

        jTextFieldDireccion.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldDireccion.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jTextFieldDireccion.setForeground(new java.awt.Color(204, 0, 0));
        add(jTextFieldDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 330, 400, -1));

        jButtonBuscar.setBackground(new java.awt.Color(0, 0, 0));
        jButtonBuscar.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jButtonBuscar.setForeground(new java.awt.Color(204, 0, 0));
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.setActionCommand("BuscarVillano");
        add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 380, 220, -1));

        jButtonGuardar.setBackground(new java.awt.Color(0, 0, 0));
        jButtonGuardar.setFont(new java.awt.Font("Arial Black", 3, 36)); // NOI18N
        jButtonGuardar.setForeground(new java.awt.Color(204, 0, 0));
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.setActionCommand("GuardarVillano");
        add(jButtonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 590, 400, -1));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 204));
        jLabel12.setText("Nombre villano:");
        jLabel12.setOpaque(true);
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 430, 180, -1));

        jTextFieldNombreVillano.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldNombreVillano.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jTextFieldNombreVillano.setForeground(new java.awt.Color(204, 0, 0));
        add(jTextFieldNombreVillano, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 470, 390, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/AgregarVillano.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonArchienemigo;
    public javax.swing.JButton jButtonAtrasAgregarVillano;
    public javax.swing.JButton jButtonBuscar;
    public javax.swing.JButton jButtonCiudad;
    public javax.swing.JButton jButtonGuardar;
    public javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JLabel jLabelCiudades;
    public javax.swing.JLabel jLabelEnemigo;
    public javax.swing.JList<String> jListArchienemigo;
    public javax.swing.JList<String> jListCiudades;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextField jTextFieldAltura;
    public javax.swing.JTextField jTextFieldDireccion;
    public javax.swing.JTextField jTextFieldEdad;
    public javax.swing.JTextField jTextFieldNombre;
    public javax.swing.JTextField jTextFieldNombreVillano;
    public javax.swing.JTextField jTextFieldOcupacion;
    public javax.swing.JTextField jTextFieldOrientacionSexual;
    public javax.swing.JTextField jTextFieldOrigen;
    public javax.swing.JTextField jTextFieldPersonaCercana;
    public javax.swing.JTextField jTextFieldSexo;
    // End of variables declaration//GEN-END:variables
}
