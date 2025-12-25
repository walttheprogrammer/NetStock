package aplicacion_1;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author Walter Dario Maza Cuadrado
 * 
 */
    class ThemeConfig {       //configuración predeterminada, no modificar    
    public static final Color DEFAULT_BACKGROUND = new Color(0,153,0);
    public static final Color DEFAULT_TEXT = new Color(204,255,204);        //fondos normales

    public static final Font DEFAULT_FONT = new Font("Arial", Font.PLAIN, 14);

    public static final Color DEFAULT_TABLE_TEXT = new Color(0,102,51);
    public static final Color DEFAULT_TABLE_GRID = new Color(0,204,51);                   // tablas
    public static final Color DEFAULT_TABLE_TEXT_SELECTED = new Color(204,255,204);
    public static final Color DEFAULT_TABLE_BG_SELECTED = new Color(0,204,51);
    public static Color DEFAULT_TABLE_HEADER_BG = new Color(204,255,204);
    public static Color DEFAULT_TABLE_HEADER_TEXT = new Color(0,102,51);
    
    public static Color backgroundColor = DEFAULT_BACKGROUND;
    public static Color textColor = DEFAULT_TEXT;
    public static Font globalFont = DEFAULT_FONT;                  //activando dichos valores

    public static Color tableText = DEFAULT_TABLE_TEXT;
    public static Color tableGrid = DEFAULT_TABLE_GRID;
    public static Color tableTextSelected = DEFAULT_TABLE_TEXT_SELECTED;
    public static Color tableBgSelected = DEFAULT_TABLE_BG_SELECTED;
    

    public static void predeterminado(){  //función que asigna lo predeterminado, sin importar qué
        backgroundColor = DEFAULT_BACKGROUND;
        textColor = DEFAULT_TEXT;
        globalFont = DEFAULT_FONT;
        tableText = DEFAULT_TABLE_TEXT;
        tableGrid = DEFAULT_TABLE_GRID;
        tableTextSelected = DEFAULT_TABLE_TEXT_SELECTED;
        tableBgSelected = DEFAULT_TABLE_BG_SELECTED;
    }
}
    class ThemeManager {
    public static void aplicarTema(Component comp) {
        comp.setFont(ThemeConfig.globalFont);             //colocar la fuente a nivel global
        if(comp instanceof JLabel || comp instanceof JButton || comp instanceof JComboBox || comp instanceof JTextField) {
            comp.setForeground(ThemeConfig.textColor);
            comp.setBackground(ThemeConfig.backgroundColor);
        }
        if(comp instanceof JPanel || comp instanceof JFrame ) {
            comp.setBackground(ThemeConfig.backgroundColor);   //cada instancia se recoge dependiendo del componente
        }
        if(comp instanceof javax.swing.JTable tbl) {
            tbl.setForeground(new Color(0,102,51));
            tbl.setBackground(new Color(204,255,204));
            tbl.setSelectionForeground(new Color(204,255,204));
            tbl.setSelectionBackground(new Color(0,204,51));
            tbl.setGridColor(new Color(0,204,51));
            tbl.setFont(ThemeConfig.globalFont);
            tbl.getTableHeader().setFont(ThemeConfig.globalFont);
        }
        if(comp instanceof Container container) {
            for(Component hijo : container.getComponents()) {
                aplicarTema(hijo);
            }
        }
    }
}
public class Inicio_configuracion extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Inicio_configuracion.class.getName());
    private Inicio_principal princ;
    private static Inicio_1 login_frm;
    /**
     * Creates new form Inicio_configuarcion
     */
        private void cargarFuentes() {        //las fuentes se cargan según los obtenga el sistema
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fuentes = ge.getAvailableFontFamilyNames();
        cmbFuente.setModel(new DefaultComboBoxModel<>(fuentes)); //y se amlacenan en la combobox cmbFuente
}
    public Inicio_configuracion(Inicio_principal jf_pr, Inicio_1 login) {
        initComponents();       //cargamos todas las listas y además las fuentes
        this.inicio = jf_pr;
        this.login_frm = login;
        ThemeManager.aplicarTema(this);  // se carga el tema de donde salgan los datos de este JFrame
        setLocationRelativeTo(null);        // centramos el JFrame
        cmbTamaño.setModel(new DefaultComboBoxModel<>(new String[]{"14","16","18"}));
        cmbEstilo.setModel(new DefaultComboBoxModel<>(new String[]{"Normal","Negrita","Itálica"}));
        cargarFuentes();
    }
    private static Inicio_principal inicio;
    private static Inicio_configuracion instancia;  //esto estará en todo JFrame excepto el principal y el login, para crear únicas instancias
    public static Inicio_configuracion getInstance(Inicio_principal jf_pr) {
         if (instancia == null) {                          // esta función permite obtener una instancia a partir del JFrame principal
            instancia = new Inicio_configuracion(jf_pr, login_frm);              // si no existe ninguna, se crea
        }
        else {                    
        instancia.toFront();                 //en cambio, si ya existe una ventana al menos, se enfoca esta misma al frente
        instancia.requestFocus(); }          // y no se abren más, permitiendo que sea más organizado
         return instancia;
     }
    @Override  //se sobreescribe para que pueda ser posible que solo exista una instancia por más clicks
    public void dispose() {
        super.dispose();
        instancia = null;
    }
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btn_predeterminado = new javax.swing.JButton();
        btn_color_fondo = new javax.swing.JButton();
        btn_color_texto = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        cmbEstilo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmbFuente = new javax.swing.JComboBox<>();
        cmbTamaño = new javax.swing.JComboBox<>();
        lnl_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configuración");
        setAlwaysOnTop(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 153, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Configuración global", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(204, 255, 204))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(204, 255, 204));
        jPanel2.setToolTipText("");
        jPanel2.setFocusCycleRoot(true);
        jPanel2.setFocusTraversalPolicyProvider(true);
        jPanel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.setName(""); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 204));
        jLabel6.setText("Estilo de fuente:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 130, -1));

        btn_predeterminado.setBackground(new java.awt.Color(0, 153, 0));
        btn_predeterminado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_predeterminado.setForeground(new java.awt.Color(204, 255, 204));
        btn_predeterminado.setText("Predeterminado");
        btn_predeterminado.setToolTipText("Volver al tema predeterminado");
        btn_predeterminado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_predeterminadoActionPerformed(evt);
            }
        });
        jPanel2.add(btn_predeterminado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 160, -1));

        btn_color_fondo.setBackground(new java.awt.Color(0, 153, 0));
        btn_color_fondo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_color_fondo.setForeground(new java.awt.Color(204, 255, 204));
        btn_color_fondo.setText("Fondos");
        btn_color_fondo.setToolTipText("Seleccione el color del fondo de todas las ventanas y sus componentes");
        btn_color_fondo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_color_fondoActionPerformed(evt);
            }
        });
        jPanel2.add(btn_color_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 110, -1));

        btn_color_texto.setBackground(new java.awt.Color(0, 153, 0));
        btn_color_texto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_color_texto.setForeground(new java.awt.Color(204, 255, 204));
        btn_color_texto.setText("Texto");
        btn_color_texto.setToolTipText("Seleccione el color del texto en todos los componentes");
        btn_color_texto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_color_textoActionPerformed(evt);
            }
        });
        jPanel2.add(btn_color_texto, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 110, -1));

        btn_agregar.setBackground(new java.awt.Color(0, 153, 0));
        btn_agregar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_agregar.setForeground(new java.awt.Color(204, 255, 204));
        btn_agregar.setText("Aplicar");
        btn_agregar.setToolTipText("Aplicar los cambios");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 110, -1));

        cmbEstilo.setBackground(new java.awt.Color(0, 153, 0));
        cmbEstilo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbEstilo.setForeground(new java.awt.Color(204, 255, 204));
        cmbEstilo.setToolTipText("Seleccione el estilo de la fuente");
        cmbEstilo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstiloActionPerformed(evt);
            }
        });
        jPanel2.add(cmbEstilo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 240, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 204));
        jLabel7.setText("Color de la interfaz:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 32, 130, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 255, 204));
        jLabel8.setText("Fuente:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 130, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 255, 204));
        jLabel9.setText("Tamaño de fuente:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 130, 30));

        cmbFuente.setBackground(new java.awt.Color(0, 153, 0));
        cmbFuente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbFuente.setForeground(new java.awt.Color(204, 255, 204));
        cmbFuente.setToolTipText("Seleccione la fuente");
        cmbFuente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFuenteActionPerformed(evt);
            }
        });
        jPanel2.add(cmbFuente, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 240, 30));

        cmbTamaño.setBackground(new java.awt.Color(0, 153, 0));
        cmbTamaño.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbTamaño.setForeground(new java.awt.Color(204, 255, 204));
        cmbTamaño.setToolTipText("Seleccione el tamaño de la fuente");
        cmbTamaño.setFocusTraversalPolicyProvider(true);
        cmbTamaño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTamañoActionPerformed(evt);
            }
        });
        jPanel2.add(cmbTamaño, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 240, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 430, 270));

        lnl_fondo.setBackground(new java.awt.Color(51, 153, 0));
        lnl_fondo.setForeground(new java.awt.Color(51, 153, 0));
        lnl_fondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lnl_fondo.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        lnl_fondo.setFocusCycleRoot(true);
        lnl_fondo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lnl_fondo.setIconTextGap(2);
        lnl_fondo.setOpaque(true);
        getContentPane().add(lnl_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 300));

        setBounds(0, 0, 464, 299);
    }// </editor-fold>//GEN-END:initComponents
