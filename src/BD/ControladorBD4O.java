/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juanjo Vega <juanjo.vega@gmail.com>
 */
public class ControladorBD4O {

    static final String DBFILE = "marcadores.db4o";
    static ControladorBD4O instance = null;
    static ConexionDB4O conexionDB4O;

    public static ControladorBD4O getInstance() {
        if (instance == null) {
            conexionDB4O = new ConexionDB4O(DBFILE);
            instance = new ControladorBD4O();
        }

        return instance;
    }

    /**
     * Conecta con la BD
     *
     * @throws SQLException Se lanzará si falla la conecxión con la BD
     */
    public void conectar() throws Exception {
        conexionDB4O.conectar();
        System.out.println("[Conectado]");
    }

    /**
     * Desconecta con la BD
     *
     * @throws SQLException Se lanzará si falla la conecxión con la BD
     */
    public void desconectar() throws Exception {
        conexionDB4O.desconectar();
        System.out.println("[Desconectado]");
    }

    public ArrayList<Puntuacion> obtenerPuntuaciones() throws SQLException {
        return conexionDB4O.obtenerPuntuaciones();
    }

    public void insertar(Puntuacion puntuacion) {
        conexionDB4O.insertar(puntuacion);
    }
}
