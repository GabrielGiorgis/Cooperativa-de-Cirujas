package persistencia;

import Clases.Carro;
import Clases.Ciruja;
import Clases.Material;
import Proyecto_p2.Main;
import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class CirujaDAO extends DAO {

    // CREATE
    public void create(Ciruja ciruja, Carro carro) throws Exception {
        try {
            if (ciruja == null) {
                throw new Exception("No válido");
            }

            String sql = "INSERT INTO Ciruja(nombre, especialidad, fechaIngreso) VALUES (*, *, *)";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, ciruja.getNombre());
            statement.setString(2, ciruja.getEspecialidad());
            statement.setDate(3, new java.sql.Date(ciruja.getFechaIngreso().getTimeInMillis()));

            int ciruja_id = Main.cooperativa.getCirujas().size();
            CarroDAO carroDAO = new CarroDAO();
            System.out.println("flag 1");
            carroDAO.create(ciruja_id, carro);

            MaterialDAO materialDAO = new MaterialDAO();
            if (ciruja.getMateriales().size() > 0) {
                for (int i = 0; i < ciruja.getMateriales().size(); i++) {
                    System.out.println("flag 2");
                    materialDAO.create(ciruja_id, ciruja.getMateriales().get(i));
                }
            }
            statement.executeUpdate();
            System.out.println(sql);
            System.out.println("flag 3");
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
    public ArrayList<Ciruja> getAll() throws Exception {
        try {
            String sql = "SELECT * FROM Ciruja;";
            System.out.println(sql);

            consultarBase(sql);

            ArrayList<Ciruja> listaCirujas = new ArrayList<>();

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
            MaterialDAO materialDao = new MaterialDAO();
            Ciruja cirujaPrevio = getOne(ciruja.getId());
            int cambios = 0;
            for (int i = 0; i < cirujaPrevio.getMateriales().size(); i++) {
                for (int j = 0; j < ciruja.getMateriales().size(); j++) {
                    if (cirujaPrevio.getMateriales().get(i).getIdExtraccion() == ciruja.getMateriales().get(i).getIdExtraccion()) {
                        cambios = 1;
                    }
                }
                if (cambios == 1) {
                    materialDao.deleteOne(cirujaPrevio.getMateriales().get(i).getIdExtraccion());
                }
            }
            String sql = "UPDATE Ciruja SET nombre = *, especialidad = *, fechaIngreso = * WHERE id = *";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, ciruja.getNombre());
            statement.setString(2, ciruja.getEspecialidad());
            statement.setDate(3, new java.sql.Date(ciruja.getFechaIngreso().getTimeInMillis()));
            statement.setInt(4, ciruja.getId());
            statement.executeUpdate();
            System.out.println(sql);
            agregarModificarEliminar(sql);
        } catch (Exception e) {
            throw new Exception("Error al modificar");
        }
    }

    // DELETE
    public void delete(int id) throws Exception {
        try {
            Ciruja ciruja = getOne(id);
            CarroDAO carroDao = new CarroDAO();
            MaterialDAO materialDao = new MaterialDAO();
            for (int i = 0; i < ciruja.getMateriales().size(); i++) {
                materialDao.deleteOne(ciruja.getMateriales().get(i).getIdExtraccion());
            }
            carroDao.delete(ciruja.getCarros().getId());
            String query = "DELETE FROM Ciruja WHERE id = " + id + ";";
            System.out.println(query);
            agregarModificarEliminar(query);
        } catch (Exception e) {
            throw e;
        }
    }
}
