/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebabd;
import db.connect_db;
/**
 *
 * @author Her&Fer
 */
public class PruebaBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connect_db.conectDB();
        connect_db.mostrarUsuarios();
    }
    
}
