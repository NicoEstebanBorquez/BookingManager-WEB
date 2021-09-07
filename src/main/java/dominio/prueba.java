/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Soporte
 */
public class prueba {

    public static void main(String[] args) {
        AlojamientoDAO adao = new AlojamientoDAO();
        Alojamiento alojamiento = adao.encontrarPorId(13);
        //Alojamiento alojamiento = new Alojamiento();
//        alojamiento.setIdAlojamiento(95);
  //      alojamiento.setNombre("Casa Marta");

        System.out.println("############################# ID: " + alojamiento.getIdAlojamiento() + " - Nombre: " + alojamiento.getNombre() + "");

    }
}
