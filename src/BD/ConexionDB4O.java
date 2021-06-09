package BD;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.ArrayList;

/**
 * Esta clase gestiona la conexión a una base de datos orientada a objetos DB4O
 *
 * @author Francisco Jesús Delgado Almirón
 * @author Juanjo Vega
 */
public class ConexionDB4O {

    // Objeto para almacenar la base de datos orientada a objetos
    private ObjectContainer bd;
    private final String rutabd;

    /**
     * Constructor por defecto
     *
     * @param rutabd Ruta del fichero .db4o para la base de datos orientada a
     * objetos
     */
    public ConexionDB4O(String rutabd) {
        bd = null;
        this.rutabd = rutabd;
    }

    /**
     * Conecta con la base de datos orientada a objetos
     *
     * @throws java.lang.Exception
     */
    public void conectar() throws Exception {
        bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), rutabd);
    }

    /**
     * Desconecta de la base de datos orientada objetos
     *
     * @throws java.lang.Exception
     */
    public void desconectar() throws Exception {
        bd.close();
    }

    public ArrayList<Puntuacion> obtenerPuntuaciones() {
        ArrayList<Puntuacion> puntuacion = new ArrayList<>();
        Puntuacion p = new Puntuacion (null, 0);
        ObjectSet<Puntuacion> result = bd.queryByExample(p);
        while (result.hasNext()){
            puntuacion.add(result.next());
        }
        return puntuacion;
    }

    public void insertar(Puntuacion puntuacion) {
        bd.store(puntuacion);
    }
}
