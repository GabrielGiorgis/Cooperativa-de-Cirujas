package persistencia;

import java.sql.*;

public class DAO {
    
    protected Connection conexion = null;
    protected Statement sentencia = null;
    protected ResultSet resultado = null;
    
    private String USUARIO = "root";
    private String CLAVE = "";
    private String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/cooperativa_cirujas";
    
    protected void conectarBase() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(CONTROLADOR);
            conexion = DriverManager.getConnection(url, USUARIO, CLAVE);
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }
    
    protected void desconectarBase() throws SQLException {
        try {
            if (sentencia != null) {
                sentencia.close();
            }
            if (resultado != null) {
                resultado.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
    
    protected void agregarModificarEliminar(String sql) throws SQLException, ClassNotFoundException {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException e) {
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                throw ex;
            }
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    protected void consultarBase(String sql) throws Exception {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (Exception e) {
            throw e;
        }
    }
}