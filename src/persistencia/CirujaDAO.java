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

            String sql = "INSERT INTO Ciruja(nombre, especialidad, fechaIngreso) VALUES ('" + ciruja.getNombre() + "', '" + ciruja.getEspecialidad() + "', '" + new java.sql.Date(ciruja.getFechaIngreso().getTime().getTime()) + "')";
            agregarModificarEliminar(sql);
            System.out.println("flag 1");
            System.out.println(sql);
            CarroDAO carroDAO = new CarroDAO();
            carroDAO.create(ciruja.getId(), carro);

        } catch (Exception e) {
            throw new Exception("CirujaDAO Error al guardar " + e);
        }
    }

    // READ ONE
    public Ciruja getOne(int id) throws Exception {
        try {
            String sql = "SELECT * FROM Ciruja WHERE id = " + id;
            Ciruja ciruja = null;

            consultarBase(sql);
            if (resultado.next()) {
                ciruja = new Ciruja();
                ciruja.setId(resultado.getInt(1));
                ciruja.setNombre(resultado.getString(2));
                ciruja.setEspecialidad(resultado.getString(4));

                Calendar fechaIngreso = Calendar.getInstance();
                fechaIngreso.setTimeInMillis(resultado.getTimestamp(3).getTime());
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
                ciruja.setEspecialidad(resultado.getString(4));

                Calendar fechaIngreso = Calendar.getInstance();
                fechaIngreso.setTimeInMillis(resultado.getTimestamp(3).getTime());
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
                    materialDao.deleteOne(cirujaPrevio.getId(), cirujaPrevio.getMateriales().get(i).getIdExtraccion());
                }
            }
            String sql = "UPDATE Ciruja SET nombre = '" + ciruja.getNombre() + "', especialidad = '"
                    + ciruja.getEspecialidad() + "', fechaIngreso = '"
                    + new java.sql.Date(ciruja.getFechaIngreso().getTimeInMillis())
                    + "' WHERE id = " + ciruja.getId();
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
            ArrayList<Material> materiales = materialDao.getAllByCirujaId(id);

            if (!materiales.isEmpty()) {
                materialDao.deleteAll(id);
            }

            carroDao.delete(ciruja.getId());

            String query = "DELETE FROM Ciruja WHERE id = " + id + ";";
            System.out.println(query);
            agregarModificarEliminar(query);
        } catch (Exception e) {
            throw e;
        }
    }
}
