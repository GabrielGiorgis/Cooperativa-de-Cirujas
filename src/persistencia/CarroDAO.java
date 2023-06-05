package persistencia;

import Clases.Carro;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO extends DAO {

    // CREATE
    public void create(Carro carro) throws Exception {
        try {
            if (carro == null) {
                throw new Exception("No válido");
            }
            String sql = "INSERT INTO Carro(cargaActual)"
                    + "VALUES(" + carro.getCargaActual() + ");";

            System.out.println(sql);
            agregarModificarEliminar(sql);
        } catch (Exception e) {
            throw new Exception("Error al guardar");
        }
    }

    // READ ONE
    public Carro getOne(int idCarro) throws Exception {
        try {
            String consulta = "SELECT * FROM Carro WHERE idCarro = " + idCarro + ";";

            consultarBase(consulta);

            Carro carro = null;

            while (resultado.next()) {
                carro = new Carro();

                carro.setId(resultado.getInt(1));
                carro.setCargaActual(resultado.getDouble(2));
            }

            return carro;

        } catch (Exception e) {
            throw new Exception("Erro al realizar la obtención");
        } finally {
            desconectarBase();
        }
    }

    // READ ALL
    public List<Carro> getAll() throws Exception {
        try {
            String sql = "SELECT * FROM Carro;";
            System.out.println(sql);

            consultarBase(sql);

            List<Carro> listaCarros = new ArrayList<>();

            while (resultado.next()) {
                Carro carro = new Carro();

                carro.setId(resultado.getInt(1));
                carro.setCargaActual(resultado.getDouble(2));

                listaCarros.add(carro);
            }
            return listaCarros;
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    // UPDATE
    public void update(Carro carro) throws Exception {
        try {
            if (carro == null) {
                throw new Exception("No válido");
            }
            String sql = "UPDATE Carro SET cargaActual = '" + carro.getCargaActual()
                    + "' WHERE idCarro = " + carro.getId() + ";";
            System.out.println(sql);
            agregarModificarEliminar(sql);
        } catch (Exception e) {
            throw new Exception("Error al modificar");
        }
    }

    // DELETE
    public void delete(int idCarro) throws Exception {
        try {

            String query = "DELETE FROM Carro WHERE idCarro = " + idCarro + ";";
            System.out.println(query);
            agregarModificarEliminar(query);
        } catch (Exception e) {
            throw e;
        }
    }
}
