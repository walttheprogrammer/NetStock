package aplicacion_1;
import java.awt.Component;
import java.util.ArrayList;      //listas que usarán cada uno                                       
import java.util.Arrays;
import java.util.List;
import javax.swing.JComboBox;   // los diversos componentes son importados
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.sql.*;   // implementación a SQL; este paso es importante para poder almacenarlo en una base de datos
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
public class bsd_inventario {
    public static List<Object> fiados = new ArrayList<>(Arrays.asList());
    public static List<String> DATA_PRODUCTOS_INIT = new ArrayList<>(Arrays.asList(
               "Arroz Extra FARAÓN Bolsa 5kg", "Arroz Extra PACASMAYO Bolsa 5 kg", "Arroz Extra COSTEÑO Bolsa 5kg",
               "Arroz Extra PAISANA Bolsa 5kg", "Arroz Extra BELL'S Bolsa 2kg", "Azúcar Rubia BELL'S Bolsa 5Kg",
               "Azúcar Rubia DULFINA Bolsa 5Kg", "Azúcar Rubia DULFINA Bolsa 2Kg", "Aceite Vegetal Clásico PRIMOR Botella 900ml",
               "Aceite Vegetal Premium PRIMOR Botella 900ml","Aceite Vegetal COCINERO Botella 900ml","Aceite Vegetal BELL'S Botella 900ml",
               "Lenteja Bebé BELL'S Bolsa 500g", "Lentejas BELL'S Bolsa 500g","Frijol Canario BELL'S Bolsa 500g",
               "Arverja Partida BELL'S Bolsa 500g", "Garbanzos BELL'S Bolsa 500g","Maíz Pop Corn COSTEÑO Bolsa 500g", "Lenteja Bebé COSTEÑO Bolsa 500g",
               "Lentejas COSTEÑO Bolsa 500g", "Frijol Canario COSTEÑO Bolsa 500g", "Arverja Partida COSTEÑO Bolsa 500g",
               "Garbanzos COSTEÑO Bolsa 500g", "Queso Edam LAIVE 440g", "Queso Edam LAIVE Sin Lactosa 180g",
               "Queso Fresco LAIVE 1kg", "Queso Cheddar PRESIDENT 200g"
       ));// todo este bloque es para la administración de los productos y sus precios; también para los que agreguen/modifiquen/eliminen
   public static List<Double> DATA_PRECIOS_INIT = new ArrayList<>(Arrays.asList(
        18.50, 19.00, 17.80, 18.20, 8.90,
        15.50, 14.90, 6.50, 10.00, 12.50,
        11.30, 9.80, 4.20, 3.90, 6.80,    // 27 precios para los 27 productos iniciales
        4.50, 7.20, 5.10, 4.40, 4.10,
        7.00, 4.60, 7.40, 22.00, 12.50,
        19.00, 16.50
       ));
   public static List<Integer> DATA_STOCK_INIT = new ArrayList<>(Arrays.asList(
    15, 20, 25, 40, 24, 12, 25, 12, 27, 15, 26, 45, 75, 23, 32, 41, 22, 19, 30, 31, 26, 21, 18, 29, 31, 36, 41 // stock por producto (27 en total)
));
   public static void inicializar_sql(){
        System.out.println("Copyright (c) Waltz Systems. Bienvenido al sistema NetStock!");
        Connection testCon = conectar_bsd(); //conexión
        if (testCon != null) {
            System.out.println("Servidor detectado. Cargando base de datos...");
            try { testCon.close(); } catch (Exception e) {} 
            load_sql(); // si está vacio, verifica y llena
            upload_sql();   // y se llena desde la base de datos local
            bsd_usuarios.check(); //verificamos también los usuarios en las tablas de la base da datos
        } else {
            System.out.println("No se pudo detectar la base de datos.");
            System.out.println("Cargando datos en la memoria RAM...");
        }
    }
   private static Connection conectar_bsd() { //función necesaria para conectar con SQL Server
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=NetStockDB;integratedSecurity=true;encrypt=true;trustServerCertificate=true;loginTimeout=2;";
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            return null; //en casos excepcionales, si no existe SQL o algún DLL que lo impide ejecutarse, se devuelve a los datos de la RAM.
        }
    }
   public static int stock_minimo(String producto) {  //valor entero que calcula los mínimos del stock
    if (producto.contains("Arroz") || producto.contains("Azúcar") || producto.contains("Aceite")) {
        return 10;
    } else if (producto.contains("Lenteja") || producto.contains("Frijol") || producto.contains("Arverja") 
            || producto.contains("Garbanzo") || producto.contains("Maiz")) {
        return 8; } 
    else { return 5; } }
   public static int stock_ok(String producto) {  //valor entero que calcula los valores promedios del stock
       if (producto.contains("Arroz") || producto.contains("Azúcar") || producto.contains("Aceite")) {
        return 20;
       } else if (producto.contains("Lenteja") || producto.contains("Frijol") || producto.contains("Arverja") 
               || producto.contains("Garbanzo") || producto.contains("Maiz")) {
        return 15; } 
       else { return 10;} }   
   public static String indicador_stock(String producto, int cantidad) {
    int minimo = stock_minimo(producto); //desde el producto calculamos los intervalos
    int ok = stock_ok(producto);
    if (cantidad <= minimo) {   //si es menos del minimo, hay bajo stock
        return "Baja";
    } else if (cantidad <= ok) {   //si es menos de lo normal, es aceptable
        return "Aceptable";
    } else {                  // en cambio, si es mayor, entonces es óptima
        return "Óptima";
    } }
    public static void upload_stock_sql (DefaultTableModel modelo, String producto, int c_stock, String fecha) {
        boolean en_sql = false;
        try (Connection con = bsd_usuarios.conexion()) { // Asegúrate de tener los imports de java.sql
            if (con != null) {
                String sql = "UPDATE Productos SET Stock = ? WHERE Nombre = ?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, c_stock);
                pst.setString(2, producto);
                int filas_sql = pst.executeUpdate();
                if (filas_sql > 0) System.out.println("Producto" + producto + "actualizado, con stock " + c_stock + ".");
                else System.out.println("El producto " + producto + "no pudo actualizar su stock. Error de sincronización.");
                en_sql = true;
                System.out.println("Stock subido correctamente.");
            }
        } catch (Throwable e) {
            System.out.println("Error de sincronización con SQL: " + e.getMessage());
        }  
    }
    public static void agregarProducto(JComboBox combobox, String p, Double precio) {
     try (Connection con = conectar_bsd()) {
            if (con != null) {  //se insertarán los 3 datos con esta instrucción
                String sql = "INSERT INTO Productos (Nombre, Precio, Stock) VALUES (?, ?, ?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, p);
                pst.setDouble(2, precio);  //indicamos el orden de la columna y luego el valor a agregar
                pst.setInt(3, 0);  //* el producto es nuevo, por tanto tiene 0 hasta configuración manual 
                pst.executeUpdate();  //actualizamos, segun el statement pst
            }
        } catch (SQLException e) { } //no pasa nada si hay error
        combobox.addItem(p);
    }
    public static void eliminarProducto(JComboBox combobox, String p) {
        try (Connection con = conectar_bsd()) {
            if (con != null) {
                String sql = "DELETE FROM Productos WHERE Nombre = ?"; 
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, p);   //similar al procedimiento agregarProducto, pero se remueve en vez de agregar
                int filas_sql = pst.executeUpdate();  //actualizamos, segun el statement pst
                if (filas_sql > 0) {
                    System.out.println("Producto " + p + " eliminado correctamente.");
                } else {
                    System.out.println("El producto no existe en la base de datos.");
                    System.out.println("Los cambios solo existen en la RAM.");
                }
            }
        } catch (SQLException e) { System.out.println("Error al eliminar un producto."); } //mensaje de sistema
        combobox.removeItem(p);
    }
    public static void modificarProducto(String p, double n_precio, int n_stock) {
        boolean en_sql = false;
        try (Connection con = bsd_usuarios.conexion()) {
            if (con != null) {
                String sql = "UPDATE Productos SET Precio = ?, Stock = ? WHERE Nombre = ?";                
                PreparedStatement pst = con.prepareStatement(sql);                
                pst.setDouble(1, n_precio);   //con ello actualizamos las el nombre del producto anterior a su nuevo nombre para SQL
                pst.setInt(2, n_stock);                
                pst.setString(3, p);                
                int aff_filas = pst.executeUpdate();                
                if (aff_filas > 0) {
                    System.out.println("Producto " + p + "modificado.");
                    en_sql = true;
                } else {
                    System.out.println("No se encontró el producto en SQL.");
                }
            }
        } catch (Throwable e) {
            System.out.println("No se puede actualizar la base de datos. Error: " + e.getMessage());
        }
    } 

    public static synchronized void actualizacion_productos_TR(JComboBox cmb, JTextField txtPrecio) {
        String Prod = (String) cmb.getSelectedItem();
        if (Prod == null || Prod.isEmpty()) return;
        String prod_clear = Prod;
        if (Prod.contains("(")) {
            prod_clear = Prod.split("\\(")[0].trim();
        } else {
            prod_clear = Prod.trim();
        }
        double en_precio = 0.0;
        boolean en_sql = false;
        try (Connection con = bsd_usuarios.conexion()) {
            if (con != null) {   //ahora buscamos el precio
                String sql = "SELECT Precio FROM Productos WHERE Nombre = ? ORDER BY Nombre ASC";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, Prod);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    en_precio = rs.getDouble("Precio");
                    en_sql = true;
                }
            }
        } catch (Exception e) {  //y si no lo encuentra, devuelve un mensaje de sistema
            System.out.println("Error de sincronización con SQL: " + e.getMessage());
        } 
        if (!en_sql) {
            en_precio = bsd_inventario.obtenerPrecio(Prod);
        }
        String precio_str = String.valueOf(en_precio);
        txtPrecio.setText(precio_str);
   }   
    public static synchronized void carga_productos_TR(JComboBox cmbbox) {
        cmbbox.removeAllItems(); //limpiamos la JComboBox
        boolean en_sql = false;     //primero será falso porque no usamos SQL aún
        try (Connection con = bsd_usuarios.conexion()) { 
            if (con != null) {
                String sql = "SELECT Nombre, Precio FROM Productos ORDER BY Nombre ASC" ; // Pedimos nombre y precio
                PreparedStatement pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    String nombre = rs.getString("Nombre");
                    double precio = rs.getDouble("Precio");
                    cmbbox.addItem(nombre);  //y se agrega el precio del producto al JComboBox
                }
                en_sql = true; 
                System.out.println("Datos cargados.");
            }
        } catch (Exception e) {
            System.out.println("No se pudo cargar los datos. Base de datos no encontrada" + e.getMessage());
        }
    }
    public static double obtenerPrecio(String producto) {
        double precio = 0.0;
        try (Connection con = conectar_bsd()) {
            if (con != null) {
                String sql = "SELECT FROM Productos WHERE Nombre = ? "; 
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, producto);   //se obtiene el precio del producto
                ResultSet rs = pst.executeQuery();
                if (rs.next()) { precio = rs.getDouble("Precio"); } //y lo buscamos en la base de datos
            }
        } catch (SQLException e) { } //no pasa nada si hay error
        return precio;
    }
    public static void cambiarPrecio(String producto, double nuevoPrecio) {
        try (Connection con = conectar_bsd()) {
            if (con != null) {
                String sql = "UPDATE Productos SET Precio = ? WHERE Nombre = ?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setDouble(1, nuevoPrecio);
                pst.setString(2, producto);
                pst.executeUpdate();
            }
        } catch (SQLException e) { }
    }
    public static boolean agregarFiado(String cliente, String producto, Double monto, String fecha) {
        try (Connection con = conectar_bsd()) {
            if (con != null) {
                String sql = "INSERT INTO Fiados (Cliente, Producto, Monto, Fecha) VALUES (?, ?, ?, ?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, cliente);
                pst.setString(2, producto);
                pst.setDouble(3, monto);  //utliizamos los 3 valores, del cliente, el producto y el monto
                pst.setString(4, fecha);
                int id_fiado_sql = pst.executeUpdate();
                if (id_fiado_sql > 0) {
                    System.out.println("El cliente " + cliente + " ha sido agregado a la lista de fiados de forma correcta."); return true;}      
            }
        } catch (SQLException e) { }
        return false;
    }
    public static void eliminarFiado(int id, String cliente) {
        try (Connection con = conectar_bsd()) {
            if (con != null) {
                String sql = "DELETE FROM Fiados WHERE ID = ?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, id);
                int id_fiado_sql = pst.executeUpdate();  //actualizamos, segun el statement pst
                if (id_fiado_sql > 0) {
                    System.out.println("El cliente " + cliente + " con ID " + id + "ha sido eliminado de la lista de fiados de forma correcta."); }            }
        } catch (SQLException e) { } 
    }
    public static DefaultTableModel load_fiados_sql(DefaultTableModel modelo) { 
        try (Connection con = conectar_bsd()) {
            if (con != null) {
            String sql = "SELECT ID, Cliente, Producto, Monto, Fecha FROM Fiados ORDER BY ID ASC";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int contador = 1;
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    contador,
                    rs.getString("Cliente"), 
                    rs.getString("Producto"), 
                    rs.getDouble("Monto"),
                    rs.getString("Fecha")
                });
                contador++;
            }
            }
        } catch (SQLException e) { }
        return modelo;
    }
    public static void load_sql() {
        try (Connection con = conectar_bsd()) {
            if (con == null) return;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM Productos");
            rs.next();
            int n_datos = rs.getInt(1);
            if (n_datos == 0) {
                System.out.println("Cargando productos predeterminados...");                
                String sql = "INSERT INTO Productos (Nombre, Precio, Stock) VALUES (?, ?, ?)";
                PreparedStatement pst = con.prepareStatement(sql);
                for (int i = 0; i < DATA_PRODUCTOS_INIT.size(); i++) {  //agregamos las listas predeterminadas
                    pst.setString(1, DATA_PRODUCTOS_INIT.get(i));
                    pst.setDouble(2, DATA_PRECIOS_INIT.get(i));
                    pst.setInt(3, DATA_STOCK_INIT.get(i));
                    pst.addBatch(); // Los preparamos en un paquete
                }
                pst.executeBatch(); // ¡PUM! Guardamos los 27 productos de golpe
                System.out.println("Configuración predeterminada cargada a SQL.");
            } else {
                System.out.println("Se encontraron " + n_datos + " productos. " + "Importando datos...");
            }
        } catch (SQLException ex) { 
            System.err.println("Error en load_sql(): " + ex.getMessage());
        } 
    }
    private static void upload_sql() {
        try (Connection con = conectar_bsd()) {
            if (con == null) return;
            Statement st = con.createStatement();
            try {
                ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM Productos");
                rs.next();  //se selecciona el conteo actual
                if (rs.getInt(1) == 0) throw new Exception("Vacio");
            } catch (Exception e) {
                System.out.println("Creando NetStockDB.mdb...");
                String sql = "INSERT INTO Productos (Nombre, Precio, Stock) VALUES (?, ?, ?)";
                PreparedStatement pst = con.prepareStatement(sql);
                for (int i = 0; i < DATA_PRODUCTOS_INIT.size(); i++) {
                    pst.setString(1, DATA_PRODUCTOS_INIT.get(i));
                    pst.setDouble(2, DATA_PRECIOS_INIT.get(i));
                    pst.setInt(3, DATA_STOCK_INIT.get(i));
                    pst.addBatch();  //se agregan los parametros de este statement
                }
                pst.executeBatch();  //y los mismos se ejecutan
            }
        } catch (SQLException ex) { }
    }
    public static void aplicarRenderer(JTable tabla) {
        tabla.setGridColor(ThemeConfig.textColor);
        tabla.setFont(ThemeConfig.globalFont);     // Fuente y color globales
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override            //configuración que renderiza las celdas
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);
            // aplicar fuente
            c.setFont(ThemeConfig.globalFont);
            // colores
            if (isSelected) {
                c.setBackground(ThemeConfig.textColor);      // invertido
                c.setForeground(ThemeConfig.backgroundColor);
            } else {
                c.setBackground(ThemeConfig.backgroundColor);
                c.setForeground(ThemeConfig.textColor);
            }
            if (c instanceof JComponent) {
                ((JComponent) c).setOpaque(true);
            }  // opacidad
            return c; }   };
    tabla.setDefaultRenderer(Object.class, cellRenderer);
    tabla.getParent().setBackground(ThemeConfig.backgroundColor);  }  
}
