/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recuperacionpracticas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mst-m
 */
public class TableModelPuntuacion extends AbstractTableModel{

    ArrayList<Integer> puntos = new ArrayList();
    
    
    @Override
    public int getRowCount() {
        return puntos.size();    
    }

    @Override
    public int getColumnCount() {
        return 1; 
    }

    @Override
    public Object getValueAt(int i, int i1) {
        return puntos.get(i);
    }
    
    public void addPuntos(int puntuacion){
        puntos.add(puntuacion);
        fireTableDataChanged();
    }
    
}