private Color color_ap, color_text_ap;  //colores aplicados
    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
    ThemeConfig.backgroundColor = color_ap != null ? color_ap : ThemeConfig.backgroundColor;          //aplicará el fondo
    ThemeConfig.textColor = color_text_ap != null ? color_text_ap : ThemeConfig.textColor;            //y el color del texto si es que no existen
   //toda esta area aplica a la fuente, incluyendo su tipo, tamaño y estilo  
    String tipo = (String) cmbFuente.getSelectedItem();
    int tamaño = Integer.parseInt((String) cmbTamaño.getSelectedItem());
    int estilo = Font.PLAIN;       
    if(cmbEstilo.getSelectedItem().equals("Negrita")) estilo = Font.BOLD;
    if(cmbEstilo.getSelectedItem().equals("Itálica")) estilo = Font.ITALIC;
    Font f_selecc = new Font(tipo, estilo, tamaño);
    ThemeConfig.globalFont = f_selecc;
    // aplica a si mismo
    ThemeManager.aplicarTema(this);
    // y luego aplica a los otros JFrames
    ThemeManager.aplicarTema(inicio);
    ThemeManager.aplicarTema(JF_Fiados.getInstance(princ));
    ThemeManager.aplicarTema(JF_Precios.getInstance(princ));
    ThemeManager.aplicarTema(JF_Stock.getInstance(princ));
    ThemeManager.aplicarTema(JF_Ventas.getInstance(princ));
    //junto a sus tablas de los JFrames específicos
    bsd_inventario.aplicarRenderer(JF_Fiados.getInstance(princ).tabla());
    bsd_inventario.aplicarRenderer(JF_Ventas.getInstance(princ).tabla());
    bsd_inventario.aplicarRenderer(JF_Stock.getInstance(princ).tabla());

    }//GEN-LAST:event_btn_agregarActionPerformed
    private void btn_color_fondoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_color_fondoActionPerformed
 Color nuevo = JColorChooser.showDialog(this, "Seleccione un color de fondo", ThemeConfig.backgroundColor);
    if(nuevo != null){      //seleccionará el color si es que hay alguno
        color_ap = nuevo;
    }
    }//GEN-LAST:event_btn_color_fondoActionPerformed
    private void btn_color_textoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_color_textoActionPerformed
 Color nuevo = JColorChooser.showDialog(this, "Seleccione un color de fondo", ThemeConfig.backgroundColor);
    if(nuevo != null){      //seleccionará el color si es que hay alguno
        color_text_ap = nuevo;
    }
    }//GEN-LAST:event_btn_color_textoActionPerformed
    private void cmbEstiloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstiloActionPerformed

    }//GEN-LAST:event_cmbEstiloActionPerformed
    private void cmbFuenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFuenteActionPerformed

    }//GEN-LAST:event_cmbFuenteActionPerformed
    private void cmbTamañoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTamañoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTamañoActionPerformed
    private void btn_predeterminadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_predeterminadoActionPerformed
        ThemeConfig.predeterminado();
     //se aplica a si mismo
        ThemeManager.aplicarTema(this);
    // y luego aplica a los otros JFrames
    ThemeManager.aplicarTema(inicio);
    ThemeManager.aplicarTema(JF_Fiados.getInstance(princ));
    ThemeManager.aplicarTema(JF_Precios.getInstance(princ));
    ThemeManager.aplicarTema(JF_Stock.getInstance(princ));
    ThemeManager.aplicarTema(JF_Ventas.getInstance(princ));
        JOptionPane.showMessageDialog(this, "Configuración predeterminada aplicada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btn_predeterminadoActionPerformed
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
        java.awt.EventQueue.invokeLater(() -> new Inicio_configuracion(inicio, login_frm).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_color_fondo;
    private javax.swing.JButton btn_color_texto;
    private javax.swing.JButton btn_predeterminado;
    private javax.swing.JComboBox<String> cmbEstilo;
    private javax.swing.JComboBox<String> cmbFuente;
    private javax.swing.JComboBox<String> cmbTamaño;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lnl_fondo;
    // End of variables declaration//GEN-END:variables
}
