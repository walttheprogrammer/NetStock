package aplicacion_1;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author Walter Dario Maza Cuadrado
 */
public class Inicio_principal extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Inicio_principal.class.getName());
    /**
     * Creates new form Inicio_principal
     */
    public Inicio_principal() {
        initComponents();
        ThemeManager.aplicarTema(this);  // se carga el tema (vease el JFrame Inicio_configuracion
        setLocationRelativeTo(null);        // centramos el JFrame
        javax.swing.Timer contador = new javax.swing.Timer(1,e -> {
            Date hoy = new java.util.Date();           //hora y fechas, ambos se obtienen del sistema y luego se representan 
            java.text.SimpleDateFormat formatoHora = new java.text.SimpleDateFormat("HH:mm:ss");       //en dos labels
            java.text.SimpleDateFormat formatoFecha = new java.text.SimpleDateFormat("dd/MM/yyyy");
            lbl_hora.setText(formatoHora.format(hoy));
            lbl_fecha.setText(formatoFecha.format(hoy));
        }); //agrega un timer, para empezar a contar desde el momento del día actual
        contador.start();   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_ventas = new javax.swing.JButton();
        btn_precios = new javax.swing.JButton();
        btn_config = new javax.swing.JButton();
        btn_cerrar = new javax.swing.JButton();
        btn_stock = new javax.swing.JButton();
        btn_fiados = new javax.swing.JButton();
        lbl_hora = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_fecha = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lnl_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Bodega El Olivar - Inicio");
        setBackground(java.awt.SystemColor.activeCaption);
        setFocusTraversalPolicyProvider(true);
        setResizable(false);
        setSize(new java.awt.Dimension(583, 91));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_ventas.setBackground(new java.awt.Color(0, 153, 0));
        btn_ventas.setForeground(new java.awt.Color(204, 255, 204));
        btn_ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplicacion_1/icons/sales-icon.png"))); // NOI18N
        btn_ventas.setText("Ventas");
        btn_ventas.setToolTipText("");
        btn_ventas.setActionCommand("");
        btn_ventas.setFocusPainted(false);
        btn_ventas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_ventas.setIconTextGap(5);
        btn_ventas.setMargin(new java.awt.Insets(1, 14, 3, 14));
        btn_ventas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ventasActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -3, 130, 110));

        btn_precios.setBackground(new java.awt.Color(0, 153, 0));
        btn_precios.setForeground(new java.awt.Color(204, 255, 204));
        btn_precios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplicacion_1/icons/reports-icon.png"))); // NOI18N
        btn_precios.setText("Precios");
        btn_precios.setToolTipText("");
        btn_precios.setActionCommand("");
        btn_precios.setFocusPainted(false);
        btn_precios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_precios.setIconTextGap(5);
        btn_precios.setMargin(new java.awt.Insets(1, 14, 3, 14));
        btn_precios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_precios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_preciosActionPerformed(evt);
            }
        });
        getContentPane().add(btn_precios, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, -3, 120, 110));

        btn_config.setBackground(new java.awt.Color(0, 153, 0));
        btn_config.setForeground(new java.awt.Color(204, 255, 204));
        btn_config.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplicacion_1/icons/configuration-icon.png"))); // NOI18N
        btn_config.setText("Configuración"); // NOI18N
        btn_config.setToolTipText("");
        btn_config.setActionCommand("");
        btn_config.setFocusPainted(false);
        btn_config.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_config.setIconTextGap(5);
        btn_config.setMargin(new java.awt.Insets(1, 14, 3, 14));
        btn_config.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_config.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_configActionPerformed(evt);
            }
        });
        getContentPane().add(btn_config, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, -3, 170, 110));

        btn_cerrar.setBackground(new java.awt.Color(0, 153, 0));
        btn_cerrar.setForeground(new java.awt.Color(204, 255, 204));
        btn_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplicacion_1/icons/logout-icon.png"))); // NOI18N
        btn_cerrar.setToolTipText("");
        btn_cerrar.setFocusPainted(false);
        btn_cerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_cerrar.setIconTextGap(5);
        btn_cerrar.setLabel("Cerrar sesión");
        btn_cerrar.setMargin(new java.awt.Insets(1, 14, 3, 14));
        btn_cerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, -3, 160, 110));

        btn_stock.setBackground(new java.awt.Color(0, 153, 0));
        btn_stock.setForeground(new java.awt.Color(204, 255, 204));
        btn_stock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplicacion_1/icons/inventory-icon.png"))); // NOI18N
        btn_stock.setText("Stock"); // NOI18N
        btn_stock.setToolTipText("");
        btn_stock.setActionCommand("");
        btn_stock.setFocusPainted(false);
        btn_stock.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_stock.setIconTextGap(5);
        btn_stock.setMargin(new java.awt.Insets(1, 14, 3, 14));
        btn_stock.setRequestFocusEnabled(false);
        btn_stock.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_stockActionPerformed(evt);
            }
        });
        getContentPane().add(btn_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, -3, 130, 110));

        btn_fiados.setBackground(new java.awt.Color(0, 153, 0));
        btn_fiados.setForeground(new java.awt.Color(204, 255, 204));
        btn_fiados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplicacion_1/icons/client-icon.png"))); // NOI18N
        btn_fiados.setText("Fiados");
        btn_fiados.setToolTipText("");
        btn_fiados.setActionCommand("");
        btn_fiados.setFocusPainted(false);
        btn_fiados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_fiados.setIconTextGap(5);
        btn_fiados.setMargin(new java.awt.Insets(1, 14, 3, 14));
        btn_fiados.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_fiados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fiadosActionPerformed(evt);
            }
        });
        getContentPane().add(btn_fiados, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, -3, 130, 110));

        lbl_hora.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_hora.setForeground(new java.awt.Color(0, 102, 0));
        lbl_hora.setText("jLabel2");
        lbl_hora.setToolTipText("");
        lbl_hora.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbl_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 445, -1, -1));

        jLabel5.setBackground(new java.awt.Color(102, 255, 102));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setLabelFor(this);
        jLabel5.setText("<html><div style='text-align: center;'>El Olivar S.A.C.<br>Todos los derechos reservados</div></html>");
        jLabel5.setToolTipText("");
        jLabel5.setAutoscrolls(true);
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, -1, 60));

        jLabel1.setBackground(new java.awt.Color(102, 255, 102));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setLabelFor(this);
        jLabel1.setText("<html><div style='text-align: center;'>Ubicación: Av. Naranjal Cdr. 6521,<br>Urb. Villa del Norte, Los Olivos.</div></html>");
        jLabel1.setToolTipText("");
        jLabel1.setAutoscrolls(true);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 310, 60));

        jLabel3.setBackground(new java.awt.Color(102, 255, 102));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setLabelFor(this);
        jLabel3.setText("<html><div style='text-align: center;'>¡Bienvenido a la bodega El Olivar! <br>Para iniciar una operación, escoja uno de los botones ubicados en el menú.</div></html>");
        jLabel3.setToolTipText("");
        jLabel3.setAutoscrolls(true);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 760, 100));

        lbl_fecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_fecha.setForeground(new java.awt.Color(0, 102, 0));
        lbl_fecha.setText("jLabel3");
        lbl_fecha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbl_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 470, -1, -1));

        jLabel2.setBackground(new java.awt.Color(102, 255, 102));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 430, 830, 90));

        lnl_fondo.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        lnl_fondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lnl_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplicacion_1/pictures/bodega El Olivar.png"))); // NOI18N
        lnl_fondo.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        lnl_fondo.setFocusCycleRoot(true);
        lnl_fondo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lnl_fondo.setIconTextGap(2);
        getContentPane().add(lnl_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 90, 770, 420));

        setSize(new java.awt.Dimension(775, 544));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   Inicio_configuracion config =  Inicio_configuracion.getInstance(this);  //la ventana de configuración es muy impo
    private void btn_configActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_configActionPerformed
        config.setSize(465, 325);
        config.setVisible(true);
    }//GEN-LAST:event_btn_configActionPerformed
    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas cerrar sesión?", 
                "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
            System.out.println("Cerrando sesión...");
            System.out.println("Sesión finalizada...");
            Inicio_1.getInstance(config).setSize(420, 230); //si es "si" la opción, se devuelve a la ventana del login
            Inicio_1.getInstance(config).setVisible(true);
            JF_Stock.getInstance(this).dispose();
            JF_Fiados.getInstance(this).dispose();   //y se cierra todo lo que esté abierto
            JF_Ventas.getInstance(this).dispose();
            JF_Precios.getInstance(this).dispose();
            config.dispose();
            dispose();   
        } //Se utiliza para cerrar por completo la aplicación        
    }//GEN-LAST:event_btn_cerrarActionPerformed
    private void btn_stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_stockActionPerformed
       //le indicamos que el nuevo form será establecido con un tamaño para que exista
        JF_Stock.getInstance(this).setSize(890, 480);
        JF_Stock.getInstance(this).setVisible(true);
    }//GEN-LAST:event_btn_stockActionPerformed
    private void btn_preciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_preciosActionPerformed
        JF_Precios.getInstance(this).setSize(665, 298);      //le indicamos que el nuevo form será establecido con un tamaño para que exista
        JF_Precios.getInstance(this).setVisible(true);
    }//GEN-LAST:event_btn_preciosActionPerformed
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    int opcion = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas salir de la aplicación? "
            + "\n Su cuenta seguirá activa.", "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (opcion == JOptionPane.YES_OPTION) {
        System.exit(0); //Se utiliza para cerrar por completo la aplicación
    }
    }//GEN-LAST:event_formWindowClosing
    private void btn_fiadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fiadosActionPerformed
        JF_Fiados.getInstance(this).setSize(905, 475); //le indicamos que el nuevo form será establecido con un tamaño para que exista
        JF_Fiados.getInstance(this).setVisible(true); // y que se vea
    }//GEN-LAST:event_btn_fiadosActionPerformed
    private void btn_ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ventasActionPerformed
        JF_Ventas.getInstance(this).setSize(655, 560);
        JF_Ventas.getInstance(this).setVisible(true);
    }//GEN-LAST:event_btn_ventasActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */     
        java.awt.EventQueue.invokeLater(() -> new Inicio_principal().setVisible(true));
                }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton btn_config;
    private javax.swing.JButton btn_fiados;
    private javax.swing.JButton btn_precios;
    private javax.swing.JButton btn_stock;
    private javax.swing.JButton btn_ventas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbl_fecha;
    private javax.swing.JLabel lbl_hora;
    private javax.swing.JLabel lnl_fondo;
    // End of variables declaration//GEN-END:variables
}