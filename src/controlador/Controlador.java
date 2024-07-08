/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import mundo.Logica;

/**
 *
 * @author nicor
 */
public class Controlador {

    public Logica logica;
    
    public Controlador(int var){
        this.logica = new Logica(var);
        logica.colocarFichas();
    }
    
    public String[][] getMatriz(){
        return logica.getMatriz();
    }
}
