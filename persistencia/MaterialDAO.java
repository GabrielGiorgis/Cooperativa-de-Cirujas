package persistencia;

import Clases.Material;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MaterialDAO extends DAO {

    // CREATE
    public void create(int ciruja_id, Material material) throws Exception {
        try {
            if (material == null) {
                System.out.println("Es null ");
                throw new Exception("No válido");
            }
            String sql = "INSERT INTO Material(ciruja_id, tipo, peso) VALUES ('" + ciruja_id + "', '" + material.getTipo() + "', '" + material.getPeso() + "')";

            System.out.println(sql);
            agregarModificarEliminar(sql);
        } catch (Exception e) {
            throw new Exception("Error al guardar material" + e.getMessage());
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
    
    public ArrayList<Material> getAllByCirujaId(int idCiruja) throws Exception {
        try {
            String consulta = "SELECT * FROM Material WHERE ciruja_id = " + idCiruja + ";";

            consultarBase(consulta);

            ArrayList<Material> materiales = new ArrayList<>();
            Material material = null;

            while (resultado.next()) {
                material = new Material();
                material.setIdExtraccion(resultado.getInt(2));
                material.setPeso(resultado.getDouble(3));
                material.setTipo(resultado.getString(4));
                materiales.add(material);
            }

            return materiales;

        } catch (Exception e) {
            throw new Exception("Error al realizar la obtención");
        } finally {
            desconectarBase();
        }
    }

    // READ ALL
    public ArrayList<Material> getAll() throws Exception {
        try {
            String sql = "SELECT * FROM Material;";
            System.out.println(sql);

            consultarBase(sql);

            ArrayList<Material> listaMateriales = new ArrayList<>();

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
    public void update(int ciruja_id, Material material) throws Exception {
        try {
            if (material == null) {
                throw new Exception("No válido");
            }
            String sql = "UPDATE Material SET ciruja_id = " + ciruja_id + ", tipo = '"
                    + material.getTipo() + "', peso = " + material.getPeso()
                    + " WHERE idExtraccion = " + material.getIdExtraccion();
            System.out.println(sql);
            agregarModificarEliminar(sql);
        } catch (Exception e) {
            throw new Exception("Error al modificar");
        }
    }

    // DELETE ONE
    public void deleteOne(int idCiruja, int idMaterial) throws Exception {
        try {
            String query = "DELETE FROM Material WHERE ciruja_id = " + idCiruja + " AND idExtraccion = " + idMaterial + " ;";
            System.out.println(query);
            agregarModificarEliminar(query);
        } catch (Exception e) {
            throw e;
        }
    }

    // DELETE ALL
    public void deleteAll(int ciruja_id) throws Exception {
        try {

            String query = "DELETE FROM Material WHERE ciruja_id =" + ciruja_id + ";";
            System.out.println(query);
            agregarModificarEliminar(query);
        } catch (Exception e) {
            throw e;
        }
    }
}
