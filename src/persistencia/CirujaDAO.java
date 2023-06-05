package persistencia;

import Clases.Ciruja;
import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class CirujaDAO extends DAO {

    // CREATE
    public void create(Ciruja ciruja) throws Exception {
        try {
            if (ciruja == null) {
                throw new Exception("No válido");
            }

            String sql = "INSERT INTO Ciruja(nombre, especialidad, fechaIngreso) VALUES (?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, ciruja.getNombre());
            statement.setString(2, ciruja.getEspecialidad());
            statement.setDate(3, new java.sql.Date(ciruja.getFechaIngreso().getTimeInMillis()));

            System.out.println(sql);
            agregarModificarEliminar(sql);

        } catch (Exception e) {
            throw new Exception("Error al guardar");
        }
    }

    // READ ONE
    public Ciruja getOne(int id) throws Exception {
        try {
            String sql = "SELECT * FROM Ciruja WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, id);

            Ciruja ciruja = null;

            if (resultado.next()) {
                ciruja = new Ciruja();

                ciruja.setId(resultado.getInt(1));
                ciruja.setNombre(resultado.getString(2));
                ciruja.setEspecialidad(resultado.getString(3));

                Calendar fechaIngreso = Calendar.getInstance();
                fechaIngreso.setTimeInMillis(resultado.getTimestamp(4).getTime());
                ciruja.setFechaIngreso(fechaIngreso);
            }

            return ciruja;

        } catch (Exception e) {
            throw new Exception("Error al realizar la obtención");
        } finally {
            desconectarBase();
        }
    }

    // READ ALL
    public List<Ciruja> getAll() throws Exception {
        try {
            String sql = "SELECT * FROM Ciruja;";
            System.out.println(sql);

            consultarBase(sql);

            List<Ciruja> listaCirujas = new ArrayList<>();

            while (resultado.next()) {
                Ciruja ciruja = new Ciruja();

                ciruja.setId(resultado.getInt(1));
                ciruja.setNombre(resultado.getString(2));
                ciruja.setEspecialidad(resultado.getString(3));

                Calendar fechaIngreso = Calendar.getInstance();
                fechaIngreso.setTimeInMillis(resultado.getTimestamp(4).getTime());
                ciruja.setFechaIngreso(fechaIngreso);

                listaCirujas.add(ciruja);
            }
            return listaCirujas;
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    // UPDATE
    public void update(Ciruja ciruja) throws Exception {
        try {
            if (ciruja == null) {
                throw new Exception("No válido");
            }
            String sql = "UPDATE Ciruja SET nombre = ?, especialidad = ?, fechaIngreso = ? WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, ciruja.getNombre());
            statement.setString(2, ciruja.getEspecialidad());
            statement.setDate(3, new java.sql.Date(ciruja.getFechaIngreso().getTimeInMillis()));
            statement.setInt(4, ciruja.getId());

            System.out.println(sql);
            agregarModificarEliminar(sql);
        } catch (Exception e) {
            throw new Exception("Error al modificar");
        }
    }

    // DELETE
    public void delete(int id) throws Exception {
        try {

            String query = "DELETE FROM Ciruja WHERE id = " + id + ";";
            System.out.println(query);
            agregarModificarEliminar(query);
        } catch (Exception e) {
            throw e;
        }
    }
}
