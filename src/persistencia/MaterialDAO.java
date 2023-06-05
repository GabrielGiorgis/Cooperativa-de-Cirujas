package persistencia;

import Clases.Material;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MaterialDAO extends DAO {

    // CREATE
    public void create(Material material) throws Exception {
        try {
            if (material == null) {
                throw new Exception("No válido");
            }
            String sql = "INSERT INTO Material(tipo, peso) VALUES (?, ?)";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, material.getTipo());
            statement.setDouble(2, material.getPeso());

            System.out.println(sql);
            agregarModificarEliminar(sql);
        } catch (Exception e) {
            throw new Exception("Error al guardar");
        }
    }

    // READ ONE
    public Material getOne(int idExtraccion) throws Exception {
        try {
            String consulta = "SELECT * FROM Material WHERE idExtraccion = " + idExtraccion + ";";

            consultarBase(consulta);

            Material material = null;

            while (resultado.next()) {
                material = new Material();

                material.setIdExtraccion(resultado.getInt(1));
                material.setTipo(resultado.getString(2));
                material.setPeso(resultado.getDouble(3));
            }

            return material;

        } catch (Exception e) {
            throw new Exception("Error al realizar la obtención");
        } finally {
            desconectarBase();
        }
    }

    // READ ALL
    public List<Material> getAll() throws Exception {
        try {
            String sql = "SELECT * FROM Material;";
            System.out.println(sql);

            consultarBase(sql);

            List<Material> listaMateriales = new ArrayList<>();

            while (resultado.next()) {
                Material material = new Material();

                material.setIdExtraccion(resultado.getInt(1));
                material.setTipo(resultado.getString(2));
                material.setPeso(resultado.getDouble(3));

                listaMateriales.add(material);
            }
            return listaMateriales;
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    // UPDATE
    public void update(Material material) throws Exception {
        try {
            if (material == null) {
                throw new Exception("No válido");
            }
            String sql = "UPDATE Material SET tipo = ?, peso = ? WHERE idExtraccion = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, material.getTipo());
            statement.setDouble(2, material.getPeso());
            statement.setInt(2, material.getIdExtraccion());
            System.out.println(sql);
            agregarModificarEliminar(sql);
        } catch (Exception e) {
            throw new Exception("Error al modificar");
        }
    }

    // DELETE ONE
    public void deleteOne(int idExtraccion) throws Exception {
        try {

            String query = "DELETE FROM Material WHERE  = " + idExtraccion + ";";
            System.out.println(query);
            agregarModificarEliminar(query);
        } catch (Exception e) {
            throw e;
        }
    }

    // DELETE ALL
    public void deleteAll(int idExtraccion) throws Exception {
        try {

            String query = "DELETE FROM Material";
            System.out.println(query);
            agregarModificarEliminar(query);
        } catch (Exception e) {
            throw e;
        }
    }
}