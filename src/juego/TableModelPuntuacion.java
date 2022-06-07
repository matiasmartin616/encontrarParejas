/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recuperacionpracticas;

import BD.ConexionDB4O;
import BD.ControladorBD4O;
import BD.Puntuacion;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mst-m
 */
public class TableModelPuntuacion extends AbstractTableModel {

    ArrayList<Puntuacion> puntuaciones = new ArrayList();
    //static ArrayList<String> nombres = new ArrayList();
    final String[] header = {"Nombre", "Puntos"};

    public TableModelPuntuacion() throws SQLException {
        puntuaciones.addAll(ControladorBD4O.getInstance().obtenerPuntuaciones());
    }

    @Override
    public String getColumnName(int i) {
        return header[i];
    }

    @Override
    public int getRowCount() {
        return puntuaciones.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        switch (columna) {
            case 0:
                return puntuaciones.get(fila).getNombre();
            case 1:
                return puntuaciones.get(fila).getPuntuacion();
        }
        return null;
    }

    public void addPuntos(int puntos, String nombre) {
        Puntuacion puntuacion = new Puntuacion(nombre, puntos);
        puntuaciones.add(puntuacion);
        ControladorBD4O.getInstance().insertar(puntuacion);
        fireTableDataChanged();
    }

}
