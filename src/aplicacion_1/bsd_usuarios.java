package aplicacion_1;
import java.sql.*;
// Autor: Walter Dario Maza Cuadrado
// Esta clase es fundamental para conectar entre los usuarios y la red del servidor local.
public class bsd_usuarios {
    public static Connection conexion() { 
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=NetStockDB;encrypt=true;trustServerCertificate=true;loginTimeout=2;";
            String user = "$yst3m4_N3tStocK_K1127_90s1h2a_2s0n2e5t";
            String key = "4dm1nm4st3er_V1p_P45s_Xk1u51v3";
            return DriverManager.getConnection(url, user, key); 
        } catch (SQLException e) { return null; }
    }
    public static boolean login(String usuario, String contraseña) {
        try (Connection con = conexion()) { // con sql
            if (con != null) {
                String sql = "SELECT * FROM Usuarios WHERE Usuario = ? AND [Password] = ?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, usuario);  //le decimos al statement lo que queremos
                pst.setString(2, contraseña);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) return true;  //y lo ejecutamos si es que son verdaderos los datos para la consulta
            }
        } catch (SQLException e) { }  
        if (usuario.equals("admin") && contraseña.equals("1234")) return true;  //con la RAM
        else return false; 
    }
    public static void check() {
        try (Connection con = conexion()) {
            if (con == null) return;
            Statement st = con.createStatement();
            try {
                // Verificamos si hay usuarios
                ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM Usuarios");
                rs.next();
                if (rs.getInt(1) == 0) throw new Exception("Vacia");
            } catch (Exception e) {
                // Si falla o está vacía, creamos el admin
                System.out.println("Tabla vacía. Creando usuario 'admin'...");
                st.executeUpdate("INSERT INTO Usuarios (Usuario, [Password]) VALUES ('admin', '1234')");
            }
        } catch (SQLException ex) { }
    }
}