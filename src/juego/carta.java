/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recuperacionpracticas;

import javax.swing.JButton;
import static recuperacionpracticas.imagenes.imagenesCartas;
import static recuperacionpracticas.imagenes.parteTrasera;

/**
 *
 * @author mst-m
 */
public class carta extends JButton{
    private boolean descubierta; private int codigoCarta;
    
    public carta(){
        super();
        descubierta = false;
        codigoCarta = this.codigoCarta;
        ocultarImagen();
        
    }
    
    public carta(int codigoCarta){
        super();
        descubierta = false;
        this.codigoCarta = codigoCarta;
        ocultarImagen();
        
    }
    
    public void mostrarImagen(){
            this.setIcon(imagenesCartas[codigoCarta]);
            descubierta = true;
    }
    
    public void ocultarImagen(){
        this.setIcon(parteTrasera);
        descubierta = false;
    }

    public boolean isDescubierta() {
        return descubierta;
    }

    public int getCodigoCarta() {
        return codigoCarta;
    }

    public void setDescubierta(boolean descubierta) {
        this.descubierta = descubierta;
        if(descubierta == false){
            ocultarImagen();
        }
        else{
            mostrarImagen();
        }
    }

    public void setCodigoCarta(int codigoCarta) {
        this.codigoCarta = codigoCarta;
    }
    
    public boolean sonIguales(carta carta){
        return carta.getCodigoCarta() == this.codigoCarta;
    }
}
