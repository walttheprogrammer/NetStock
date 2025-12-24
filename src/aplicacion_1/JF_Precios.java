package aplicacion_1;
import java.sql.*;  //importamos desde SQL toda nuestra base de datos
import javax.swing.JOptionPane;                 //la base de datos temporal
/**
 *
 * @author Walter Dario Maza Cuadrado
 */
public class JF_Precios extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JF_Precios.class.getName());
    String i; double j;   //variables generales para uso general (xd)
    private static Inicio_principal inicio;
    private static JF_Precios instancia;  //esto estará en todo JFrame excepto el principal y el login, para crear únicas instancias       
    public JF_Precios(Inicio_principal jf_pr) {
        initComponents();        
        this.inicio = jf_pr;
        ThemeManager.aplicarTema(this);  // se carga el tema (vease el JFrame Inicio_configuracion
        setLocationRelativeTo(null);        // centramos el JFrame
        bsd_inventario.carga_productos_TR(cmb_productos);
        cmb_productos.addActionListener(e -> { bsd_inventario.actualizacion_productos_TR(cmb_productos, txtPrecio_anterior);
        });
    }
        public static JF_Precios getInstance(Inicio_principal jf_pr) {
         if (instancia == null) {                      // esta función permite obtener una instancia a partir del JFrame principal
            instancia = new JF_Precios(jf_pr);         // si no existe ninguna, se crea
        }
        else {
        instancia.toFront();                       //en cambio, si ya existe una ventana al menos, se enfoca esta misma al frente
        instancia.requestFocus(); }                // y no se abren más, permitiendo que sea más organizado
         return instancia; 
     }
    @Override  //se sobreescribe para que pueda ser posible que solo exista una instancia por más clicks
    public void dispose() {
        super.dispose();
        instancia = null;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtProducto_nuevo = new javax.swing.JTextField();
        btn_agregar = new javax.swing.JButton();
        txtPrecio_nuuevo = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPrecio_anterior = new javax.swing.JTextField();
        btn_borrar_prd = new javax.swing.JButton();
        cmb_productos = new javax.swing.JComboBox<>();
        btn_cambiar_prd = new javax.swing.JButton();
        lnl_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Módulo de precios y productos - Bodega El Olivar");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(51, 153, 0));
        setPreferredSize(new java.awt.Dimension(650, 350));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 153, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Agregar un producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(204, 255, 204))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(204, 255, 204));
        jPanel2.setToolTipText("");
        jPanel2.setFocusable(false);
        jPanel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.setName(""); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 204));
        jLabel4.setText("Precio:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 70, 80, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 204));
        jLabel6.setText("Producto:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 32, 70, -1));

        txtProducto_nuevo.setBackground(new java.awt.Color(204, 255, 204));
        txtProducto_nuevo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtProducto_nuevo.setForeground(new java.awt.Color(0, 102, 51));
        txtProducto_nuevo.setToolTipText("");
        txtProducto_nuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(txtProducto_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 500, -1));

        btn_agregar.setBackground(new java.awt.Color(0, 153, 0));
        btn_agregar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_agregar.setForeground(new java.awt.Color(204, 255, 204));
        btn_agregar.setText("Agregar");
        btn_agregar.setToolTipText("");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 110, -1));

        txtPrecio_nuuevo.setBackground(new java.awt.Color(204, 255, 204));
        txtPrecio_nuuevo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPrecio_nuuevo.setForeground(new java.awt.Color(0, 102, 51));
        txtPrecio_nuuevo.setToolTipText("");
        txtPrecio_nuuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(txtPrecio_nuuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 130, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 620, 110));

        jPanel1.setBackground(new java.awt.Color(51, 153, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del producto seleccionado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(204, 255, 204))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(204, 255, 204));
        jPanel1.setToolTipText("");
        jPanel1.setFocusable(false);
        jPanel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 204));
        jLabel1.setText("Precio:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 80, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 204));
        jLabel2.setText("Producto:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 70, -1));

        txtPrecio_anterior.setBackground(new java.awt.Color(204, 255, 204));
        txtPrecio_anterior.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPrecio_anterior.setForeground(new java.awt.Color(0, 102, 51));
        txtPrecio_anterior.setToolTipText("");
        txtPrecio_anterior.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPrecio_anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecio_anteriorActionPerformed(evt);
            }
        });
        jPanel1.add(txtPrecio_anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 130, -1));

        btn_borrar_prd.setBackground(new java.awt.Color(0, 153, 0));
        btn_borrar_prd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_borrar_prd.setForeground(new java.awt.Color(204, 255, 204));
        btn_borrar_prd.setText("Eliminar");
        btn_borrar_prd.setToolTipText("");
        btn_borrar_prd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrar_prdActionPerformed(evt);
            }
        });
        jPanel1.add(btn_borrar_prd, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 110, -1));

        cmb_productos.setBackground(new java.awt.Color(0, 153, 0));
        cmb_productos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmb_productos.setForeground(new java.awt.Color(204, 255, 204));
        cmb_productos.setToolTipText("");
        cmb_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_productosActionPerformed(evt);
            }
        });
        jPanel1.add(cmb_productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 510, 30));

        btn_cambiar_prd.setBackground(new java.awt.Color(0, 153, 0));
        btn_cambiar_prd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_cambiar_prd.setForeground(new java.awt.Color(204, 255, 204));
        btn_cambiar_prd.setText("Cambiar");
        btn_cambiar_prd.setToolTipText("");
        btn_cambiar_prd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cambiar_prdActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cambiar_prd, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 110, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 620, 110));

        lnl_fondo.setBackground(new java.awt.Color(51, 153, 0));
        lnl_fondo.setForeground(new java.awt.Color(51, 153, 0));
        lnl_fondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lnl_fondo.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        lnl_fondo.setFocusCycleRoot(true);
        lnl_fondo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lnl_fondo.setIconTextGap(2);
        lnl_fondo.setOpaque(true);
        getContentPane().add(lnl_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 260));

        setSize(new java.awt.Dimension(664, 292));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void btn_borrar_prdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrar_prdActionPerformed
    i = (String) cmb_productos.getSelectedItem();
    j = (Double) Double.parseDouble(txtPrecio_anterior.getText());
        if (i == null) {
        JOptionPane.showMessageDialog(this, "No hay ningún producto seleccionado a borrar.");
        return;  //s  i es que se intenta borrar un producto no seleccionado
    }             //y se detiene si es que se cumple la condición (return)
        bsd_inventario.eliminarProducto(cmb_productos, i);
        cmb_productos.removeItem(i);    //y luego del combobox
        JOptionPane.showMessageDialog(this, "Producto eliminado correctamente.");
        txtPrecio_anterior.setText("");
    }//GEN-LAST:event_btn_borrar_prdActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
    if (txtPrecio_nuuevo.getText().isEmpty()|| txtProducto_nuevo.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Campos vacíos. Por favor, ingrese \nlos datos del nuevo producto.");
        return; }       // usamos el this como contenedor, y el return para detener la operación          
    double precio;  
    try {
        precio = Double.parseDouble(txtPrecio_nuuevo.getText());
    } catch (NumberFormatException e) {  //lanza una excepción si es que usó texto y no números
        JOptionPane.showMessageDialog(this, "Precio inválido. Digite el valor del producto.");
        return;
    }    //estas dos opciones en la parte superior solamente son excepciones, el resto si o si se aplica (agregar/modificar/eliminar)
    
    String prod = txtProducto_nuevo.getText();      //esta es la primera instancia de donde se saca el precio
    double n_precio = Double.parseDouble(txtPrecio_nuuevo.getText());   // desde las cajas de texto
    bsd_inventario.agregarProducto(cmb_productos, prod, n_precio);
    bsd_inventario.carga_productos_TR(cmb_productos);  // y los cargamos aquí, para actualizar a tiempo real el JComboBox
    
    JOptionPane.showMessageDialog(this, "Producto agregado correctamente.");
    txtProducto_nuevo.setText("");  //se vacían para evitar errores
    txtPrecio_nuuevo.setText("");
    }//GEN-LAST:event_btn_agregarActionPerformed
    private void btn_cambiar_prdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cambiar_prdActionPerformed
    String pr_nuevo = txtPrecio_anterior.getText().trim();  //obtención del nuevo precio
    i = (String) cmb_productos.getSelectedItem();
    
    if (i == null || pr_nuevo.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor seleccione un producto y escriba un precio.");
        return; }    // por si el usuario no selecciona nada
    double n_precio;
    try {
        n_precio = Double.parseDouble(pr_nuevo);
    } catch (NumberFormatException e) {     // por si escribió mal, de nuevo, el precio
        JOptionPane.showMessageDialog(this, "Precio inválido. Digite el valor del producto.");
        return; }
    
    String producto = (String) cmb_productos.getSelectedItem();  //actualizamos item
    bsd_inventario.cambiarPrecio(producto, n_precio);    //y cambiamos su precio correspondiente (SQL)
    
    JOptionPane.showMessageDialog(this, "Precio actualizado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    cmb_productos.repaint();    //refrescamos el JComboBox
    cmb_productos.revalidate();
    }//GEN-LAST:event_btn_cambiar_prdActionPerformed

    private void cmb_productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_productosActionPerformed
       bsd_inventario.actualizacion_productos_TR(cmb_productos, txtPrecio_anterior); //usamos el mismo procedimiento para cuando se seleccione en el JComboBox
    }//GEN-LAST:event_cmb_productosActionPerformed
    private void txtPrecio_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecio_anteriorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecio_anteriorActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new JF_Precios(inicio).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_borrar_prd;
    private javax.swing.JButton btn_cambiar_prd;
    private javax.swing.JComboBox<String> cmb_productos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lnl_fondo;
    private javax.swing.JTextField txtPrecio_anterior;
    private javax.swing.JTextField txtPrecio_nuuevo;
    private javax.swing.JTextField txtProducto_nuevo;
    // End of variables declaration//GEN-END:variables
}
